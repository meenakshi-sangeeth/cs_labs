-- 1. The HRD manager has decided to raise the salary of all the Instructors in a given department number by 5%. Whenever, any such raise is given to the instructor, a record for the same is maintained in the salary_raise table. It includes the Instructor Id, the date when the raise was given and the actual raise amount. Write a PL/SQL block to update the salary of each Instructor and insert a record in the salary_raise(Instructor_Id, Raise_date, Raise_amt) table.
declare
    v_dept instructor.dept_name%type :='&department';
    cursor c is 
        select id,salary 
        from instructor 
        where dept_name=v_dept;
    v_id instructor.id%type;
    v_sal instructor.salary%type;
    raise_amnt instructor.salary%type;
begin
    open c;
    loop
        fetch c into v_id,v_sal;
        exit when c%notfound;
        raise_amnt := v_sal*0.05;

        update instructor 
        set salary = salary + raise_amnt 
        where id=v_id;

        insert into salary_raise(Instructor_Id, Raise_date, Raise_amt)
        values (v_id,sysdate,raise_amnt);
    end loop;
    close c;
end;
/


-- 2. Write a PL/SQL block that will display the ID, name, dept_name  and tot_cred of the first 10 students with lowest total credit.
declare
    cursor c is 
        select id,name,dept_name,tot_cred 
        from student
        order by tot_cred;
    v_id student.id%type;
    v_name student.name%type;
    v_dept student.dept_name%type;
    v_credits student.tot_cred%type;
begin
    open c;
    loop
        fetch c into v_id,v_name,v_dept,v_credits;
        exit when c%notfound or c%rowcount > 10;
        dbms_output.put_line(
            v_id || '   ' ||
            v_name || '   ' ||
            v_dept || '   ' ||
            v_credits
        );
    end loop;
    close c;
end;
/


-- 3. Print the Course details and the total number of students registered for each course along with the course details - (Course-id, title, dept-name, credits, instructor_name, building, room-number, time-slot-id, tot_student_no)
declare
    cursor c is
        select 
            c.course_id,
            c.title,
            c.dept_name,
            c.credits,
            i.name as instructor_name,
            s.building,
            s.room_number,
            s.time_slot_id,
            count(t.id) as tot_student_no
        from course c
        join section s 
            on c.course_id = s.course_id
        join teaches te 
            on s.course_id = te.course_id 
            and s.section_id = te.section_id
            and s.semester = te.semester
            and s.year = te.year
        join instructor i 
            on te.id = i.id
        left join takes t 
            on s.course_id = t.course_id 
            and s.section_id = t.sec_id
            and s.semester = t.semester
            and s.year = t.year
        group by 
            c.course_id, c.title, c.dept_name, c.credits,
            i.name, s.building, s.room_number, s.time_slot_id;

begin
    for rec in c loop
        dbms_output.put_line(
            rec.course_id || ' | ' ||
            rec.title || ' | ' ||
            rec.dept_name || ' | ' ||
            rec.credits || ' | ' ||
            rec.instructor_name || ' | ' ||
            rec.building || ' | ' ||
            rec.room_number || ' | ' ||
            rec.time_slot_id || ' | ' ||
            rec.tot_student_no
        );
    end loop;
end;
/


-- 4. Find all students who take the course with Course-id: CS101 and if he/she has less than 30 total credit (tot-cred), deregister the student from that course. (Delete the entry in Takes table)
declare
    cursor c is 
        select t.id,s.tot_cred
        from takes t 
        join student s on t.id = s.id 
        where t.course_id = 'CS101';
begin
    for rec in c loop
        dbms_output.put_line(rec.id);
        if rec.tot_cred < 30 then
            delete from takes 
            where id=rec.id and course_id = 'CS101';
        end if;
    end loop;
end;
/


-- 5. Alter StudentTable(refer Lab No. 8 Exercise) by resetting column LetterGrade to F. Then write a PL/SQL block  to update the table by mapping GPA to the corresponding letter grade for each student.
declare
    cursor c is 
        select gpa
        from studenttable
        for update;
begin
    for rec in c loop
        update studenttable 
        set lettergrade = case
            when rec.gpa between 0 and 4 then 'F'
            when rec.gpa > 4 and rec.gpa <= 5 then 'E'
            when rec.gpa > 5 and rec.gpa <= 6 then 'D'
            when rec.gpa > 6 and rec.gpa <= 7 then 'C'
            when rec.gpa > 7 and rec.gpa <= 8 then 'B'
            when rec.gpa > 8 and rec.gpa <= 9 then 'A'
            when rec.gpa > 9 and rec.gpa <= 10 then 'A+'
        end
        where id = rec.id;    
    end loop;
end;
/


-- 6. Write a PL/SQL block to print the list of Instructors teaching a specified course.
declare
    cursor c(v_course teaches.course_id%type) is
        select i.id, i.name
        from teaches t
        join instructor i on t.id = i.id
        where t.course_id = v_course;
begin
    for rec in c('&courseID') loop
        dbms_output.put_line(rec.id || '  ' || rec.name);
    end loop;
end;
/


-- 7. Write a PL/SQL block to list the students who have registered for a course taught by his/her advisor.
declare
    cursor c(p_advisor_id advisor.i_id%type) is
        select s.id, s.name, t.course_id
        from student s
        join advisor a on s.id = a.s_id
        join takes t on s.id = t.id
        join teaches te 
            on t.course_id = te.course_id
            and t.sec_id = te.section_id
            and t.semester = te.semester
            and t.year = te.year
        where a.i_id = p_advisor_id   
        and te.id = p_advisor_id;   
begin
    for rec in stud_cur('&advisor_id') loop
        dbms_output.put_line(rec.name);
    end loop;
end;
/
