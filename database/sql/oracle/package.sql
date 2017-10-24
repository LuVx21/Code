create or replace package PKG_name
is

	type record_name is record(
		emp_no emp.empno%type,
		emp_nm emp.ename%type
	);
	

	type varray_name is varray(100) of varchar2(10);

	type table_name is table of varchar2(10)
	index by binary_integer;

	function function_name(i_Parameter_v in varchar2)
	return varchar2;

	procedure procedure_name(
		i_Parameter_v varchar2
	);

end PKG_name;



create or replace package body PKG_name
is
	G_CONSTANTNAME_V constant varchar2(10) := '1234567890';
	g_variablename_v varchar2(10):=NULL;
	
	v_recode record_name;
	v_array varray_name := varray_name('1','2','3');
	v_table table_name;
	
	function function_name(i_Parameter_v in varchar2)
	return varchar2
	is
		L_CONSTANTNAME_V constant varchar2(10) := '0987654321';
		l_variablename_v varchar2(10):=NULL;
	begin
		dbms_output.put_line(i_Parameter_v);
		return 'Yes';
	end function_name;
	
	procedure procedure_name(
		i_Parameter_v varchar2
	)
	is
	begin
		dbms_output.put_line('---------------------------------------------------------');
		dbms_output.put_line(i_Parameter_v);
		dbms_output.put_line('---------------------------------------------------------');
	end procedure_name;
begin
	NULL;
end PKG_name;