### Consider the following schema:

- Employee(EmpNo, EmpName, Gender, Salary, Address, DNo) 

- Department(DeptNo, DeptName, Location)

### 1. Create Employee table with following constraints:

-  Make EmpNo as Primary key.

-  Do not allow EmpName, Gender, Salary and Address to have null values.

- Allow Gender to have one of the two values: ‘M’, ‘F’.

```bash
create table Employee( 
    EmpNo int primary key, 
    EmpName varchar(30) not null, 
    Gender varchar(1) not null check (Gender in ('M','F')), 
    Salary int not null, 
    Address varchar(50) not null, 
    DNo int
);
```

### 2. Create Department table with following:

- Make DeptNo as Primary key

- Make DeptName as candidate key

```bash
create table Department(
    DeptNo int primary key, 
    DeptName varchar(30) unique, 
    Location varchar(30)
);
```

### 3. Make DNo of Employee as foreign key which refers to DeptNo of Department.

```bash
alter table Employee add constraint 
foreign_key foreign key (Dno) references Department(DeptNo);
``` 

### 4. Insert few tuples into Employee and Department which satisfies the above constraints.

```bash
insert into department values(1, 'Sales', 'Scranton');

insert into department values(2, 'Accounting', 'Scranton');

insert into department values(3, 'Customer Service', 'Scranton');

insert into employee values(101, 'Jim', 'M', 75000, 'Scranton', 1);

insert into employee values(102, 'Pam', 'F', 65000, 'Scranton', 3);

insert into employee values(103, 'Dwight', 'M', 75000, 'Scranton', 1);

insert into employee values(104, 'Angela', 'F', 70000, 'Scranton', 2);

insert into employee values(105, 'Kelly', 'F', 65000, 'Scranton', 3);
```

### 5. Try to insert few tuples into Employee and Department which violates some of the above constraints.

```bash
insert into employee values(105, 'Kevin', 'M', 70000, 'Scranton', 2);

insert into employee values(106, 'Ryan', 'r', 65000, 'Scranton', 3);

insert into employee values(106, 'Bob', 'M', 60000, 'Scranton', 4);

insert into department values(1, 'Manager', 'Scranton');

insert into department values(4, 'Sales', 'Scranton');
```

### 6. Try to modify/delete a tuple which violates a constraint. (Ex: Drop a department tuple which has one or more employees)

```bash
delete from department where DeptNo=1;

update employee set Gender='G' where EmpNo=101;

update employee set DNo=5 where EmpNo=101;
```

### 7. Modify the foreign key constraint of Employee table such that whenever a department tuple is deleted, the employees belonging to that department will also be deleted.

```bash
alter table Employee drop constraint foreign_key;

alter table Employee add constraint 
foreign_key foreign key(Dno) references Department(DeptNo) on delete cascade;
```

### 8. Create a named constraint to set the default salary to 10000 and test the constraint by inserting a new record.

```bash
alter table employee modify salary default 10000;

insert into employee (empno, empname, gender, address, dno) 
values (106, 'Kevin', 'M', 'Scranton', 2);

select * from employee where empno=106;
```

### University Database Schema

- Student (ID, name,dept-name, tot-cred) 
- Instructor(ID, name, dept-name, salary) 
- Course (Course-id, title,dept-name, credits) 
- Takes (ID, course-id, sec-id, semester, year, grade) 
- Classroom (building, room-number, capacity) 
- Department (dept-name, building, budget) 
- Section (course-id, section-id, semester, year, building, room-number, - time-slot-id) 
- Teaches (id, course-id, section-id, semester, year) 
- Advisor(s-id, i-id) 
- Time-slot (time-slot-id, day, start-time, end-time) 
- Prereq (course-id, prereq-id)

### 9. List all Students with names and their department names.

```bash 
select name,dept_name 
from student; 
```

### 10. List all instructors in CSE department.

```bash 
select * 
from instructor 
where dept_name='Comp. Sci.';
```

### 11. Find the names of courses in CSE department which have 3 credits.

```bash 
select title 
from course 
where credits=3 and dept_name='Comp. Sci.';
```

### 12. For the student with ID 12345 (or any other value), show all course-id and title of all courses registered for by the student.

```bash 
select t.course_id, c.title 
from takes t 
join course c on t.course_id=c.course_id 
where t.id='12345';
```

### 13. List all the instructors whose salary is in between 40000 and 90000.

```bash 
select * 
from instructor 
where salary between 40000 and 90000;
```

### 14. Display the IDs of all instructors who have never taught a course.

```bash 
select ID 
from instructor 
where ID not in (
    select ID 
    from teaches
);
```

### 15. Find the student names, course names, and the year, for all students those who have attended classes in room-number 303.

```bash 
select s.name, c.title, sec.year

from student s

join takes t

  on s.id = t.id

join section sec

  on t.course_id = sec.course_id

 and t.sec_id = sec.sec_id

 and t.semester = sec.semester

 and t.year = sec.year

join course c

  on c.course_id = sec.course_id

where sec.room_number = 303;
```

### 16. For all students who have opted courses in 2015, find their names and course id’s with the attribute course title replaced by c-name.

```bash 
select s.name, c.course_id, c.title as c_name

from student s

join takes t on s.id = t.id

join course c on t.course_id = c.course_id

where t.year = 2015;
```

### 17. Find the names of all instructors whose salary is greater than the salary of at least one instructor of CSE department and salary replaced by inst-salary.

```bash 
select name, salary as inst_salary

from instructor

where salary > some (

    select salary

    from instructor

    where dept_name = 'Comp. Sci.'
);
```

### 18. Find the names of all instructors whose department name includes the substring ‘ch’.

```bash 
select name

from instructor

where dept_name like '%ch%';
```

### 19. List the student names along with the length of the student names.

```bash 
select name, length(name) as name_length

from student;
```

### 20. List the department names and 3 characters from 3rd position of each department name

```bash 
select dept_name, substr(dept_name, 3, 3) as sub_name

from department;
```

### 21. List the instructor names in upper case.

```bash 
select upper(name) as instructor_name

from instructor;
```

### 22. Replace NULL with value1(say 0) for a column in any of the table

```bash 
select id, name, nvl(tot_cred, 0) as tot_cred

from student;
```

### 23. Display the salary and salary/3 rounded to nearest hundred from Instructor.

```bash 
select salary, round(salary/3, -2) as rounded_salary

from instructor;
```

### Add date of birth column (DOB) to Employee Table. Insert appropriate DOB values for different employees and try the exercise problems given below:

```bash
alter table employee add DOB date;

update employee set DOB=to_date('16-Feb-1990','DD-MON-YYYY') where empno=101;

update employee set DOB=to_date('26-June-1985','DD-MON-YYYY') where EmpNo=102;
```

### 24. Display the birth date of all the employees in the following format:

- ‘DD-MON-YYYY’

- ‘DD-MON-YY’

- ‘DD-MM-YY’

```bash 
select EmpName, 
       to_char(dob, 'DD-MON-YYYY') as dob_format1, 
       to_char(dob, 'DD-MON-YY') as dob_format2, 
       to_char(dob, 'DD-MM-YY') as dob_format3 
from employee 
where EmpNo=101 or EmpNo=102;
```

### 25. List the employee names and the year (fully spelled out) in which they are born

- ‘YEAR’

- ‘Year’

- ‘year’

```bash 
select EmpName, 
       to_char(dob, 'YEAR') as dob_format1, 
       to_char(dob, 'Year') as dob_format2, 
       to_char(dob, 'year') as dob_format3 
from employee 
where EmpNo=101 or EmpNo=102;
```
