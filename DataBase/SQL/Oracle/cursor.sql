-- http://www.cnblogs.com/sc-xx/archive/2011/12/03/2275084.html
set serveroutput on

declare
       --类型定义
       cursor c_job
       is
       select empno,ename,job,sal
       from emp
       where job='MANAGER';
       --定义一个游标变量v_cinfo c_emp%ROWTYPE ，该类型为游标c_emp中的一行数据类型
       c_row c_job%rowtype;
begin
-- 游标遍历方式1
	for c_row in c_job
	loop
		dbms_output.put_line(c_row.empno||'-'||c_row.ename||'-'||c_row.job||'-'||c_row.sal);
	end loop;
-- 游标遍历方式2
	open c_job;
	loop
		fetch c_job into c_row;
		exit when c_job%notfound;
		dbms_output.put_line(c_row.empno||'-'||c_row.ename||'-'||c_row.job||'-'||c_row.sal);
	end loop;
-- update 中的游标
	begin
		update emp set ENAME='ALEARK' WHERE EMPNO=7900; --JAMES

		if sql%isopen then
			dbms_output.put_line('Openging');
		else
			dbms_output.put_line('closing');
		end if;

		if sql%found then
			dbms_output.put_line('游标指向了有效行');--判断游标是否指向有效行
		else
			dbms_output.put_line('Sorry');
		end if;

		if sql%notfound then
			dbms_output.put_line('Also Sorry');
		else
			dbms_output.put_line('Haha');
		end if;
			dbms_output.put_line(sql%rowcount);

		exception 
			when no_data_found then
				dbms_output.put_line('Sorry No data');
			when too_many_rows then
				dbms_output.put_line('Too Many rows');
	end;

end;
/