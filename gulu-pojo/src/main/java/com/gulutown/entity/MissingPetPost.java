package com.gulutown.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 失踪宠物实体
 */
@Data
@Builder
public class MissingPetPost {
    private Long postId;
    private Long userId;//发布用户id
    private String title;//失踪标题
    private Integer PetType;//宠物类型
    private LocalDateTime lostTime;//走失时间
    private String lostLocation;//走失地点
    private String contact;//联系方式
    private Integer status;//失踪状态（'寻找中','已找到'）
    private String latitude;//经度
    private String longitude;//纬度
    private LocalDateTime postCreateTime;//创建时间
}
