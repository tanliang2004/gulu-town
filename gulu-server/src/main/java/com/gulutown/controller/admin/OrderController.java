package com.gulutown.controller.admin;


import com.gulutown.dto.OrderPageDTO;
import com.gulutown.dto.OrderStatusDTO;
import com.gulutown.entity.Order;
import com.gulutown.result.PageResult;
import com.gulutown.result.Result;
import com.gulutown.service.OrderService;
import com.gulutown.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单相关接口
 */
@RestController
@RequestMapping("/admin/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单详情分页查询
     * @param orderPageDTO 分页筛选数据
     * @return 返回数据
     */
    @GetMapping("/page")
    public Result<PageResult> page(OrderPageDTO orderPageDTO) {
        log.info("订单分页查询，{}",orderPageDTO);
        PageResult pageResult = orderService.page(orderPageDTO);
        return Result.success(pageResult);
    }

    /**
     * 统计数据信息
     * @return 返回数据
     */
    @GetMapping("/statistics")
    public Result<OrderStatisticsVO> statistics() {
        log.info("订单数据统计");
        OrderStatisticsVO orderStatisticsVO = orderService.statistics();
        return Result.success(orderStatisticsVO);
    }

    /**
     * 获取地区订单数量分布
     * @return 返回数据
     */
    @GetMapping("/regionCount")
    public Result<List<OrderRegionCountVO>> regionCount() {
        log.info("获取地区订单数量分布");
        List<OrderRegionCountVO> orderRegionCountVOS = orderService.regionCount();
        return Result.success(orderRegionCountVOS);
    }

    /**
     * 获取近七天订单趋势
     * @return 返回数据
     */
    @GetMapping("/trend")
    public Result<List<OrderTrendVO>> trend() {
        log.info("获取近七天订单趋势");
        List<OrderTrendVO> orderTrendVOS = orderService.trend();
        return Result.success(orderTrendVOS);
    }

    /**
     * 根据订单id查询订单
     * @return 返回数据
     */
    @GetMapping("/{id}")
    public Result<Order> QueryById(@PathVariable Long id) {
        log.info("根据id查询订单,{}",id);
        Order order = orderService.queryById(id);
        return Result.success(order);
    }

    /**
     * 根据订单id查询商品信息
     * @return 返回数据
     */
    @GetMapping("/{id}/items")
    public Result<List<OrderCommodityVO>> queryProductById(@PathVariable Long id) {
        log.info("根据id查询商品,{}",id);
        List<OrderCommodityVO> orderCommodityVOS = orderService.queryProductById(id);
        return Result.success(orderCommodityVOS);
    }

    /**
     * 根据订单id查询订单状态变更明细
     * @return 返回数据
     */
    @GetMapping("/{id}/status")
    public Result<List<OrderStatusVO>> queryStatusById(@PathVariable Long id) {
        log.info("根据订单id查询订单状态变更明细,{}",id);
        List<OrderStatusVO> orderStatusVOS = orderService.queryStatusById(id);
        return Result.success(orderStatusVOS);
    }

    /**
     * 修改指定订单状态
     * @return 响应
     */
    @PutMapping("/status")
    public Result editStatusById(@RequestBody OrderStatusDTO orderStatusDTO) {
        log.info("修改指定订单状态,{}",orderStatusDTO);
        orderService.edisStatusById(orderStatusDTO);
        return Result.success();
    }

}
