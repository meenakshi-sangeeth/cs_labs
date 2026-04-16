-- 1. Write a procedure to display a message “Good Day to You”
create or replace procedure greet_message is

begin

    dbms_output.put_line('good day to you');

end;
/

begin

    greet_message;

end;
/


-- 2. Based on the University Database Schema in Lab 2, write a procedure which takes the dept_name as input parameter and lists all the instructors associated with the department as well as list all the courses offered by the department. Also, write an anonymous block with the procedure call
create or replace procedure dept_info(p_dept_name in varchar2) is

begin

    dbms_output.put_line('instructors in department ' || p_dept_name || ':');

    for rec in (select name from instructor where dept_name = p_dept_name) loop

        dbms_output.put_line(rec.name);

    end loop;

    dbms_output.put_line('courses offered by department ' || p_dept_name || ':');

    for rec in (select title from course where dept_name = p_dept_name) loop

        dbms_output.put_line(rec.title);

    end loop;

end;
/

begin

    dept_info('Comp. Sci.');

end;
/


-- 3. Based on the University Database Schema in Lab 2, write a Pl/Sql block of code that lists the most popular course (highest number of students take it) for each of the departments. It should make use of a procedure course_popular which finds the most popular course in the given department
create or replace procedure course_popular(p_dept_name in varchar2) is

begin

    for rec in (

        select c.course_id, c.title

        from course c

        where c.dept_name = p_dept_name

        and c.course_id in (

            select course_id

            from takes

            group by course_id

            having count(id) = (

                select max(cnt)

                from (

                    select count(id) cnt

                    from takes t, course c2

                    where t.course_id = c2.course_id

                    and c2.dept_name = p_dept_name

                    group by t.course_id

                )

            )

        )

    ) loop

        dbms_output.put_line('most popular course in ' || p_dept_name || ' is ' || rec.title);

    end loop;

end;
/

declare

    cursor dept_cur is select dept_name from department;

begin

    for rec in dept_cur loop

        course_popular(rec.dept_name);

    end loop;

end;
/


-- 4. Based on the University Database Schema in Lab 2, write a procedure which takes the dept-name as input parameter and lists all the students associated with the department as well as list all the courses offered by the department. Also, write an anonymous block with the procedure call
create or replace procedure dept_students_courses(p_dept_name in varchar2) is

begin

    dbms_output.put_line('students in department ' || p_dept_name || ':');

    for rec in (select name from student where dept_name = p_dept_name) loop

        dbms_output.put_line(rec.name);

    end loop;

    dbms_output.put_line('courses offered by department ' || p_dept_name || ':');

    for rec in (select title from course where dept_name = p_dept_name) loop

        dbms_output.put_line(rec.title);

    end loop;

end;
/

begin

dept_students_courses('Comp. Sci.');

end;
/


-- 5. Write a function to return the Square of a given number and call it from an anonymous block
create or replace function square_num(p_num in number) return number is

begin

    return p_num * p_num;

end;
/

declare

    v_result number;

begin

    v_result := square_num(7);

    dbms_output.put_line('square is: ' || v_result);

end;
/


-- 6. Based on the University Database Schema in Lab 2, write a Pl/Sql block of code that lists the highest paid Instructor in each of the Department. It should make use of a function department_highest which returns the highest paid Instructor for the given branch
create or replace function department_highest(p_dept_name in varchar2) return varchar2 is

    v_name instructor.name%type;

begin

    select name

    into v_name

    from instructor

    where dept_name = p_dept_name

    and salary = (

        select max(salary)

        from instructor

        where dept_name = p_dept_name

    );

    return v_name;

end;
/

declare

    cursor dept_cur is select dept_name from department;

    v_instructor varchar2(50);

begin

    for rec in dept_cur loop

        v_instructor := department_highest(rec.dept_name);

        dbms_output.put_line('highest paid instructor in ' || rec.dept_name || ' is ' || v_instructor);

    end loop;

end;
/


-- 7. Based on the University Database Schema in Lab 2, create a package to include the following:
-- - A named procedure to list the instructor_names of given department
-- - A function which returns the max salary for the given department
-- - Write a PL/SQL block to demonstrate the usage of above package components
create or replace package dept_pkg as

    procedure list_instructors(p_dept_name in varchar2);

    function max_salary(p_dept_name in varchar2) return number;

end dept_pkg;
/

create or replace package body dept_pkg as

    procedure list_instructors(p_dept_name in varchar2) is

    begin

        dbms_output.put_line('instructors in department ' || p_dept_name || ':');

        for rec in (select name from instructor where dept_name = p_dept_name) loop

            dbms_output.put_line(rec.name);

        end loop;

    end;

    function max_salary(p_dept_name in varchar2) return number is

        v_salary number;

    begin

        select max(salary)

        into v_salary

        from instructor

        where dept_name = p_dept_name;

        return v_salary;

    end;

end dept_pkg;
/

declare

    v_max number;

begin

    dept_pkg.list_instructors('Comp. Sci.');

    v_max := dept_pkg.max_salary('Comp. Sci.');

    dbms_output.put_line('max salary: ' || v_max);

end;
/
