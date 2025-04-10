package com.gulutown.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gulutown.context.BaseContext;
import com.gulutown.dto.OrderPageDTO;
import com.gulutown.dto.OrderStatusDTO;
import com.gulutown.entity.Employee;
import com.gulutown.entity.Order;
import com.gulutown.mapper.EmployeeMapper;
import com.gulutown.mapper.OrderMapper;
import com.gulutown.result.PageResult;
import com.gulutown.result.Result;
import com.gulutown.service.OrderService;
import com.gulutown.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 订单详情分页查询
     *
     * @param orderPageDTO 分页筛选数据
     * @return 返回数据
     */
    public PageResult page(OrderPageDTO orderPageDTO) {
        PageHelper.startPage(orderPageDTO.getPage(), orderPageDTO.getPageSize());
        Page<Order> page = orderMapper.pageQuery(orderPageDTO);
        return new PageResult(
                page.getTotal(),
                page.getResult()
        );
    }

    /**
     * 订单数据统计
     *
     * @return 返回数据
     */
    public OrderStatisticsVO statistics() {
        //订单总数 待付款订单 代发货订单 已完成订单 取消订单 总金额
        return orderMapper.statistics();
    }

    /**
     * 获取地区订单数量分布
     *
     * @return 返回数据
     */
    public List<OrderRegionCountVO> regionCount() {
        return orderMapper.regionCount();
    }

    /**
     * 获取近七天订单趋势
     *
     * @return 返回数据
     */
    public List<OrderTrendVO> trend() {
        return orderMapper.trend();
    }

    /**
     * 根据订单id查询订单
     *
     * @param id 订单id
     * @return 返回数据
     */
    public Order queryById(Long id) {
        return orderMapper.selectById(id);
    }

    /**
     * 根据订单id查询商品信息
     *
     * @param id 订单id
     * @return 返回数据
     */
    public List<OrderCommodityVO> queryProductById(Long id) {
        List<OrderCommodityVO> orderCommodityVOS = orderMapper.selectProductById(id);
        for (OrderCommodityVO orderCommodityVO : orderCommodityVOS) {
            BigDecimal resultPrice = orderCommodityVO.getPrice().multiply(new BigDecimal(orderCommodityVO.getQuantity()));
            orderCommodityVO.setSubtotal(resultPrice);
        }
        return orderCommodityVOS;
    }

    /**
     * 根据订单id查询订单状态变更明细
     *
     * @param id 订单id
     * @return 返回数据
     */
    public List<OrderStatusVO> queryStatusById(Long id) {
        return orderMapper.selectStatusById(id);
    }

    /**
     * 修改指定订单状态
     *
     * @param orderStatusDTO 修改订单数据
     */
    @Transactional
    public void edisStatusById(OrderStatusDTO orderStatusDTO) {
        //根据id查询订单
        Order order = orderMapper.selectById(orderStatusDTO.getId());
        //修改订单状态
        orderMapper.updateStatusById(orderStatusDTO);
        //获取当前管理员id
        Long id = BaseContext.getCurrentId();
        //根据id查询管理员信息
        Employee employee = employeeMapper.selectById(id);
        //封装OrderStatusVO对象
        OrderStatusVO orderStatus = OrderStatusVO.builder()
                .orderId(order.getId()).orderNo(order.getOrderNo())
                .fromStatus(order.getStatus()).toStatus(orderStatusDTO.getStatus())
                .operatorId(id).operatorName(employee.getName())
                .remark(orderStatusDTO.getRemark())
                .createTime(LocalDateTime.now()).build();
        //添加订单状态变更记录
        orderMapper.insertStatus(orderStatus);
    }
}
