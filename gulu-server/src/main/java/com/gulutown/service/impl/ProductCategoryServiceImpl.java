package com.gulutown.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gulutown.dto.CommodityCategoryDTO;
import com.gulutown.dto.ProductSortPageDTO;
import com.gulutown.entity.CommodityCategory;
import com.gulutown.mapper.ProductCategoryMapper;
import com.gulutown.mapper.ProductMapper;
import com.gulutown.result.PageResult;
import com.gulutown.service.ProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Autowired
    private ProductMapper productMapper;

    /**
     * 商品分类分页查询
     *
     * @param productSortPageDTO 分页数据
     * @return 响应
     */
    public PageResult page(ProductSortPageDTO productSortPageDTO) {
        PageHelper.startPage(productSortPageDTO.getPage(), productSortPageDTO.getPageSize());
        Page<CommodityCategory> page = productCategoryMapper.pageQuery();
        return PageResult.builder()
                .total(page.getTotal())
                .records(page.getResult())
                .build();
    }

    /**
     * 添加新商品分类
     * @param commodityCategoryDTO 前端传入数据
     */
    public void add(CommodityCategoryDTO commodityCategoryDTO) {
        CommodityCategory commodityCategory = new CommodityCategory();
        BeanUtils.copyProperties(commodityCategoryDTO,commodityCategory);
        commodityCategory.setCreateTime(LocalDateTime.now());
        //如果用户没有输入排序，默认是1
        if (commodityCategory.getSortOrder() == null) {
            commodityCategory.setSortOrder(1);
        }
        productCategoryMapper.insert(commodityCategory);
    }

    /**
     * 根据id查询商品分类
     * @param id 商品分类id
     * @return 响应数据
     */
    public CommodityCategory queryById(Long id) {
        return productCategoryMapper.queryById(id);
    }

    /**
     * 修改商品分类信息
     * @param commodityCategoryDTO 前端传入数据
     */
    public void edit(CommodityCategoryDTO commodityCategoryDTO) {
        CommodityCategory commodityCategory = new CommodityCategory();
        BeanUtils.copyProperties(commodityCategoryDTO,commodityCategory);
        productCategoryMapper.update(commodityCategory);
    }

    /**
     * 根据ID删除商品分类
     * @param id 删除商品分类的ID
     */
    @Transactional
    public void remove(Long id) {
        //根据商品分类id删除对应的商品
        productMapper.deleteByCateGoryId(id);
        productCategoryMapper.deleteById(id);
    }

    /**
     * 查询商品分类
     * @return 返回数据
     */
    public List<CommodityCategory> queryAll() {
        return productCategoryMapper.selectAll();
    }
}
