package com.gulutown.mapper;

import com.github.pagehelper.Page;
import com.gulutown.entity.CommodityCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductCategoryMapper {

    Page<CommodityCategory> pageQuery();

    void insert(CommodityCategory commodityCategory);

    @Select("select * from commodity_category where id = #{id}")
    CommodityCategory queryById(Long id);

    void update(CommodityCategory commodityCategory);

    @Delete("delete from commodity_category where id = #{id}")
    void deleteById(Long id);
}
