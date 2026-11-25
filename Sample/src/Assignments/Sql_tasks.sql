use school_db;
show tables;
create table students(
student_id int auto_increment primary key,
name varchar(50) not null,
email varchar(100) unique,
age int check(age>=5),
city varchar(50) default "Delhi",
admission_date TIMESTAMP default current_timestamp
);   

INSERT INTO students (name, email, age, city)
VALUES
('Anshul Verma', 'anshul@gmail.com', 21, 'Ghaziabad'),
('Rahul Sharma', 'rahul@gmail.com', 22, 'Delhi'),
('Priya Singh', 'priya@gmail.com', 20, 'Lucknow'),
('Aman Gupta', 'aman@gmail.com', 23, 'Noida'),
('Neha Sharma', 'neha@gmail.com', 21, 'Kanpur'),
('Rohit Kumar', 'rohit@gmail.com', 22, 'Meerut'),
('Sneha Verma', 'sneha@gmail.com', 19, 'Agra'),
('Karan Singh', 'karan@gmail.com', 24, 'Jaipur'),
('Pooja Mishra', 'pooja@gmail.com', 20, 'Varanasi'),
('Arjun Patel', 'arjun@gmail.com', 25, 'Mumbai'),
('Simran Kaur', 'simran@gmail.com', 21, 'Delhi'),
('Vikas Yadav', 'vikas@gmail.com', 23, 'Ghaziabad');

CREATE INDEX idx_name ON students(name);

INSERT INTO students(name,email,age,city)
VALUES
('Raman Verma',"raman123@gmail.com",23,'Noida');

INSERT INTO students (name, email, age, city)
VALUES
('Mohit Agarwal', 'mohit@gmail.com', 22, 'Pune'),
('Kavita Sharma', 'kavita@gmail.com', 20, 'Bhopal'),
('Deepak Kumar', 'deepak@gmail.com', 24, 'Patna'),
('Riya Gupta', 'riya@gmail.com', 19, 'Chandigarh'),
('Sahil Verma', 'sahil@gmail.com', 23, 'Dehradun');
update students
set city='Noida' where student_id=2;
update  students
set city="Gzb" where student_id=2;

update students
SET age=age+1;

alter table students
rename column city to hometown;
delete from students
where student_id=1;

select * from students;
SELECT student_id, name
FROM students
ORDER BY student_id;
CREATE TABLE marks (
    mark_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    subject VARCHAR(30),
    score INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);
INSERT INTO marks (student_id, subject, score)
VALUES
(2, 'Java', 85),
(2, 'DBMS', 90),
(2, 'Python', 88),

(3, 'Java', 78),
(3, 'DBMS', 82),
(3, 'Python', 91),

(4, 'Java', 92),
(4, 'DBMS', 87),
(4, 'Python', 89),

(5, 'Java', 75),
(5, 'DBMS', 80),
(5, 'Python', 84),

(6, 'Java', 88),
(6, 'DBMS', 93),
(6, 'Python', 86),

(7, 'Java', 81),
(7, 'DBMS', 79),
(7, 'Python', 90),

(8, 'Java', 95),
(8, 'DBMS', 89),
(8, 'Python', 92),

(9, 'Java', 72),
(9, 'DBMS', 85),
(9, 'Python', 78),

(10, 'Java', 87),
(10, 'DBMS', 91),
(10, 'Python', 83),

(11, 'Java', 90),
(11, 'DBMS', 88),
(11, 'Python', 94),

(12, 'Java', 76),
(12, 'DBMS', 81),
(12, 'Python', 79),

(13, 'Java', 84),
(13, 'DBMS', 86),
(13, 'Python', 90),


(15, 'Java', 80),
(15, 'DBMS', 77),
(15, 'Python', 85),

(16, 'Java', 89),
(16, 'DBMS', 92),
(16, 'Python', 87),

(17, 'Java', 74),
(17, 'DBMS', 83),
(17, 'Python', 80),

(18, 'Java', 91),
(18, 'DBMS', 90),
(18, 'Python', 96),

(19, 'Java', 86),
(19, 'DBMS', 84),
(19, 'Python', 88);
select * from marks;
ALTER TABLE marks
DROP COLUMN mark_id;

delete from students where student_id=2;

SET sql_safe_updates = 0;

//----------- 

select * from students;
select name,hometown from students;
select * from students where age between 10 and 15;
select * from students where name  like "A%";

select * from students
where hometown in ('Noida','Delhi')
order by age desc;

select * from students
order by admission_date desc
limit 3;

select distinct hometown from students;

select hometown,count(*) as cnt
from students
group by hometown;

select subject ,max(score) ,min(score),avg(score)from marks
group by subject;

select subject 
from marks
group by subject
having avg(score)>60;

