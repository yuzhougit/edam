package com.citrix.mvcdemo.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.citrix.mvcdemo.model.Course;
import com.citrix.mvcdemo.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
    
    private static Logger logger = LoggerFactory.getLogger(CourseController.class);
    
    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
    
    @RequestMapping(value="/view", method=RequestMethod.GET)
    public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
        
        logger.debug("In viewCourse, courseId = {}", courseId);
        
        Course course = courseService.getCourseById(courseId);
        model.addAttribute(course);
        
        return "course_overview";
    }
    
    @RequestMapping(value="view2/{courseId}")
    public String viewCourse(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
        
        logger.debug("In viewCourse 2, courseId = {}", courseId);
        
        Course course = courseService.getCourseById(courseId);
        model.put("course", course);
        
        return "course_overview";
    }
    
    //本方法将处理 /courses/view3?courseId=123 形式的URL
    @RequestMapping("/view3")
    public String viewCourse3(HttpServletRequest request) {
        
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));       
        Course course = courseService.getCourseById(courseId);
        request.setAttribute("course",course);
        
        return "course_overview";
    }
    
    
    

}
