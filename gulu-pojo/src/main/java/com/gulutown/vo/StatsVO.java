package com.gulutown.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class StatsVO {
    private Integer totalPets;
    private Integer totalUsers;
    private Integer totalOrders;
    private Integer newUsersToday;
}
