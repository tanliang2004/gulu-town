package com.gulutown.mapper;

import com.gulutown.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {
    /**
     * 动态条件查询employee表
     * @param employee 实体
     * @return 结果
     */
    Employee selectDynamic(Employee employee);

    /**
     * 根据邮箱查询
     * @param email 邮箱地址
     * @return 结果
     */
    @Select("select * from admin where email = #{email}")
    Employee selectByEmail(String email);

    /**
     * 插入数据
     * @param employee 实体
     */
    void insert(Employee employee);

    @Select("select * from admin where id = #{id}")
    Employee selectById(Long id);
}
