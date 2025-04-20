package com.gulutown.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 订单状态变更明细
 */
@Data
@Builder
public class OrderStatusVO {
    private Long id;
    private Long orderId;
    private String orderNo;
    private Integer fromStatus;
    private Integer toStatus;
    private Long operatorId;
    private String operatorName;
    private String remark;
    private LocalDateTime createTime;
}
