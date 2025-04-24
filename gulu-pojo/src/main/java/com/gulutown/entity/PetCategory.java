package com.gulutown.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 宠物分类实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetCategory {
    private Long categoryId;
    /**
     * 宠物类型（1-猫，2-狗，3-鸟类，4-其它）
     */
    private String type;
    /**
     * 宠物类型
     * （1-泰迪，2-柯基，3-柴犬，4-边境牧羊犬，5-中华田园犬，6-金毛，7-拉布拉多，8-哈士奇）
     * （9-英国短毛猫，10-美国短毛猫，11-暹罗猫，12-布偶猫，13-波斯猫，14-缅因猫，15-橘猫，16-狸花猫）
     * （17-虎皮鹦鹉，18-玄武鹦鹉，19-和尚鹦鹉，20-小太阳鹦鹉，21-金刚鹦鹉，22-白文鸟，23-七彩文鸟，24-金丝雀，25-珍珠鸟）
     *  26-其它
     */
    private String petType;

}
