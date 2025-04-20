package com.gulutown.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * 订单趋势统计
 */
@Data
@Builder
public class OrderTrendVO {
    private LocalDate date;
    private Integer count;

}
