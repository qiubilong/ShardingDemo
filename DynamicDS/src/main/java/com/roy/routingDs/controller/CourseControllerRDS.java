package com.roy.routingDs.controller;

import com.roy.routingDs.config.DynamicDataSource;
import com.roy.routingDs.entity.Course;
import com.roy.routingDs.mapper.CourseMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author roy
 * @date 2022/3/17
 * @desc
 */
@Controller
@RequestMapping("/RDS")
public class CourseControllerRDS {
    @Resource
    CourseMapper courseMapper;

    @ResponseBody
    @RequestMapping("/queryCourse")
    public Object queryOrder(@RequestParam(value = "dsKey",defaultValue = "R") String dsKey){
        DynamicDataSource.name.set(dsKey);
        return courseMapper.selectList(null);
    }

    @ResponseBody
    @RequestMapping("/createCourse")
    public String createCourse(@RequestParam(value = "dsKey",defaultValue = "W") String dsKey, Course course){
        DynamicDataSource.name.set(dsKey);
        courseMapper.insert(course);
        return "SUCCESS BY RDS";
    }
}
