CREATE DATABASE students_db;
USE students_db;

-- Create tables
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idNumber VARCHAR(20) NOT NULL,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    registrationDate DATE
);

CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    courseName VARCHAR(100),
    courseCredit INT,
    courseType VARCHAR(50)
);

CREATE TABLE student_courses (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);

-- Insert sample data
INSERT INTO students (idNumber, firstName, lastName, registrationDate) VALUES
('42001122134', 'Giorgi', 'Robeglejiashvili', '2025-01-01'),
('12358132142', 'Jordy', 'Smith', '2025-01-02');

INSERT INTO courses (courseName, courseCredit, courseType) VALUES
('Databases', 5, 'CS'),
('OOP', 4, 'CS'),
('Calculus', 6, 'Math');

INSERT INTO student_courses (student_id, course_id) VALUES
(1, 1), -- Giorgi -> Databases
(1, 2), -- Giorgi -> OOP
(2, 1), -- Jordy -> Databases
(2, 3); -- Jordy -> Calculus

-- Create user 'admin' with password 'admin' and grant privileges
DROP USER IF EXISTS 'admin'@'localhost';
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

GRANT ALL PRIVILEGES ON students_db.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;

-- Select data after running the script
SELECT
    s.idNumber,
    s.firstName,
    s.lastName,
    s.registrationDate,
    c.courseName,
    c.courseCredit,
    c.courseType
FROM
    students s
JOIN
    student_courses sc ON s.id = sc.student_id
JOIN
    courses c ON sc.course_id = c.id;