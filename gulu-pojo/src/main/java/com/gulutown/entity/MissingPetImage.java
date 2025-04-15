package com.gulutown.entity;

import lombok.Builder;
import lombok.Data;


/**
 * 失踪宠物图片实体
 */
@Data
@Builder
public class MissingPetImage {
    private Long imageId;
    private Long postId;//帖子id
    private String imageUrl;//图片地址
}
