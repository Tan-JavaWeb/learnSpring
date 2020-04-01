package com.learning.springboot.model;

import java.time.LocalDate;
import java.util.UUID;

public class StudentCourse {

	private UUID studentId;
	private UUID courseId;
	private String name;
	private String description;
	private String department;
	private String teacherName;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer grade;

	public StudentCourse(UUID studentId, UUID courseId, String name, String description, String department,
			String teacherName, LocalDate startDate, LocalDate endDate, Integer grade) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.department = department;
		this.teacherName = teacherName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.grade = grade;
	}

	public UUID getStudentId() {
		return studentId;
	}

	public void setStudentId(UUID studentId) {
		this.studentId = studentId;
	}

	public UUID getCourseId() {
		return courseId;
	}

	public void setCourseId(UUID courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
}
