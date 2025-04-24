package com.gulutown.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetInfo {

    private Long petId;
    private Long userId;
    private String petName;
    private Integer petType;
    private String image;
    /**
     * 宠物状态
     * （1-发呆，2-睡觉，3-活跃，4-饥饿）
     */
    private Integer status;
    /**
     * 宠物性别（1-弟弟，2-妹妹）
     */
    private Character gender;
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

}
