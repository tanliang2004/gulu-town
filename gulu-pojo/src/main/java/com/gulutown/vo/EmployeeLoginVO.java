package com.gulutown.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员登录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeLoginVO {
    private Long id;
    private String name;
    private String email;
    private String token;
}
