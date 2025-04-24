package com.gulutown.controller.admin;

import com.gulutown.result.Result;
import com.gulutown.service.DashboardService;
import com.gulutown.vo.CommunityPostsVO;
import com.gulutown.vo.RecentOrdersVO;
import com.gulutown.vo.StatsVO;
import com.gulutown.vo.UserGrowthVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工作太数据统计
 */
@RestController
@RequestMapping("/admin/dashboard")
@Slf4j
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    /**
     * 统计数据（宠物总数、用户总数、订单总数、今日新增用户）
     *
     * @return 返回数据
     */
    @GetMapping("/stats")
    public Result<StatsVO> stats() {
        log.info("统计数据（宠物总数、用户总数、订单总数、今日新增用户）");
        StatsVO statsVO = dashboardService.stats();
        return Result.success(statsVO);
    }

    /**
     * 获取特定时间周期（周、月、年）的用户增长数据。
     *
     * @param period 时间周期，可选值为 `week`、`month`、`year`
     * @return 返回数据
     */
    @GetMapping("/user-growth")
    public Result<UserGrowthVO> userGrowth(@RequestParam String period) {
        log.info("获取特定时间周期（周、月、年）的用户增长数据:{}", period);
        UserGrowthVO userGrowthVO = dashboardService.userGrowth(period);
        return Result.success(userGrowthVO);
    }

    /**
     * 获取社区帖子统计数据
     *
     * @return 返回数据
     */
    @GetMapping("/community-posts")
    public Result<CommunityPostsVO> communityPosts() {
        log.info("获取社区帖子类型分布数据");
        CommunityPostsVO communityPostsVO = dashboardService.communityPosts();
        return Result.success(communityPostsVO);
    }

    /**
     * 获取订单趋势数据
     *
     * @param days 统计天数，可选择（7，15，30）
     * @return 返回数据
     */
    @GetMapping("/recent-orders")
    public Result<List<RecentOrdersVO>> recentOrders(@RequestParam Integer days) {
        log.info("获取订单趋势数据，{}", days);
        List<RecentOrdersVO> recentOrdersVOS = dashboardService.recentOrders(days);
        return Result.success(recentOrdersVOS);
    }
}
