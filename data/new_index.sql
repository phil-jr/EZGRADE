CREATE TABLE categories (
	category_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE sub_categories (
	sub_category_id INT NOT NULL AUTO_INCREMENT,
    category_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (sub_category_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE classes (
	class_id VARCHAR(16) NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NULL,
    category_id INT NULL,
    sub_category_id INT NULL,
    creationDate DATETIME NOT NULL,
    PRIMARY KEY (class_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id),
    FOREIGN KEY (sub_category_id) REFERENCES sub_categories(sub_category_id)
);

CREATE TABLE instructor_enrollments (
	class_id VARCHAR(16) NOT NULL,
    student_id VARCHAR(16) NOT NULL,
    instructor_id VARCHAR(16) NOT NULL,
    grade FLOAT NULL,
    active TINYINT NOT NULL,
    enrollment_date DATETIME NOT NULL,
    PRIMARY KEY (class_id, student_id, instructor_id),
    FOREIGN KEY (class_id) REFERENCES classes(class_id),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id)
);


CREATE TABLE self_enrollments (
	class_id VARCHAR(16) NOT NULL,
    student_id VARCHAR(16) NOT NULL,
    grade FLOAT NULL,
    active TINYINT NOT NULL,
    enrollment_date DATETIME NOT NULL,
    PRIMARY KEY (class_id, student_id),
    FOREIGN KEY (class_id) REFERENCES classes(class_id),
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);