package com.gulutown.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    /**
     * 订单ID
     */
    private Long id;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;
    /**
     * 订单总数量
     */
    private Integer ItemCount;
    /**
     * 订单状态（0-待付款，1-已付款，2-已发货，3-已完成，4-已取消）
     */
    private Integer status;
    /**
     * 支付方式（0-未支付，1-微信支付，2-支付宝，3-银行卡，4-货到付款）
     */
    private Integer paymentMethod;
    /**
     * 支付时间
     */
    private LocalDateTime paymentTime;
    /**
     * 省份
     */
    private String addressProvince;
    /**
     * 城市
     */
    private String addressCity;
    /**
     * 区/县
     */
    private String addressDistrict;
    /**
     * 详情地址
     */
    private String addressDetail;
    /**
     * 快递单号
     */
    private String deliveryNo;
    /**
     * 订单备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
