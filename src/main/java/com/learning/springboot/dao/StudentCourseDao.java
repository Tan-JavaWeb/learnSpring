package com.learning.springboot.dao;

import java.util.List;

import com.learning.springboot.model.StudentCourse;

public interface StudentCourseDao {
	List<StudentCourse> getAllStudentCourse();
}