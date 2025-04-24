package com.gulutown.service;

import com.gulutown.vo.CommunityPostsVO;
import com.gulutown.vo.RecentOrdersVO;
import com.gulutown.vo.StatsVO;
import com.gulutown.vo.UserGrowthVO;

import java.util.List;

public interface DashboardService {
    /**
     * 统计数据（宠物总数、用户总数、订单总数、今日新增用户）
     * @return 返回数据
     */
    StatsVO stats();

    /**
     * 获取特定时间周期（周、月、年）的用户增长数据
     * @param period 时间周期，可选值为 `week`、`month`、`year`
     * @return 返回数据
     */
    UserGrowthVO userGrowth(String period);

    /**
     * 获取社区帖子统计数据
     * @return 返回数据
     */
    CommunityPostsVO communityPosts();

    /**
     * 获取订单趋势数据
     * @param days 统计天数，可选择（7，15，30）
     * @return 返回数据
     */
    List<RecentOrdersVO> recentOrders(Integer days);
}
