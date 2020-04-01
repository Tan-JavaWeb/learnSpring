package com.learning.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learning.springboot.dao.StudentCourseDao;
import com.learning.springboot.model.StudentCourse;

@Service
public class StudentCourseService {

	private StudentCourseDao studentCourseDao;

	public StudentCourseService(@Qualifier("studentcourse") StudentCourseDao studentCourseDao) {
		super();
		this.studentCourseDao = studentCourseDao;
	}
	
	public List<StudentCourse> getAllStudentCourse(){
		return studentCourseDao.getAllStudentCourse();
	}
}