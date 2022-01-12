package com.sfh.datacheck;

import com.sfh.entity.BaseResult;
import com.sfh.entity.DataCheckRequestDTO;

public interface DataCheckProductService {


    /**
     * 模板方法模式
     * 数据检查
     * @param requestDTO 请求参数
     * */
    <T> BaseResult<Long> dataCheck(DataCheckRequestDTO requestDTO);
}
