package com.gulutown.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 社区广场实体返回
 */
@Data
@Builder
public class SquarePostVO {
    private Long postId;
    private Long userId;
    private String username;//用户名
    /**
     * 用户性别（0-未知，1-男，2-女）
     */
    private Integer gender;
    /**
     * 用户头像URL
     */
    private String avatar;
    private String content;
    private Integer likes;
    private Integer comments;
    private String longitude;//经度
    private String latitude;
    private LocalDateTime createTime;
    /**
     * 帖子图片
     */
    private List<String> imageUrl;

}
