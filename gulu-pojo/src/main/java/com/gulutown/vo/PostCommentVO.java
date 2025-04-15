package com.gulutown.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 评论实体类
 */
@Data
@Builder
public class PostCommentVO implements Serializable {
    private Long commentId;
    private Long targetId;
    private Long userId;
    private String avatar;//用户头像url
    private String username;//用户名
    private String content;//评论内容
    private LocalDateTime createTime;

}
