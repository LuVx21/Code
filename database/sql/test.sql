set serveroutput on
spool "log.log" append

declare
TYPE emp_table_type IS TABLE OF emp%ROWTYPE INDEX BY BINARY_INTEGER;
v_emp_table emp_table_type;
begin
dbms_output.put_line('=============');
dbms_output.put_line('renxie');
dbms_output.put_line('=============');


SELECT * BULK COLLECT INTO v_emp_table FROM emp WHERE deptno=&deptno;


FOR i IN 1..v_emp_table.COUNT LOOP
       dbms_output.put_line('EMPLOYEE_INFO:'||v_emp_table(i).ename||
                                         ','||v_emp_table(i).job||
                                         ','||v_emp_table(i).hiredate);
END LOOP;


end;
/

spool off