package com.gulutown.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取社区帖子统计数据
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommunityPostsVO {

    /**
     * 社区广场帖子总数
     */
    private Integer generalPosts;
    /**
     * 已找到宠物帖子总数
     */
    private Integer found;
    /**
     * 未找到宠物帖子总数
     */
    private Integer notFound;
    /**
     * 已找到和未找到总数
     */
    private Integer returnTotal;
    /**
     * 宠物科普数量
     */
    private Integer educationalPosts;
    /**
     * 所有帖子（包括广场和回家模块）
     */
    private Integer total;

}
