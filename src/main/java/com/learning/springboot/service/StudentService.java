package com.learning.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learning.springboot.dao.StudentDao;
import com.learning.springboot.model.Student;

@Service
public class StudentService {

	private StudentDao studentDao;

	@Autowired
	public StudentService(@Qualifier("mysql") StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}
	
	public int addStudent(Student student) {
		return studentDao.addStudent(student);
	}
	
	public List<Student> gerAllStudent(){
		return studentDao.getAllStudent();
	}
	
	public Optional<Student> getStudentById(UUID id) {
		return studentDao.getStudentById(id);
	}
	
	public int deleteStudentById(UUID id) {
		return studentDao.deleteStudentById(id);
	}
	
	public int updateStudentById(UUID id, Student newStudent) {
		return studentDao.updateStudentById(id, newStudent);
	}
	
}
