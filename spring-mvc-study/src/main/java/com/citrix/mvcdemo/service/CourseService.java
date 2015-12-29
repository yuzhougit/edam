package com.citrix.mvcdemo.service;

import org.springframework.stereotype.Service;

import com.citrix.mvcdemo.model.Course;

@Service
public interface CourseService {

    Course getCourseById(Integer courseId);
}
