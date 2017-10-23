# Oracle TYPE Object

@(Oracle)

> [TOC]

## 1. 理解
对比java等语言中的对象

## 2. 
```
create or replace type address_typ as object (  
    street          varchar2(30),                       
    city            varchar2(20),  
    state           char(2),                              
    postal_code     varchar2(6)    
); 
```
```
create or replace type employee_typ as object(  
    employee_id       number(6),  
    first_name        varchar2(20),  
    last_name         varchar2(25),  
    email             varchar2(25),  
    phone_number      varchar2(25),  
    hire_date         date,  
    job_id            varchar2(25),                                                     
    salary            number(8,2),                
    commission_pct    number(2,2),                                                     
    manager_id        number(6),                                                     
    department_id     number(4),                                                     
    address           address_typ                                                     
    map member function get_idno return number,                                                     
    member procedure display_address(self in out nocopy employee_typ)  
);  
```
```
create type body employee_typ as  
  map member function get_idno return number is  
  begin
    return employee_id;
  end;
  member procedure display_address ( self in out nocopy employee_typ ) is  
  begin  
    dbms_output.put_line(first_name || ' '  || last_name);  
    dbms_output.put_line(address.street);  
    dbms_output.put_line(address.city || ', '  || address.state || ' ' ||  
                         address.postal_code);     
  end;  
end;
```
**持久化对象**
```
create table employee_tab of employee_typ;
create type  emp_typ as table of employee_typ;
```
## 3. 使用Object
```
declare  
  emp employee_typ; -- emp is atomically null  
begin  
-- call the constructor for employee_typ  
  emp := employee_typ(315, 'francis', 'logan', 'flogan',  
        '555.777.2222', to_date('2012-12-24', 'yyyy-mm-dd'), 'sa_man', 11000, .15, 101, 110,  
         address_typ('376 mission', 'san francisco', 'ca', '94222'));  
  dbms_output.put_line(emp.first_name || ' ' || emp.last_name); -- display details  
  emp.display_address();  -- call object method to display details  
end; 
```
## 4. 初始化Object
```
Code 
```
## 5. PL/SQL中操纵
```
declare  
  emp employee_typ;  
begin  
  insert into employee_tab values (employee_typ(310, 'evers', 'boston', 'eboston',  
   '555.111.2222', to_date('2012-12-24', 'yyyy-mm-dd'), 'sa_rep', 9000, .15, 101, 110,  
    address_typ('123 main', 'san francisco', 'ca', '94111')) );  
  insert into employee_tab values (employee_typ(320, 'martha', 'dunn', 'mdunn',  
    '555.111.3333', to_date('2012-11-5', 'yyyy-mm-dd'), 'ac_mgr', 12500, 0, 101, 110,  
    address_typ('123 broadway', 'redwood city', 'ca', '94065')) );  
end; 
```
```
declare  
  emp employee_typ;  
begin  
  insert into employee_tab values (employee_typ(370, 'robert', 'myers', 'rmyers',  
   '555.111.2277', to_date('2012-3-7', 'yyyy-mm-dd'), 'sa_rep', 8800, .12, 101, 110,  
    address_typ('540 fillmore', 'san francisco', 'ca', '94011')) );  
  
  update employee_tab e
  set e.address.street = '1040 california'  
  where e.employee_id = 370;  
  
  delete from employee_tab e where e.employee_id = 310;  
end;
```
## 6. 通过REF修饰符操纵对象
```
declare  
  emp           employee_typ;  
  emp_ref   ref employee_typ;  
  emp_name      varchar2(50);  
begin  
  select ref(e) into emp_ref from employee_tab e where e.employee_id = 370;  
-- the following assignment raises an error, not allowed in pl/sql  
-- emp_name := emp_ref.first_name || ' ' || emp_ref.last_name;  
-- emp := deref(emp_ref); not allowed, cannot use deref in procedural statements  
  select deref(emp_ref) into emp from dual; -- use dummy table dual  
  emp_name := emp.first_name || ' ' || emp.last_name;  
  dbms_output.put_line(emp_name);  
end; 
```
## 7. 定义相当于pl/sql集合类型的sql类型（defining sql types equivalent to pl/sql collection types）

### 7.1 定义嵌套表：
```
--建嵌套表类型
create type courselist as table of varchar2(10)  -- define type
--建对象类型
create type student as object (
   id_num  integer(4),
   name    varchar2(25),
   address varchar2(35),
   status  char(2),
   courses courselist);  -- declare nested table as attribute
--建立嵌套表类型表
create table sophomores of student
  nested table courses store as courses_nt;
--插入数据
insert into sophomores 
values(1,'dylan','carl street','active',
       courselist('math1020')
      );
--查询
select  a.*, b.* 
from  sophomores a, table(a.courses) b; 

select /*+ nested_table_get_refs */ * 
from courses_nt t;
```

### 7.2 定义数组：
```
-- 声明数组类型（each project has a 16-character code name）
-- we will store up to 50 projects at a time in a database column.
create type projectlist as varray(50) of varchar2(16);
--创建表
create table dept_projects (  -- create database table
   dept_id  number(2),
   name     varchar2(15),
   budget   number(11,2),
-- each department can have up to 50 projects.
   projects projectlist);

--插入数据：
  insert into dept_projects
    values(60, 'security', 750400,
      projectlist('new badges', 'track computers', 'check exits'));
```
## 8. 在动态SQL中使用对象
```
create type person_typ as object (name varchar2(25), age number);  
  
create type hobbies_var as varray(10) of varchar2(25);  
  
create or replace package teams  
   authid current_user as  
   procedure create_table (tab_name varchar2);  
   procedure insert_row (tab_name varchar2, p person_typ, h hobbies_var);  
   procedure print_table (tab_name varchar2);  
end;  
  
create or replace package body teams as  
   procedure create_table (tab_name varchar2) is  
   begin  
      execute immediate 'create table ' || tab_name ||  
                        ' (pers person_typ, hobbs hobbies_var)';  
   end;  
   procedure insert_row (  
      tab_name varchar2,  
      p person_typ,  
      h hobbies_var) is  
   begin  
      execute immediate 'insert into ' || tab_name ||  
         ' values (:1, :2)' using p, h;  
   end;  
   procedure print_table (tab_name varchar2) is  
      type  refcurtyp is ref cursor;  
      v_cur refcurtyp;  
      p     person_typ;  
      h     hobbies_var;  
   begin  
      open v_cur for 'select pers, hobbs from ' || tab_name;  
      loop  
         fetch v_cur into p, h;  
         exit when v_cur%notfound;  
         -- print attributes of 'p' and elements of 'h'  
         dbms_output.put_line('name: ' || p.name || ' - age: ' || p.age);  
         for i in h.first..h.last  
         loop  
           dbms_output.put_line('hobby(' || i || '): ' || h(i));  
         end loop;  
      end loop;  
      close v_cur;  
   end;  
end;  
```
### 8.2 调用TEAMS包中的存储过程：
```
declare  
   team_name varchar2(15);  
begin  
   team_name := 'notables';  
   teams.create_table(team_name);  
   teams.insert_row(team_name, person_typ('john', 31),  
      hobbies_var('skiing', 'coin collecting', 'tennis'));  
   teams.insert_row(team_name, person_typ('mary', 28),  
      hobbies_var('golf', 'quilting', 'rock climbing', 'fencing'));  
   teams.print_table(team_name);  
end;  
```