package com.sfh;


import cn.hutool.core.math.Calculator;
import com.alibaba.fastjson.JSON;
import com.sfh.db.IdGenerator;
import com.sfh.db.UserDAO;
import com.sfh.entity.UserDO;
import com.sfh.entity.UserVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

/**
 * 用户服务测试类
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {
    /** 模拟依赖对象 */
    /** 用户DAO */
    @Mock
    private UserDAO userDAO;
    /** 标识生成器 */
    @Mock
    private IdGenerator idGenerator;

    /** 定义被测对象 */
    /** 用户服务 */
    @InjectMocks
    private UserService userService;

    /**
     * 在测试之前
     */
    @Before
    public void beforeTest() {
        // 注入依赖对象
        Whitebox.setInternalState(userService, "canModify", Boolean.TRUE);
    }


    @Test
    public void testAdd() throws Exception {
        UserService cal = PowerMockito.spy(new UserService());

        PowerMockito.doReturn(2).when(cal,"sumXX", anyInt(), anyInt());
        int i = cal.callSumXX(1, 2);
        System.out.println(i);
        assertEquals(2, cal.callSumXX(1, 2));

        PowerMockito.when(cal,"sumXX",anyInt(), anyInt()).thenReturn(2);
        assertEquals(2, cal.callSumXX(1, 2));
    }

    /**
     * 测试: 创建用户-新
     */
    @Test
    public void testCreateUserWithNew() {
        // 模拟依赖方法
        // 模拟依赖方法: userDAO.getByName
        Mockito.doReturn(null).when(userDAO).getIdByName(Mockito.anyString());
        // 模拟依赖方法: idGenerator.next
        Long userId = 1L;
        Mockito.doReturn(userId).when(idGenerator).next();

        // 调用被测方法
        String text = ResourceHelper.getResourceAsString(getClass(),"userCreateVO.json");
        UserVO userCreate = JSON.parseObject(text, UserVO.class);
        assertEquals("用户标识不一致", userId, userService.createUser(userCreate));

        // 验证依赖方法
        // 验证依赖方法: userDAO.getByName
        Mockito.verify(userDAO).getIdByName(userCreate.getName());
        // 验证依赖方法: idGenerator.next
        Mockito.verify(idGenerator).next();
        // 验证依赖方法: userDAO.create
        ArgumentCaptor<UserDO> userCreateCaptor = ArgumentCaptor.forClass(UserDO.class);
        Mockito.verify(userDAO).create(userCreateCaptor.capture());
        text = ResourceHelper.getResourceAsString(getClass(), "userCreateDO.json");


        assertEquals("用户创建不一致", text, JSON.toJSONString(userCreateCaptor.getValue()));

        // 验证依赖对象
        Mockito.verifyNoMoreInteractions(idGenerator, userDAO);
    }

    /**
     * 测试: 创建用户-旧
     */
    @Test
    public void testCreateUserWithOld() {
        // 模拟依赖方法
        // 模拟依赖方法: userDAO.getByName
        Long userId = 1L;
        Mockito.doReturn(userId).when(userDAO).getIdByName(Mockito.anyString());

        // 调用被测方法
        String text = ResourceHelper.getResourceAsString(getClass(), "userCreateVO.json");
        UserVO userCreate = JSON.parseObject(text, UserVO.class);
        assertEquals("用户标识不一致", userId, userService.createUser(userCreate));

        // 验证依赖方法
        // 验证依赖方法: userDAO.getByName
        Mockito.verify(userDAO).getIdByName(userCreate.getName());
        // 验证依赖方法: userDAO.modify
        ArgumentCaptor<UserDO> userModifyCaptor = ArgumentCaptor.forClass(UserDO.class);
        Mockito.verify(userDAO).modify(userModifyCaptor.capture());
        text = ResourceHelper.getResourceAsString(getClass(), "userModifyDO.json");
        assertEquals("用户修改不一致", text, JSON.toJSONString(userModifyCaptor.getValue()));

        // 验证依赖对象是否全部被调用
        Mockito.verifyNoMoreInteractions(idGenerator);
        Mockito.verifyNoMoreInteractions(userDAO);
    }

    /**
     * 测试: 创建用户-异常
     */
    @Test
    public void testCreateUserWithException() {
        // 注入依赖对象
        Whitebox.setInternalState(userService, "canModify", Boolean.FALSE);

        // 模拟依赖方法
        // 模拟依赖方法: userDAO.getByName
        Long userId = 1L;
        Mockito.doReturn(userId).when(userDAO).getIdByName(Mockito.anyString());

        // 调用被测方法
        String text = ResourceHelper.getResourceAsString(getClass(), "userCreateVO.json");
        UserVO userCreate = JSON.parseObject(text, UserVO.class);
//        UnsupportedOperationException exception = Assert.assertThrows("返回异常不一致",
//                UnsupportedOperationException.class, () -> userService.createUser(userCreate));
//        Assert.assertEquals("异常消息不一致", "不支持修改", exception.getMessage());
    }
}
