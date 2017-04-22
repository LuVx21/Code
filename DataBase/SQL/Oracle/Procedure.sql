-- 输出内容
create or replace procedure printf(
    param1 in varchar2
)
as
begin
    dbms_output.put_line(param1);
end printf;




-- 输入一条线
create or replace procedure print_line
as
begin
    dbms_output.put_line('------------分割线---------------');
end print_line;