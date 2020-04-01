package com.learning.springboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learning.springboot.model.Student;

@Repository("student")
public class StudentDataAccessService implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Student> getAllStudent() {
		try {
			String sql = "" + "SELECT " + " student_id, " + " first_name, " + " last_name, " + " email, " + " gender "
					+ "FROM student";
			return jdbcTemplate.query(sql, mapStudentFomDb());
		} catch (InvalidResultSetAccessException e) {
			System.out.print("error1");
			return null;
		} catch (DataAccessException e) {
			System.out.print("error2");
			return null;
		}
	}

	private RowMapper<Student> mapStudentFomDb() {
		return (resultSet, rowNum) -> {
			String studentIdStr = resultSet.getString("student_id");
			UUID studentId = UUID.fromString(studentIdStr);

			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			String email = resultSet.getString("email");

			String genderStr = resultSet.getString("gender").toUpperCase();
			Student.Gender gender = Student.Gender.valueOf(genderStr);
			return new Student(studentId, firstName, lastName, email, gender);
		};
	}

	@Override
	public Optional<Student> getStudentById(UUID id) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append("  student_id ");
			sql.append("  , first_name ");
			sql.append("  , last_name ");
			sql.append("  , email ");
			sql.append("  , gender ");
			sql.append("FROM ");
			sql.append("  student ");
			sql.append("WHERE ");
			sql.append("  student_id = ?");
			List<Student> students = new ArrayList<>();
			
			students = jdbcTemplate.query(
					sql.toString(), 
					new Object[] { id.toString() },
					mapStudentFomDb()
				);
			
			return students.size() == 1 ? Optional.of(students.get(0)) : Optional.empty();
		} catch (EmptyResultDataAccessException e) {
			System.out.print("error empty data");
			return Optional.empty();
		} catch (DataAccessException e) {
			System.out.print("error connection");
			return Optional.empty();
		}
		
	}

	@Override
	public int insertStudent(UUID id, Student student) {
		return 0;
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
