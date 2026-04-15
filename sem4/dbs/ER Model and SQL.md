### 1. Retrieve the birth date and address of the employee(s) whose name is ‘John B. Smith’. Retrieve the name and address of all employees who work for the ‘Research’ department. 

```bash
select bdate, address
from employee
where fname = 'John' and minit = 'B.' and lname = 'Smith';

select e.fname, e.lname, e.address
from employee e, department d
where e.dno = d.dnumber
and d.dname = 'Research';
```

### 2. For every project located in ‘Stanford’, list the project number, the controlling department number, and the department manager’s last name, address, and birth date. 

```bash
select p.pnumber, p.dnum, e.lname, e.address, e.bdate
from project p, department d, employee e
where p.dnum = d.dnumber
and d.mgr_ssn = e.ssn
and p.plocation = 'Stanford';
```

### 3. For each employee, retrieve the employee’s first and last name and the first and last name of his or her immediate supervisor. 

```bash
select e.fname, e.lname, s.fname as sup_fname, s.lname as sup_lname
from employee e left join employee s
on e.super_ssn = s.ssn;
```

### 4. Make a list of all project numbers for projects that involve an employee whose last name is ‘Smith’, either as a worker or as a manager of the department that controls the project. 

```bash
select distinct p.pnumber
from project p, works_on w, employee e
where p.pnumber = w.pno
and w.essn = e.ssn
and e.lname = 'Smith'

union

select distinct p.pnumber
from project p, department d, employee e
where p.dnum = d.dnumber
and d.mgr_ssn = e.ssn
and e.lname = 'Smith';
```

### 5. Show the resulting salaries if every employee working on the ‘ProductX’ project is given a 10 percent raise. 

```bash
select e.fname, e.lname, e.salary * 1.1 as increased_salary
from employee e, works_on w, project p
where e.ssn = w.essn
and w.pno = p.pnumber
and p.pname = '‘ProductX’';
```

### 6. Retrieve a list of employees and the projects they are working on, ordered by department and, within each department, ordered alphabetically by last name, then first name. 

```bash
select d.dname, e.lname, e.fname, p.pname
from employee e
join department d on e.dno = d.dnumber
join works_on w on e.ssn = w.essn
join project p on w.pno = p.pnumber
order by d.dname, e.lname, e.fname;
```

### 7. Retrieve the name of each employee who has a dependent with the same first name and is the same sex as the employee. 

```bash
select e.fname, e.lname
from employee e, dependent d
where e.ssn = d.essn
and e.fname = d.dependent_name
and e.sex = d.sex;
```

### 8. Retrieve the names of employees who have no dependents. 

```bash
select fname, lname
from employee
where ssn not in (
    select essn from dependent
);
```

### 9. List the names of managers who have at least one dependent. 

```bash
select e.fname, e.lname
from employee e, department d
where e.ssn = d.mgr_ssn
and exists (
    select * from dependent dep
    where dep.essn = e.ssn
);
```

### 10. Find the sum of the salaries of all employees, the maximum salary, the minimum salary, and the average salary. 

```bash
select sum(salary), max(salary), min(salary), avg(salary)
from employee;
```

### 11. For each project, retrieve the project number, the project name, and the number of employees who work on that project. 

```bash
select p.pnumber, p.pname, count(w.essn) as no_of_employees
from project p left join works_on w
on p.pnumber = w.pno
group by p.pnumber, p.pname;
```

### 12. For each project on which more than two employees work, retrieve the project number, the project name, and the number of employees who work on the project. 

```bash
select p.pnumber, p.pname, count(w.essn) as no_of_employees
from project p, works_on w
where p.pnumber = w.pno
group by p.pnumber, p.pname
having count(w.essn) > 2;
```

### 13. For each department that has more than five employees, retrieve the department number and the number of its employees who are making more than 40,000.

```bash
select d.dnumber, count(e.ssn) as count_employees
from department d, employee e
where d.dnumber = e.dno
and e.salary > 40000
group by d.dnumber
having count(e.ssn) > 5;
```



