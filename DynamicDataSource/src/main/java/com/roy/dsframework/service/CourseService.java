package com.roy.dsframework.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.roy.dsframework.entity.Course;
import com.roy.dsframework.mapper.CourseMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author roy
 * @date 2022/3/17
 * @desc
 */
@Service
@DS("read")
public class CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private JdbcTemplate jdbcTemplate;


    public List selectCourse(){
        return jdbcTemplate.queryForList("select * from course");
    }

    @DS("#session.rw")
    public List selectCourse2(){
        return jdbcTemplate.queryForList("select * from course");
    }

    @DS("#tenantId")
    public List selectCourseSpel(String tenantId){
        return jdbcTemplate.queryForList("select * from course");
    }

    @DS("write")
    @DSTransactional
    public int createCourse(Course course){
        int res = jdbcTemplate.update("insert into course values(?,?,?,?)",course.getCid(),course.getCname(),course.getUserId(),course.getCstatus());
       // int i = 1/0;
        return res;
    }
}
