create or replace function get_sal(
	empname in varchar2
) 
return number
is
	Result number;
begin
	select
		sal
	into
		Result
	from
		emp
	where
		ename = empname;

	return(Result);
end get_sal;