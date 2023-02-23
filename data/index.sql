CREATE DATABASE ez_grade

CREATE TABLE student_classes (
  student_class_id VARCHAR(16) PRIMARY KEY,
  student_id VARCHAR(16),
  name VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  category VARCHAR(255) NOT NULL,
  sub_category VARCHAR(255) NOT NULL,
  creation_date DATETIME NOT NULL,
  grade FLOAT NULL,
  FOREIGN KEY (student_id) REFERENCES students(student_id) 
);

CREATE TABLE instructor_classes (
  instructor_class_id VARCHAR(16) PRIMARY KEY,
  instructor_id VARCHAR(16) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  category VARCHAR(255) NOT NULL,
  sub_category VARCHAR(255) NOT NULL,
  creation_date DATETIME NOT NULL,
  FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id) 
);

CREATE TABLE students (
  student_id VARCHAR(16) PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NULL,
  address VARCHAR(255) NULL,
  city VARCHAR(100) NULL,
  state VARCHAR(255) NULL,
  zipcode VARCHAR(255) NULL,
  creation_date DATETIME NOT NULL
);

CREATE TABLE instructors (
  instructor_id VARCHAR(16) PRIMARY KEY,
  institution_id VARCHAR(16) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(20) NOT NULL,
  phone_number VARCHAR(20) NULL,
  creation_date DATETIME NOT NULL,
  FOREIGN KEY (institution_id) REFERENCES institutions(institution_id)
);

CREATE TABLE institutions (
  institution_id VARCHAR(16) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  website VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  creation_date DATETIME NOT NULL
);

CREATE TABLE enrollments (
  instructor_class_id VARCHAR(16) NOT NULL,
  student_id VARCHAR(16) NOT NULL,
  enrollment_date DATETIME NOT NULL,
  grade NULL,
  status ENUM('active', 'inactive') NOT NULL DEFAULT 'active',
  PRIMARY KEY (instructor_class_id, student_id),
  FOREIGN KEY (instructor_class_id) REFERENCES instructor_classes(instructor_class_id),
  FOREIGN KEY (student_id) REFERENCES students(student_id)
);

CREATE TABLE grading_categories (
  grading_category_id VARCHAR(16) PRIMARY KEY,
  class_id VARCHAR(16) NOT NULL,
  name VARCHAR(255) NOT NULL,
  weight FLOAT NOT NULL,
  creation_date DATETIME NOT NULL,
  FOREIGN KEY (class_id) REFERENCES classes(class_id)
);

CREATE TABLE grades (
  grade_id VARCHAR(16) PRIMARY KEY,
  assignment_id VARCHAR(16) NOT NULL, 
  student_id VARCHAR(16) NOT NULL,
  score FLOAT NULL,
  file MEDIUMBLOB NULL,
  creation_date DATETIME NOT NULL,
  FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id),
  FOREIGN KEY (student_id) REFERENCES students(student_id)
);


CREATE TABLE assignments (
  assignment_id VARCHAR(16) PRIMARY KEY,
  grading_category_id VARCHAR(16) NOT NULL,
  class_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  due_date DATETIME NOT NULL,
  description TEXT NOT NULL,
  max_score FLOAT NOT NULL,
  FOREIGN KEY (class_id) REFERENCES classes(class_id),
  FOREIGN KEY (grading_category_id) REFERENCES grading_categories(grading_category_id)
);


CREATE TABLE announcements (
  announcement_id INT AUTO_INCREMENT PRIMARY KEY,
  class_id INT NOT NULL,
  instructor_id INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  creation_date DATETIME NOT NULL,
  is_important BOOLEAN NOT NULL DEFAULT FALSE,
  FOREIGN KEY (class_id) REFERENCES classes(class_id),
  FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id)
);


CREATE TABLE attendance (
  attendance_id INT AUTO_INCREMENT PRIMARY KEY,
  class_id INT NOT NULL,
  student_id INT NOT NULL,
  date DATE NOT NULL,
  status ENUM('present', 'absent', 'excused') NOT NULL DEFAULT 'present',
  FOREIGN KEY (class_id) REFERENCES classes(class_id),
  FOREIGN KEY (student_id) REFERENCES students(student_id)
);


CREATE TABLE materials (
  material_id INT AUTO_INCREMENT PRIMARY KEY,
  class_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  file MEDIUMBLOB NOT NULL,
  creation_date DATETIME NOT NULL,
  FOREIGN KEY (class_id)
);

CREATE TABLE conversations (
  conversation_id INT AUTO_INCREMENT PRIMARY KEY,
  instructor_id INT NOT NULL,
  student_id INT NOT NULL,
  last_message_timestamp DATETIME NOT NULL,
  FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id),
  FOREIGN KEY (student_id) REFERENCES students(student_id)
);

CREATE TABLE messages (
  id INT AUTO_INCREMENT PRIMARY KEY,
  conversation_id INT NOT NULL,
  instructor_id INT NULL,
  student_id INT NULL,
  message_text TEXT NOT NULL,
  timestamp DATETIME NOT NULL,
  FOREIGN KEY (conversation_id) REFERENCES conversations(conversation_id),
  FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id),
  FOREIGN KEY (student_id) REFERENCES students(student_id)
);

CREATE TABLE institutions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  website VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  creation_date DATETIME NOT NULL
);
