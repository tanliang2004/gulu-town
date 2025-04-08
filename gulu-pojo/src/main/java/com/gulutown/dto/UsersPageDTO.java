package com.gulutown.dto;

import lombok.Data;

/**
 * 用户分页查询
 */
@Data
public class UsersPageDTO {
    private Integer page;
    private Integer pageSize;
    private String keyWord;
}
