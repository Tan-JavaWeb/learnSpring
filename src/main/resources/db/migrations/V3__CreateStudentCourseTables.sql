CREATE TABLE IF NOT EXISTS student_course (
	student_id char(36) NOT NULL,
	FOREIGN KEY(student_id) REFERENCES student(student_id),
	course_id char(36) NOT NULL,
	FOREIGN KEY(course_id) REFERENCES course(course_id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    grade int,
    CHECK (grade >= 0 AND grade <= 100),
    UNIQUE (student_id, course_id)
);