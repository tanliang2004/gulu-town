package com.gulutown.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetInfoVO {

    //宠物信息
    private String petName;
    /**
     * 宠物分类id
     */
    private Integer categoryId;
    private String image;
    /**
     * 宠物状态
     * （1-发呆，2-睡觉，3-活跃，4-饥饿）
     */
    private Integer status;
    /**
     * 宠物性别（1-弟弟，2-妹妹）
     */
    private Character petGender;
    private LocalDate dateBirth;
    private Double weight;
    /**
     * 绝育状态（1-是，2-否）
     */
    private Integer sterilizationStatus;
    private String personality;
    /**
     * 宠物标签
     */
    private String label;
    private LocalDateTime createTime;

    //宠物分类信息
    private String type;
    private String petType;

    //用户信息
    private String username;
    private String avatar;
    private Integer gender;

}
