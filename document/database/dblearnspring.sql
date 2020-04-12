-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 12, 2020 lúc 05:54 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dblearnspring`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(170) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `department` varchar(170) COLLATE utf8mb4_unicode_ci NOT NULL,
  `teacher_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE IF NOT EXISTS `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `script` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1', 'CreateStudentTable', 'SQL', 'V1__CreateStudentTable.sql', -1462131973, 'root', '2020-04-01 18:29:25', 362, 1),
(2, '2', 'CreateCourseTables', 'SQL', 'V2__CreateCourseTables.sql', 974190496, 'root', '2020-04-01 18:29:25', 359, 1),
(3, '3', 'CreateStudentCourseTables', 'SQL', 'V3__CreateStudentCourseTables.sql', 1761942873, 'root', '2020-04-01 18:29:26', 462, 1),
(4, '4', 'InsertDataStudentTables', 'SQL', 'V4__InsertDataStudentTables.sql', -1146111999, 'root', '2020-04-01 18:29:26', 238, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` enum('MALE','FEMALE') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`student_id`, `first_name`, `last_name`, `email`, `gender`) VALUES
('6c20ac51-23d0-4d46-bd50-82dab6611e66', 'Rodger', 'Corradeschi', 'rcorradeschi8@europa.eu', 'MALE'),
('7492d4b0-1217-48af-9757-9611a9d4af55', 'Jacquelynn', 'McAnellye', 'jmcanellye6@guardian.co.uk', 'FEMALE'),
('953b52d8-a089-48a4-bbf8-e21008c72f0e', 'Jacqui', 'Rigate', 'jrigate5@ebay.co.uk', 'FEMALE'),
('9c42106d-04f2-4b29-a17f-28e61203b230', 'Edy', 'Shakshaft', 'eshakshaftj@jigsy.com', 'FEMALE'),
('a75c1b78-0802-4888-8e8c-f8e76e34b617', 'Winny', 'Forster', 'wforster2@imgur.com', 'MALE'),
('a81ae551-6411-405b-ba89-6fe4699a7293', 'Merrick', 'Fewkes', 'mfewkese@google.com', 'MALE'),
('bc5bc1a9-1da7-4b1f-931a-4f5c3f7dc992', 'Perry', 'Vamplew', 'pvamplew7@uiuc.edu', 'MALE'),
('ce82e722-1310-4d00-9f17-2bb0d45719f0', 'Denney', 'Chittem', 'dchittema@chron.com', 'MALE'),
('d40668fa-432e-4649-88cc-871fa46a0396', 'Derron', 'Allix', 'dallixb@salon.com', 'MALE'),
('e7e40436-b931-441d-85e0-d86b6039fdfa', 'Leshia', 'Aikin', 'laikin0@photobucket.com', 'FEMALE'),
('eb8c6b33-8a73-4482-90d4-6f89e800b947', 'Brice', 'Farfull', 'bfarfull9@goo.ne.jp', 'MALE'),
('fb5941db-1f2b-4eac-b9d5-f90927cb0621', 'Andee', 'Poultney', 'apoultneyf@elpais.com', 'FEMALE'),
('fbdebde6-58c7-41e3-b51b-343e032b3b3b', 'Halsy', 'Obell', 'hobelld@rakuten.co.jp', 'MALE');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student_course`
--

DROP TABLE IF EXISTS `student_course`;
CREATE TABLE IF NOT EXISTS `student_course` (
  `student_id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `course_id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `grade` int(11) DEFAULT NULL,
  UNIQUE KEY `student_id` (`student_id`,`course_id`),
  KEY `course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `student_course`
--
ALTER TABLE `student_course`
  ADD CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
