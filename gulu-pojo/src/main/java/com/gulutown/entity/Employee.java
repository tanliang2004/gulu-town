package com.gulutown.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理员实体类
 */
@Data
public class Employee {
    /**
     * 管理员ID
     */
    private Long id;
    /**
     * 管理员账号
     */
    private String name;
    /**
     * 管理员邮箱
     */
    private String email;
    /**
     * 管理账户密码
     */
    private String password;
    /**
     * 账户创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 最近一次登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;
}
