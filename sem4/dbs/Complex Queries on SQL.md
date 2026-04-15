### 1. Find the number of students in each course

```bash
select course_id, count(id)

from takes

group by course_id;
```

### 2. Find those departments where the average number of students are greater than 10.

```bash 
select dept_name

from student

group by dept_name

having count(id) > 10;
```

### 3. Find the total number of courses in each department.

```bash
select dept_name, count(course_id) as no_of_courses

from course

group by dept_name;
```

### 4. Find the names and average salaries of all departments whose average salary is greater than 42000.

```bash
select dept_name, avg(salary)

from instructor

group by dept_name

having avg(salary)>42000;
```

### 5. Find the enrolment of each section that was offered in Spring 2009.

```bash
select course_id, sec_id, count(id) as enrollment

from takes

where semester = 'Spring' and year = 2009

group by course_id, sec_id;
```

### 6. List all the courses with prerequisite courses, then display course id in increasing order.

```bash
select course_id, prereq_id

from prereq

order by course_id;
```

### 7. Display the details of instructors sorting the salary in decreasing order.

```bash
select *

from instructor

order by salary desc;
```

### 8. Find the maximum total salary across the departments.

```bash
select max(salary_sum) as maximum_salary

from (

    select dept_name, sum(salary) as salary_sum

    from instructor

    group by dept_name

);
```

### 9. Find the average instructors’ salaries of those departments where the average salary is greater than 42000.

```bash
select avg(salary)

from instructor

where dept_name in(

    select dept_name

    from instructor

    group by dept_name

    having avg(salary)>42000

);
```

### 10. Find the sections that had the maximum enrolment in Spring 2010

```bash
select sec_id

from takes

where semester='Spring' and year=2010

group by sec_id

having count(id) = (

    select max(id_count)

    from (

        select count(id) as id_count

        from takes

        where semester='Spring' and year=2010

        group by sec_id

    )

);
```

### 11. Find the names of all instructors who teach all students that belong to ‘CSE’ department.

```bash
select distinct i.name

from instructor i

where not exists (

    select s.id

    from student s

    where s.dept_name = 'Comp. Sci.'

    and not exists (

        select 1

        from teaches t

        join takes tk on t.course_id = tk.course_id

        where t.id = i.id

        and tk.id = s.id

    )

);

```

### 12. Find the average salary of those department where the average salary is greater than 50000 and total number of instructors in the department are more than 5.

```bash
select dept_name, avg(salary) as avg_salary

from instructor

group by dept_name

having avg(salary) > 50000 and count(*) > 5;
```

### 13. Find all departments with the maximum budget.

```bash
with DeptBudget as (

select dept_name, budget

  from department

)

select dept_name

from DeptBudget

where budget = (select max(budget) from DeptBudget);
```

### 14. Find all departments where the total salary is greater than the average of the total salary at all departments.

```bash
with DeptSalary as (

select dept_name, sum(salary) as total_salary

  from instructor

  group by dept_name

)

select dept_name

from DeptSalary

where total_salary > (select avg(total_salary) from DeptSalary);
```

### 15. Transfer all the students from CSE department to IT department.

```bash
savepoint before_transfer;

update student

set dept_name = 'IT'

where dept_name = 'Comp. Sci.';
```

### 16. Increase salaries of instructors whose salary is over $100,000 by 3%, and all others receive a 5% raise

```bash
update instructor

set salary = case

  when salary > 100000 then salary * 1.03

  else salary * 1.05

end;

rollback to before_transfer;
```