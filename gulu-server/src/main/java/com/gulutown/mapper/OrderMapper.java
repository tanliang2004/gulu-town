package com.gulutown.mapper;

import com.github.pagehelper.Page;
import com.gulutown.dto.OrderPageDTO;
import com.gulutown.dto.OrderStatusDTO;
import com.gulutown.entity.Order;
import com.gulutown.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    Page<Order> pageQuery(OrderPageDTO orderPageDTO);

    OrderStatisticsVO statistics();

    List<OrderRegionCountVO> regionCount();

    List<OrderTrendVO> trend();

    @Select("select * from `order` where id = #{id}")
    Order selectById(Long id);

    @Select("select * from `order_item` where order_id = #{orderId}")
    List<OrderCommodityVO> selectProductById(Long orderId);

    @Select("select * from order_status where order_id = #{orderId}")
    List<OrderStatusVO> selectStatusById(Long OrderId);

    void updateStatusById(OrderStatusDTO orderStatusDTO);

    void insertStatus(OrderStatusVO orderStatus);
}
