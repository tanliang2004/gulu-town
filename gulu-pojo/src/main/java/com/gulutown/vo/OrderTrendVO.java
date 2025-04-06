package com.gulutown.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class OrderTrendVO {
    private LocalDate date;
    private Integer count;

}
