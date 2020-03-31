CREATE TABLE IF NOT EXISTS course (
    course_id char(36) NOT NULL,
    name VARCHAR(170) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    department VARCHAR(170) NOT NULL,
    teacher_name VARCHAR(100),
    PRIMARY KEY (course_id)
);