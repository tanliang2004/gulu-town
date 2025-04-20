package com.gulutown.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 点赞实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostLike {

    private Long likeId;
    private Long targetId;//对应帖子id
    private Long userId;//用户id
    private LocalDateTime createTime;


}
