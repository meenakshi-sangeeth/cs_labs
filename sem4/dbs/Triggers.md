### 1. Based on the University database Schema in Lab 2, write a row trigger that records along with the time any change made in the Takes (ID, course-id, sec-id, semester, year, grade) table in log_change_Takes (Time_Of_Change, ID, courseid,sec-id, semester, year, grade)

```bash
create or replace trigger log_takes_changes
after insert or update or delete on takes
for each row
begin
    if inserting then
        insert into log_change_takes
        values (sysdate, :new.id, :new.course_id, :new.sec_id, :new.semester, :new.year, :new.grade);
    elsif updating then
        insert into log_change_takes
        values (sysdate, :new.id, :new.course_id, :new.sec_id, :new.semester, :new.year, :new.grade);
    elsif deleting then
        insert into log_change_takes
        values (sysdate, :old.id, :old.course_id, :old.sec_id, :old.semester, :old.year, :old.grade);
    end if;
end;
/
```

### 2. Based on the University database schema in Lab: 2, write a row trigger to insert the existing values of the Instructor (ID, name, dept-name, salary) table into a new table Old_ Data_Instructor (ID, name, dept-name, salary) when the salary table is updated

```bash
create or replace trigger log_instructor_salary
before update of salary on instructor
for each row
begin
    insert into old_data_instructor
    values (:old.id, :old.name, :old.dept_name, :old.salary);
end;
/
```

### 3. Based on the University Schema, write a database trigger on Instructor that checks the following: 
- The name of the instructor is a valid name containing only alphabets. 
- The salary of an instructor is not zero and is positive 
- The salary does not exceed the budget of the department to which the instructor belongs.

```bash
create or replace trigger validate_instructor
before insert or update on instructor
for each row
declare
    dept_budget number;
begin
    if regexp_like(:new.name, '[^a-zA-Z ]') then
        raise_application_error(-20001, 'invalid name: only alphabets allowed');
    end if;

    if :new.salary <= 0 then
        raise_application_error(-20002, 'salary must be positive and non-zero');
    end if;

    select budget into dept_budget
    from department
    where dept_name = :new.dept_name;

    if :new.salary > dept_budget then
        raise_application_error(-20003, 'salary exceeds department budget');
    end if;
end;
/
```

### 4. Create a transparent audit system for a table Client_master (client_no, name, address, Bal_due). The system must keep track of the records that are being deleted or updated. The functionality being when a record is deleted or modified the original record details and the date of operation are stored in the auditclient (client_no, name, bal_due, operation, userid, opdate) table, then the delete or update is allowed to go through

```bash
create or replace trigger audit_client_changes
after delete or update on client_master
for each row
begin
    if deleting then
        insert into auditclient
        values (:old.client_no, :old.name, :old.bal_due, 'delete', user, sysdate);
    elsif updating then
        insert into auditclient
        values (:old.client_no, :old.name, :old.bal_due, 'update', user, sysdate);
    end if;
end;
/
```

### 5. Based on the University database Schema in Lab 2, create a view Advisor_Student which is a natural join on Advisor, Student and Instructor tables. Create an INSTEAD OF trigger on Advisor_Student to enable the user to delete the corresponding entries in Advisor table

```bash
create or replace view advisor_student as
select s.id as student_id, s.name as student_name,
       i.id as instructor_id, i.name as instructor_name,
       a.s_id, a.i_id
from advisor a
natural join student s
natural join instructor i;
/

create or replace trigger delete_from_advisor_student
instead of delete on advisor_student
for each row
begin
    delete from advisor
    where s_id = :old.s_id and i_id = :old.i_id;
end;
/
```