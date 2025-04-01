package com.gulutown.service;

import com.gulutown.dto.CommodityCategoryDTO;
import com.gulutown.dto.ProductSortPageDTO;
import com.gulutown.entity.CommodityCategory;
import com.gulutown.result.PageResult;

public interface ProductCategoryService {

    /**
     * 商品分类分页查询
     * @param productSortPageDTO 分页数据
     * @return 响应
     */
    PageResult page(ProductSortPageDTO productSortPageDTO);

    /**
     * 添加新商品分类
     * @param commodityCategoryDTO 前端传入数据
     */
    void add(CommodityCategoryDTO commodityCategoryDTO);

    /**
     * 根据id查询商品分类
     * @param id 商品分类id
     * @return 响应数据
     */
    CommodityCategory queryById(Long id);

    /**
     * 修改商品分类信息
     * @param commodityCategoryDTO 前端传入数据
     */
    void edit(CommodityCategoryDTO commodityCategoryDTO);

    /**
     * 根据ID删除商品分类
     * @param id 删除商品分类的ID
     */
    void remove(Long id);
}
