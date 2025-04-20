package com.gulutown.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 社区广场帖子实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SquarePost {
    private Long postId;
    private Long userId;
    private String content;
    private Integer likes;
    private Integer comments;
    private String longitude;//经度
    private String latitude;//纬度
    private LocalDateTime createTime;

}
