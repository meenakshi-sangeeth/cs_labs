
### 1. Create a table employee with ( emp_no, emp_name, emp_address) 

```bash
create table employee (
    emp_no number(5),
    emp_name varchar2(30),
    emp_address varchar2(50)
);

```

### 2. Insert five employees information. 

```bash
insert into employee values (1, 'jim', 'manipal');
insert into employee values (2, 'pam', 'mangalore');
insert into employee values (3, 'dwight', 'udupi');
insert into employee values (4, 'angela', 'manipal');
insert into employee values (5, 'kelly', 'mangalore');
```

### 3. Display names of all employees. 

```bash
select emp_name from employee;
```

### 4. Display all the employees from ‘MANIPAL’. 

```bash
select * from employee
where emp_address = 'manipal';
```

### 5. Add a column named salary to employee table. 

```bash
alter table employee
add salary number(10);
```

### 6. Assign the salary for all employees. 

```bash
update employee set salary = 35000 where emp_no = 1;
update employee set salary = 42000 where emp_no = 2;
update employee set salary = 38000 where emp_no = 3;
update employee set salary = 40000 where emp_no = 4;
update employee set salary = 45000 where emp_no = 5;
```

### 7. View the structure of the table employee using describe. 

```bash
describe employee;
```

### 8. Delete all the employees from ‘MANGALORE’ 

```bash
delete from employee
where emp_address = 'mangalore';
```

### 9. Rename employee as employee1. 

```bash
rename employee to employee1;
```

### 10. Drop the table employee1.

```bash
drop table employee1;
```
