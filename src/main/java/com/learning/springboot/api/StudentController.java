package com.learning.springboot.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.model.Student;
import com.learning.springboot.service.StudentService;

@RequestMapping("api/v1/student")
@RestController
public class StudentController {
	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping
	public void addStudent(@Valid @NotNull @RequestBody Student person) {
		studentService.addStudent(person);
	}
	
	@GetMapping
	public List<Student> getAllStudent(){
		return studentService.gerAllStudent();
	}
	
	@GetMapping(path = "{id}")
	public Student getStudentById(@PathVariable("id") UUID id) {
		return studentService.getStudentById(id)
				.orElse(null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteStudentByid(@PathVariable("id") UUID id) {
		studentService.deleteStudentById(id);
	}
	
	@PutMapping(path = "{id}")
	public void updateStudentById(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Student studentUpdate) {
		studentService.updateStudentById(id, studentUpdate);
	}
}
