package com.gulutown.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品分类分页查询
 */
@Data
public class ProductSortPageDTO implements Serializable {
    private Integer page;
    private Integer pageSize;
}
