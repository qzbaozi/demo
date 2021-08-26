package com.sfh;

import com.sfh.entity.BaseResult;
import com.sfh.entity.DataCheckRequestDTO;
import com.sfh.entity.Pair;
import com.sfh.entity.RouteTaskRecordDO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @user sfh
 * @date 2021/8/3 16:16
 */
public abstract class AbstractDataCheckProductService implements DataCheckProductService {

    /**
     * 数据检查
     *
     * @param requestDTO 请求参数
     * @return
     */
    @Override
    public <T> BaseResult<Long> dataCheck(DataCheckRequestDTO requestDTO) {
        try {
            //1. 参数合法性检查
            Pair<Boolean, String> paramCheckResult = commonParamCheck(requestDTO);
            if (!paramCheckResult.getLeft()) {
                return BaseResult.ofFail(paramCheckResult.getRight());
            }

            //2. 创建导出任务
            String fileName = createFileName(requestDTO);
            RouteTaskRecordDO taskRecordDO = createTaskRecord(fileName, requestDTO.getUserName());

            //3. 进行数据检查
            List<T> resultList = Collections.synchronizedList(new ArrayList<>());
            runDataCheck(resultList, requestDTO);

            //4. 写入文件
            String ossUrl = uploadToOSS(fileName, resultList);
            //5. 更新任务为完成状态
            updateRouteTask(taskRecordDO.getId(), DDportTaskStatus.FINISHED.intValue(), resultList.size() - 1, "", ossUrl);

            return BaseResult.ofSuccess(taskRecordDO.getId());
        } catch (Exception e) {
            return BaseResult.ofFail(e.getMessage());
        }
    }

    protected void updateRouteTask(Long id, int intValue, int size, String s, String ossUrl) {

    }

    protected <T> String uploadToOSS(String fileName, List<T> resultList) {
        return null;
    }

    protected RouteTaskRecordDO createTaskRecord(String fileName, Object userName) {
        return null;
    }

    protected String createFileName(DataCheckRequestDTO requestDTO) {
        return null;
    }

    protected Pair commonParamCheck(DataCheckRequestDTO requestDTO) {
        return null;
    }

    /**
     * 进行数据检查
     *
     * @param resultList 存放检查结果
     * @param requestDTO 请求参数
     * @return
     */
    public abstract <T> void runDataCheck(List<T> resultList, DataCheckRequestDTO requestDTO);





    /**
     * 检查资源映射和编码映射一致
     *
     * @author xxx
     * @since xxx
     */
    public class CheckSupplierAndCodeMappingService extends AbstractDataCheckProductService {
        @Override
        public <T> void runDataCheck(List<T> resultList, DataCheckRequestDTO requestDTO) {
            //自己的检查逻辑
        }
    }

    /**
     * 检查区域内落地配必须三级全覆盖
     *
     * @author xxx
     * @since xxx
     */
    public class CheckLandingCoverAreaService extends AbstractDataCheckProductService {
        @Override
        public <T> void runDataCheck(List<T> resultList, DataCheckRequestDTO requestDTO) {
            //自己的检查逻辑
        }
    }

    /**
     * 检查资源映射和编码映射一致
     *
     * @author xxx
     * @since xxx
     */
    public class CheckAncPathNoServiceService extends AbstractDataCheckProductService {
        @Override
        public <T> void runDataCheck(List<T> resultList, DataCheckRequestDTO requestDTO) {
            //自己的检查逻辑
        }
    }
}