package com.gulutown.dto;

import lombok.Data;

/**
 * 管理员登录请求
 */
@Data
public class EmployeeLoginDTO {
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;
    /**
     * 账号
     */
    private String name;
}
