-- 有参函数
create or replace function get_sal(
	empname in varchar2
)return number
is
	result number;
begin
    dbms_output.put_line(empname);

	result := 0;
	return result;
end get_sal;

-- 无参函数
create or replace function get_sal
return number
is
	result number;
begin

	result := 0;
	return result;
end get_sal;

-- 自定义type类型的参数
create or replace function afun(
	p_object in type_renxie_object,
	p_table in type_renxie_table
)return number
is
	result number;
begin

	return result;
end afun;


-- 调用自定义type类型参数的函数

declare
	rec1 type_renxie_table;
	rec2 type_renxie_table;
begin

	rec1:=type_renxie_table();
	rec1.extend;
	rec1.aaaa:='aaaa';
	rec1.bbbb:='bbbb';

	rec2.extend;
	rec2:=type_renxie_table('','');

	result = afun(rec1(1),rec2);
    dbms_output.put_line(result);
end;
/