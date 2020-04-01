package com.learning.springboot.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learning.springboot.model.StudentCourse;

@Repository("studentcourse")
public class StudentCourseDataAccessService implements StudentCourseDao {

	private JdbcTemplate jdbcTemplate;

	public StudentCourseDataAccessService(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<StudentCourse> getAllStudentCourse() {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append("  student_id ");
			sql.append("  , course_id ");
			sql.append("  , course.name ");
			sql.append("  , course.description ");
			sql.append("  , course.department ");
			sql.append("  , course.teacher_name ");
			sql.append("  , student_course.start_date ");
			sql.append("  , student_course.end_date ");
			sql.append("  , student_course.grade ");
			sql.append("FROM ");
			sql.append("  student ");
			sql.append("  INNER JOIN student_course ");
			sql.append("    USING (student_id) ");
			sql.append("  INNER JOIN course ");
			sql.append("    USING (course_id)");
			
			return jdbcTemplate.query(sql.toString(), mapStudentCourseFromDatabase());
		} catch (InvalidResultSetAccessException e) {
			// TODO: handle exception
			return null;
		} catch (DataAccessException e) {
			// TODO: handle exception
			return null;
		}
	}
	
	private RowMapper<StudentCourse> mapStudentCourseFromDatabase(){
		return (resultSet, rowNum) -> {
			String studentIdStr = resultSet.getString("student_id");
			UUID studentId = UUID.fromString(studentIdStr);
			
			String courseIdString = resultSet.getString("course_id");
			UUID courseId = UUID.fromString(courseIdString);
			
			String name = resultSet.getString("name");
			String description = resultSet.getString("description");
			String department = resultSet.getString("department");
			String teacherName = resultSet.getString("teacher_name");
			LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
			LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
			Integer grade = Optional
					.ofNullable(resultSet.getString("grade"))
//					.map(Integer::valueOf)
					.map(Integer::parseInt)
					.orElse(null);
			
			return new StudentCourse(
					studentId, 
					courseId, 
					name, 
					description, 
					department, 
					teacherName, 
					startDate, 
					endDate, 
					grade
				);
		};		
	}
}
