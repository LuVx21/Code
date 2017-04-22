select * from python;


CREATE TABLE EMPLOYEE (
         FIRST_NAME  CHAR(20) NOT NULL,
         LAST_NAME  CHAR(20),
         AGE INT,
         SEX CHAR(1),
         INCOME FLOAT )
;

insert into employee values('xie0','ren0',25,'m',3000);
insert into employee values('xie1','ren1',31,'m',3000);
insert into employee values('xie','ren',25,'m',3000);

update employee set INCOME = 8000 where FIRST_NAME = 'xie' and LAST_NAME = 'ren';