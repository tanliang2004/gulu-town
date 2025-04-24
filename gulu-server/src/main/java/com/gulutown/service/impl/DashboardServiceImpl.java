package com.gulutown.service.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gulutown.mapper.DashboardMapper;
import com.gulutown.service.DashboardService;
import com.gulutown.vo.CommunityPostsVO;
import com.gulutown.vo.RecentOrdersVO;
import com.gulutown.vo.StatsVO;
import com.gulutown.vo.UserGrowthVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardMapper dashboardMapper;

    /**
     * 统计数据（宠物总数、用户总数、订单总数、今日新增用户）
     *
     * @return 返回数据
     */
    @Transactional
    public StatsVO stats() {
        //查询宠物总数
        Integer totalPets = dashboardMapper.totalPets();
        //查询用户总数
        Integer totalUsers = dashboardMapper.totalUsers();
        //查询订单总数
        Integer totalOrders = dashboardMapper.totalOrders();
        //查询今日新增用户
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate now = LocalDate.now();
        String begin = LocalDateTime.of(now, LocalTime.MIN).format(formatter);
        String end = LocalDateTime.of(now, LocalTime.MAX).format(formatter);
        System.out.println(begin + "///" + end);
        Integer newUsersToday = dashboardMapper.newUsersToday(begin, end);
        System.out.println(newUsersToday);
        return StatsVO.builder()
                .newUsersToday(newUsersToday)
                .totalOrders(totalOrders)
                .totalUsers(totalUsers)
                .totalPets(totalPets)
                .build();
    }

    /**
     * 获取特定时间周期（周、月、年）的用户增长数据
     *
     * @param period 时间周期，可选值为 `week`、`month`、`year`
     * @return 返回数据
     */
    public UserGrowthVO userGrowth(String period) {
        //判断用户所选的period
        UserGrowthVO userGrowthVO = new UserGrowthVO();
        //获取当前系统时间和时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //获取系统时间前一天的最后时刻
        String end = LocalDateTime.of(LocalDate.now().plusDays(-1), LocalTime.MAX).format(formatter);
        switch (period) {
            case "week":
                //本周的用户数据统计
                userGrowthVO.setLabels(new String[]{"周一", "周二", "周三", "周四", "周五", "周六", "周天"});
                userGrowthVO.setValues(dashboardMapper.userGrowthWeek());
                break;
            case "month":
                //本月的用户统计
                userGrowthVO.setLabels(dashboardMapper.userGrowthMonthString());
                userGrowthVO.setValues(dashboardMapper.userGrowthMonthValue());
                break;
            case "year":
                //本年的用户统计
                userGrowthVO.setLabels(new String[]{"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"});
                userGrowthVO.setValues(dashboardMapper.userGrowthYear());
                break;
        }
        return userGrowthVO;
    }

    /**
     * 获取社区帖子统计数据
     * @return 返回数据
     */
    @Transactional
    public CommunityPostsVO communityPosts() {
        //获取社区广场帖子总数
        Integer generalPosts = dashboardMapper.selectGeneralPosts();

        //获取宠物科普帖子总数
        Integer educationalPosts = dashboardMapper.selectEducationalPosts();

        //获取已找到宠物帖子总数
        Integer found = dashboardMapper.selectFound();

        //获取未找到宠物帖子总数
        Integer notFound = dashboardMapper.selectNotFound();

        //已找到和未找到总数
        Integer returnTotal = dashboardMapper.selectRetrunTotal();

        //所有帖子
        Integer total = generalPosts + educationalPosts + returnTotal;

        return CommunityPostsVO.builder()
                .generalPosts(generalPosts)
                .educationalPosts(educationalPosts)
                .found(found)
                .notFound(notFound)
                .returnTotal(returnTotal)
                .total(total)
                .build();
    }

    /**
     * 获取订单趋势数据
     * @param days 统计天数，可选择（7，15，30）
     * @return 返回数据
     */
    public List<RecentOrdersVO> recentOrders(Integer days) {
        return dashboardMapper.recentOrders(days);
    }

}
