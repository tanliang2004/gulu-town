package com.gulutown.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 获取特定时间周期（周、月、年）的用户增长数据。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserGrowthVO {
    private String[] labels;
    private Integer[] values;
}
