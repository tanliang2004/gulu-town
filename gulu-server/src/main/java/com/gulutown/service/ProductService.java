package com.gulutown.service;

import com.gulutown.dto.CommodityDTO;
import com.gulutown.dto.ProductPageDTO;
import com.gulutown.entity.CommodityInfo;
import com.gulutown.result.PageResult;

public interface ProductService {

    /**
     * 分页查询商品
     * @param productPageDTO 分页数据
     * @return 返回数据
     */
    PageResult pageQuery(ProductPageDTO productPageDTO);

    /**
     * 添加商品
     * @param commodityDTO 添加的具体数据
     */
    void add(CommodityDTO commodityDTO);

    /**
     * 根据商品id查询商品
     * @param id 商品id
     * @return 返回数据
     */
    CommodityInfo queryById(Long id);

    /**
     * 修改商品
     * @param commodityDTO 修改数据
     */
    void edit(CommodityDTO commodityDTO);

    /**
     * 根据id删除商品
     * @param id 商品id
     */
    void remove(Long id);
}
