### Use a table StudentTable(RollNo, GPA) and populate the table with {(1, 5.8); (2, 6.5); (3, 3.4); (4,7.8); (5, 9.5)} unless a different DB schema is explicitly specified. 

```bash
create table studenttable(rollno int primary key, gpa float);
insert into studenttable values (1, 5.8);
insert into studenttable values (2, 6.5);
insert into studenttable values (3, 3.4);
insert into studenttable values (4, 7.8);
insert into studenttable values (5, 9.5);
```
```bash
set serveroutput on;
set verify off;
```

### 1. Write a PL/SQL block to display the GPA of given student.
```bash
declare
    rno studenttable.rollno%type;
    temp studenttable.gpa%type;
begin
    rno:='&roll_number';
    select gpa into temp from studenttable where rollno=rno;
    dbms_output.put_line('GPA:' || to_char(temp));
exception 
    when no_data_found then dbms_output.put_line('No rows found');  
end;
```

### 2. Write a PL/SQL block to display the letter grade(0-4: F; 4-5: E; 5-6: D; 6-7: C; 7-8: B; 8-9: A; 9-10: A+) of given student. 

```bash
declare
    rno studenttable.rollno%type;
    temp studenttable.gpa%type;
begin
    rno:='&roll_number';
    select gpa into temp from studenttable where rollno=rno;
    if temp between 0 and  4 then
        grade:='F';
    elsif temp between 4 and 5 then
        grade:='E';
    elsif temp between 5 and 6 then
        grade:='D';
    elsif temp between 6 and 7 then
        grade:='C';
    elsif temp between 7 and 8 then
        grade:='B';
    elsif temp between 8 and 9 then
        grade:='A';
    elsif temp between 9 and 10 then
        grade:='A+';
    else
        dbms_output.put_line('Invalid GPA');
    end if;
exception 
    when no_data_found then dbms_output.put_line('No rows found');  
end;
```

### 3. Input the date of issue and date of return for a book. Calculate and display the fine with the appropriate message using a PL/SQL block. The fine is charged as per the table :

|  Late period  |    Fine    |
| ------------- | ---------- |
| 7 days        | NIL        |
| 8 - 15 days   | Rs. 1/ day |
| 16 - 30 days  | Rs. 2/ day |
| After 30 days | Rs. 5.00   |

```bash
declare
    doi date;
    dor date;
    lp int;
    fine int;
begin
    doi := to_date('&date_of_issue','DD-MM-YYYY');
    dor := to_date('&date_of_return','DD-MM-YYYY');
    lp := dor-doi;
    if lp between 0 and 7 then
        fine:=0;
    elsif lp between 8 and 15 then
        fine:=lp;
    elsif lp between 16 and 30 then
        fine:=2*lp;
    elsif lp > 30 then
        fine:=5*lp;
    else
        dbms_output.put_line('Invalid date of issue or date of return');
    end if;
    dbms_output.put_line('Late by '||to_char(lp)||' days');
    dbms_output.put_line('Fine:'||to_char(fine));
end;
```

### 4. Write a PL/SQL block to print the letter grade of all the students(RollNo: 1 - 5). 

```bash
declare
    rno studenttable.rollno%type := 1;
    temp studenttable.gpa%type;
    grade char(2);
begin
    loop
        select gpa into temp from studenttable where rollno=rno;
        if temp between 0 and  4 then
            grade:='F';
        elsif temp between 4 and 5 then
            grade:='E';
        elsif temp between 5 and 6 then
            grade:='D';
        elsif temp between 6 and 7 then
            grade:='C';
        elsif temp between 7 and 8 then
            grade:='B';
        elsif temp between 8 and 9 then
            grade:='A';
        elsif temp between 9 and 10 then
            grade:='A+';
        else
            dbms_output.put_line('Invalid GPA');
        end if;
        dbms_output.put_line('Roll no:'||rno||' | Grade:'||grade);
        rno:=rno+1;
        if rno>5 then 
            exit;
        end if;
    end loop;
exception 
    when no_data_found then dbms_output.put_line('No rows found');  
end;
```

### 5.Alter StudentTable by appending an additional column LetterGrade Varchar2(2). Then write a PL/SQL block  to update the table with letter grade of each student.

```bash
alter table studenttable add lettergrade varchar2(2);

declare
    rno studenttable.rollno%type := 1;
    temp studenttable.gpa%type;
    grade studenttable.lettergrade%type;
begin
    while rno<=5 loop
        select gpa into temp from studenttable where rollno=rno;
        if temp between 0 and  4 then
            grade:='F';
        elsif temp between 4 and 5 then
            grade:='E';
        elsif temp between 5 and 6 then
            grade:='D';
        elsif temp between 6 and 7 then
            grade:='C';
        elsif temp between 7 and 8 then
            grade:='B';
        elsif temp between 8 and 9 then
            grade:='A';
        elsif temp between 9 and 10 then
            grade:='A+';
        else
            dbms_output.put_line('Invalid GPA');
        end if;
        update studenttable set lettergrade=grade where rollno=rno;
        rno:=rno+1;
    end loop;
exception 
    when no_data_found then dbms_output.put_line('No rows found');  
end;
```

### 6. Write a PL/SQL block to find the student with max. GPA without using aggregate function

```bash
declare
    rno studenttable.rollno%type;
    temp studenttable.gpa%type;
    max_gpa studenttable.gpa%type:=0;
begin
    for i in 1..5 loop
        select gpa into temp from studenttable where rollno=i;
        if temp>max_gpa then
            max_gpa:=temp;
            rno:=i;
        end if;
    end loop;
    dbms_output.put_line('Roll no '||rno||' has the highest GPA of '||max_gpa);
exception
    when no_data_found then dbms_output.put_line('No rows found');  
end;
```

### 7. Implement lab exercise 4 using GOTO

```bash
declare
    rno studenttable.rollno%type := 1;
    temp studenttable.gpa%type;
    grade varchar2(2);
begin
    <<start_loop>>
    select gpa into temp from studenttable where rollno = rno;
    if temp between 0 and 4 then
        grade := 'F';
    elsif temp between 4 and 5 then
        grade := 'E';
    elsif temp between 5 and 6 then
        grade := 'D';
    elsif temp between 6 and 7 then
        grade := 'C';
    elsif temp between 7 and 8 then
        grade := 'B';
    elsif temp between 8 and 9 then
        grade := 'A';
    elsif temp between 9 and 10 then
        grade := 'A+';
    else
        dbms_output.put_line('Invalid GPA');
    end if;
    dbms_output.put_line('Roll no: ' || rno || ' | Grade: ' || grade);
    rno := rno + 1;
    if rno <= 5 then
        goto start_loop;
    end if;
exception
    when no_data_found then
    dbms_output.put_line('no rows found for rollno ' || rno);
end;
```

### 8.Based on the University database schema, write a PL/SQL block to display the details of the Instructor whose name is supplied by the user. Use exceptions to show appropriate error message for the following cases: 
- Multiple instructors with the same name 
- No instructor for the given name    

```bash
declare
    n instructor.name%type := '&instructor_name';
    i instructor.id%type;
    d instructor.dept_name%type;
begin
    select id, dept_name into i, d from instructor where name = n;
    dbms_output.put_line('Instructor ID: ' || i || ' | Department: ' || d);
exception
    when no_data_found then
        dbms_output.put_line('No instructor found with given name');
    when too_many_rows then
        dbms_output.put_line('Multiple instructors found with given name');
end;
```



