CREATE TABLE Homework (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    description VARCHAR(256) NOT NULL
);

CREATE TABLE Lesson (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    updateAt DATETIME,
    homework_id INT NOT NULL,
    FOREIGN KEY (homework_id) REFERENCES Homework (id)
);

CREATE TABLE Schedule (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    updateAt DATETIME,
    lessons INT NOT NULL,
    FOREIGN KEY (lessons) REFERENCES Lesson (id)
);

INSERT INTO Homework (name, description) VALUES
    ('hw1', 'description1'),
    ('hw2', 'description2'),
    ('hw3', 'description3');

INSERT INTO Lesson (name, updateAt, homework_id) VALUES
    ('lesson1', '2023-10-01 13:23:44', 1),
    ('lesson1', '2023-10-01 13:23:44', 2),
    ('lesson2', '2023-10-02 13:23:44', 3);

INSERT INTO Schedule (name, updateAt, lessons) VALUES
    ('shedule1', '2023-10-01 10:00:00', 1),
    ('shedule1', '2023-10-01 10:00:00', 2);

SELECT * FROM Homework;
SELECT * FROM Lesson;
SELECT * FROM Schedule;
