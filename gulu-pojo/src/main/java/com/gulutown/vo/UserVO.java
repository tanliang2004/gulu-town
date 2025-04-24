package com.gulutown.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 性别（0-未知，1-男，2-女）
     */
    private Integer gender;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 头像url
     */
    private String avatar;
    /**
     * 当前积分
     */
    private Integer points;
    /**
     * 注册时间
     */
    private LocalDateTime createTime;
    /**
     * 最后登录时间
     */
    private LocalDateTime lastLogin;
}
