package com.roy.jdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roy.jdbcdemo.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：楼兰
 * @description:
 **/
public interface CourseMapper extends BaseMapper<Course> {
}
