package com.gulutown.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRegionCountVO {
    private String region;
    private Long count;
}
