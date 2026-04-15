### 1. Find courses that ran in Fall 2009 or in Spring 2010

```bash
select course_id

from section

where semester = 'Fall' and year = 2009

union all

select course_id

from section

where semester = 'Spring' and year = 2010;
```

### 2. Find courses that ran in Fall 2009 and in spring 2010

```bash
select course_id

from section

where semester = 'Fall' and year = 2009

intersect

select course_id

from section

where semester = 'Spring' and year = 2010;
```

### 3. Find courses that ran in Fall 2009 but not in Spring 2010

```bash
select course_id

from section

where semester = 'Fall' and year = 2009

minus

select course_id

from section

where semester = 'Spring' and year = 2010;
```

### 4. Find the name of the course for which none of the students registered.

```bash
select title from course where course_id not in(
    select course_id 
    from takes
);
```

### 5. Find courses offered in Fall 2009 and in Spring 2010.

```bash
select course_id

from section

where semester = 'Fall' and year = 2009

and course_id in (

    select course_id

    from section

    where semester = 'Spring' and year = 2010

);
```


### 6. Find the total number of students who have taken course taught by the instructor with ID 10101.

```bash
select count(distinct t.id) as count

from takes t

where (t.course_id, t.sec_id, t.semester, t.year) in (

    select tr.course_id, tr.sec_id, tr.semester, tr.year

    from teaches tr

    where tr.id = 10101

);
```


### 7. Find courses offered in Fall 2009 but not in Spring 2010.

```bash
select course_id

from section s1

where semester = 'Fall' and year = 2009

and not exists (

    select 1

    from section s2

    where s2.course_id = s1.course_id

    and s2.semester = 'Spring'

    and s2.year = 2010

);
```


### 8. Find the names of all students whose name is same as the instructor’s name.

```bash
select name

from student

where name in (

    select name

    from instructor

);
```

### 9. Find names of instructors with salary greater than that of some (at least one) instructor in the Biology department.

```bash
select name

from instructor

where salary > some (

    select salary

    from instructor

    where dept_name = 'Biology'

);
```

### 10. Find the names of all instructors whose salary is greater than the salary of all instructors in the Biology department.

```bash
select name

from instructor

where salary > all (

    select salary

    from instructor

    where dept_name = 'Biology'

);
```

### 11. Find the departments that have the highest average salary.

```bash
select dept_name

from instructor

group by dept_name

having avg(salary) = (

    select max(avg(salary))

    from instructor

    group by dept_name

);
```

### 12. Find the names of those departments whose budget is lesser than the average salary of all instructors.

```bash
select dept_name

from department

where budget < (

    select avg(salary)

    from instructor

);
```

### 13. Find all courses taught in both the Fall 2009 semester and in the Spring 2010 semester.

```bash
select distinct t1.course_id

from teaches t1

where t1.semester = 'Fall' and t1.year = 2009

and exists (

    select 1

    from teaches t2

    where t2.course_id = t1.course_id

    and t2.semester = 'Spring'

    and t2.year = 2010

);
```

### 14. Find all students who have taken all courses offered in the Biology department.

```bash
select s.id, s.name

from student s

where not exists (

    select c.course_id

    from course c

    where c.dept_name = 'Biology'

    and not exists (

        select 1

        from takes t

        where t.id = s.id

        and t.course_id = c.course_id

    )

);
```

### 15. Find all courses that were offered at most once in 2009.

```bash
select course_id

from section

where year = 2009

group by course_id

having count(*) <= 1;
```

### 16. Find all the students who have opted at least two courses offered by CSE department.

```bash
select s.id, s.name

from student s

where s.id in (

    select t.id

    from takes t

    join course c

    on t.course_id = c.course_id

    where c.dept_name = 'Comp. Sci.'

    group by t.id

    having count(*) >= 2

);
```

### 17. Find the average instructors salary of those departments where the average salary is greater than 42000

```bash
select dept_name, avg_salary

from (

    select dept_name, avg(salary) as avg_salary

    from instructor

    group by dept_name

    )

where avg_salary > 42000;
```

### 18. Create a view all_courses consisting of course sections offered by Physics department in the Fall 2009, with the building and room number of each section.

```bash
create view all_courses as

select s.course_id, s.sec_id, s.building, s.room_number

from section s

join course c

on s.course_id = c.course_id

where c.dept_name = 'Physics' and s.semester = 'Fall' and s.year = 2009;
```

### 19. Select all the courses from all_courses view.

```bash
select *

from all_courses;
```

### 20. Create a view department_total_salary consisting of department name and total salary of that department.

```bash
create view department_total_salary as

select dept_name, sum(salary) as total_salary

from instructor

group by dept_name;
```