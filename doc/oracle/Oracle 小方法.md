# Oracle 小方法

@(Oracle)



造的数据,执行一次就没了,可以事先备份

方法1:
```
drop table a;
/
create table a as select * from a_TEMP;
/
```
方法2:
```
delete a;
/
insert into a select * from a_temp;
/
```

