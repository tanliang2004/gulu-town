package com.gulutown.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gulutown.vo.RecentOrdersVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DashboardMapper {
    @Select("select count(1) from pet_info")
    Integer totalPets();

    @Select("select count(1) from user")
    Integer totalUsers();

    @Select("select count(1) from `order`")
    Integer totalOrders();

    @Select("\n" +
            "select count(1) from `user` " +
            "where create_time " +
            "between #{begin} AND #{end}")
    Integer newUsersToday(String begin, String end);

    Integer[] userGrowthWeek();

    String[] userGrowthMonthString();

    Integer[] userGrowthMonthValue();

    Integer[] userGrowthYear();

    @Select("select count(1) from square_post")
    Integer selectGeneralPosts();

    @Select("select count(1) from knowledge_post")
    Integer selectEducationalPosts();

    @Select("select count(1) from missing_pet_post where status = 2")
    Integer selectFound();

    @Select("select count(1) from missing_pet_post where status = 1")
    Integer selectNotFound();

    @Select("select count(1) from missing_pet_post")
    Integer selectRetrunTotal();

    List<RecentOrdersVO> recentOrders(Integer days);
}
