package com.gulutown.mapper;

import com.github.pagehelper.Page;
import com.gulutown.dto.ProductPageDTO;
import com.gulutown.entity.CommodityInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {
    Page<CommodityInfo> selectByAll(ProductPageDTO productPageDTO);

    void insert(CommodityInfo commodityInfo);

    @Select("select * from commodity_info where id = #{id}")
    CommodityInfo selectById(Long id);

    void update(CommodityInfo commodityInfo);

    @Delete("delete from commodity_info where id = #{id}")
    void deleteById(Long id);

    @Delete("delete from commodity_info where category_id = #{id}")
    void deleteByCateGoryId(Long id);
}
