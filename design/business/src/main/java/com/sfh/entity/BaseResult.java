package com.sfh.entity;

/**
 * @user sfh
 * @date 2021/8/3 16:21
 */
public class BaseResult <T>{
    public static BaseResult<Long> ofFail(String right) {
        return null;
    }

    public static BaseResult<Long> ofSuccess(Long id) {
        return null;
    }
}
