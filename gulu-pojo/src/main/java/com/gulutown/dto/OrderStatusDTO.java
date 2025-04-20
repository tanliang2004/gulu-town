package com.gulutown.dto;

import lombok.Data;

/**
 * 订单状态变更
 */
@Data
public class OrderStatusDTO {
    private Long id;
    private Integer status;
    private String remark;
}
