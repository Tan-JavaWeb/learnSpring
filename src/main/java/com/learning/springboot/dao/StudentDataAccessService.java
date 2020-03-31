package com.learning.springboot.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learning.springboot.model.Student;

@Repository("mysql")
public class StudentDataAccessService implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;

	public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertStudent(UUID id, Student student) {
		return 0;
	}

	private RowMapper<Student> mapStudentFomDb(){
		return (resultSet, i) -> {
            String studentIdStr = resultSet.getString("student_id");
            UUID studentId = UUID.fromString(studentIdStr);

            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");

            String genderStr = resultSet.getString("gender").toUpperCase();
            Student.Gender gender = Student.Gender.valueOf(genderStr);
            return new Student(
                    studentId,
                    firstName,
                    lastName,
                    email,
                    gender
            );
        };
	}
	
	@Override
	public List<Student> getAllStudent() {
		String sql = "" +
            "SELECT " +
            " student_id, " +
            " first_name, " +
            " last_name, " +
            " email, " +
            " gender " +
            "FROM student";
		return jdbcTemplate.query(sql, mapStudentFomDb());
	}

	@Override
	public Optional<Student> getStudentById(UUID id) {
		return null;
	}

	@Override
	public int deleteStudentById(UUID id) {
		return 0;
	}

	@Override
	public int updateStudentById(UUID id, Student student) {
		return 0;
	}

}
