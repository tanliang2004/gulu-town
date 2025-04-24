package com.gulutown.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 获取订单趋势数据
 */
@Data
@Builder
public class RecentOrdersVO {
    private String label;
    private Integer orders;
    private Integer cancelled;
    private Integer pending;
    private Integer shipped;

}
