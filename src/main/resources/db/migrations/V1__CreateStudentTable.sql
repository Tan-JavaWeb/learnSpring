  CREATE TABLE IF NOT EXISTS student (
    student_id char(36) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    gender ENUM ('MALE', 'FEMALE'),
    PRIMARY KEY (student_id)
);