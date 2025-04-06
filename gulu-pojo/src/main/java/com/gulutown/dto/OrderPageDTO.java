package com.gulutown.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 订单分页查询
 */
@Data
public class OrderPageDTO implements Serializable {
    private Integer page;
    private Integer pageSize;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 订单状态（0-待付款，1-已付款，2-已发货，3-已完成，4-已取消）
     */
    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

}
