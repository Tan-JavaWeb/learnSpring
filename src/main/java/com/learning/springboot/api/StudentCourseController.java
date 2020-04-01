package com.learning.springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.model.StudentCourse;
import com.learning.springboot.service.StudentCourseService;

@RestController
@RequestMapping("api/v1/studentcourse")
public class StudentCourseController {

	private StudentCourseService studentCourseService;

	@Autowired
	public StudentCourseController(StudentCourseService studentCourseService) {
		super();
		this.studentCourseService = studentCourseService;
	}
	
	@GetMapping
	public List<StudentCourse> getAllStudentCourse(){
		return studentCourseService.getAllStudentCourse();
	}
}
