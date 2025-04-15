package com.gulutown.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 评论实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostComment {
    private Long commentId;
    private Long targetId;
    private Long userId;
    private String content;//评论内容
    private LocalDateTime createTime;
}
