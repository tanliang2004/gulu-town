package com.gulutown.vo;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderStatisticsVO {
    private Long totalOrders;
    private Long pendingPayment;
    private Long pendingShipment;
    private Long completed;
    private Long cancelled;
    private BigDecimal totalAmount;
}
