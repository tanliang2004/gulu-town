package com.gulutown.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 宠物科普（知识帖子）实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgePost {

    private Long postId;
    private String title;
    /**
     * 文章类型（1-养护，2-医疗，3-行为）
     */
    private Integer type;
    /**
     * 文章封面
     */
    private String avatar;
    /**
     * 文章内容
     */
    private String content;
    private LocalDateTime createTime;


}
