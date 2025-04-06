package com.gulutown.service;

import com.gulutown.dto.OrderPageDTO;
import com.gulutown.dto.OrderStatusDTO;
import com.gulutown.entity.Order;
import com.gulutown.result.PageResult;
import com.gulutown.vo.*;

import java.util.List;

public interface OrderService {

    /**
     * 订单详情分页查询
     * @param orderPageDTO 分页筛选数据
     * @return 返回数据
     */
    PageResult page(OrderPageDTO orderPageDTO);

    /**
     * 订单数据统计
     * @return 返回数据
     */
    OrderStatisticsVO statistics();

    /**
     * 获取地区订单数量分布
     * @return 返回数据
     */
    List<OrderRegionCountVO> regionCount();

    /**
     * 获取近七天订单趋势
     * @return 返回数据
     */
    List<OrderTrendVO> trend();

    /**
     * 根据订单id查询订单
     * @param id 订单id
     * @return 返回数据
     */
    Order queryById(Long id);

    /**
     * 根据订单id查询商品信息
     * @param id 订单id
     * @return 返回数据
     */
    List<OrderCommodityVO> queryProductById(Long id);

    /**
     * 根据订单id查询订单状态变更明细
     * @param id 订单id
     * @return 返回数据
     */
    List<OrderStatusVO> queryStatusById(Long id);

    /**
     * 修改指定订单状态
     * @param orderStatusDTO 修改订单数据
     */
    void edisStatusById(OrderStatusDTO orderStatusDTO);
}
