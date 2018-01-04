-- 无参过程
create or replace procedure print_line
as
begin
    dbms_output.put_line('------------分割线---------------');
end print_line;


-- 有参过程
create or replace procedure printf(
    param1 in varchar2
)
as
begin
    dbms_output.put_line(param1);
end printf;
