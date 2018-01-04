create or replace package apkg
is
	type record_name is record(
		emp_no emp.empno%type,
		emp_nm emp.ename%type
	);

	type varray_name is varray(100) of varchar2(10);

	type table_name is table of varchar2(10)
	index by binary_integer;

	function afun(
		i_parameter_v in varchar2
	)
	return varchar2;

	procedure apro(
		i_parameter_v varchar2
	);

end apkg;



create or replace package body apkg
is
	g_constantname_v constant varchar2(10) := '1234567890';
	g_variablename_v varchar2(10):=null;

	v_recode record_name;
	v_array varray_name := varray_name('1','2','3');
	v_table table_name;

	function afun(
		i_parameter_v in varchar2
	)
	return varchar2
	is
		l_constantname_v constant varchar2(10) := '0987654321';
		l_variablename_v varchar2(10):=null;
	begin
		dbms_output.put_line(i_parameter_v);
		return 'yes';
	end afun;

	procedure apro(
		i_parameter_v varchar2
	)
	is
	begin
		dbms_output.put_line('---------------------------------------------------------');
		dbms_output.put_line(i_parameter_v);
		dbms_output.put_line('---------------------------------------------------------');
	end apro;

begin
	null;
end apkg;