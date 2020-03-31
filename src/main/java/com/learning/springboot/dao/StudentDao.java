package com.learning.springboot.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.learning.springboot.model.Student;

public interface StudentDao {
	int insertStudent(UUID id, Student student);
	
	default int addStudent(Student student) {
		UUID id = UUID.randomUUID();
		return insertStudent(id, student);
	}
	
	List<Student> getAllStudent();
	
	Optional<Student> getStudentById(UUID id);
	
	int deleteStudentById(UUID id);
	
	int updateStudentById(UUID id, Student student);
}
