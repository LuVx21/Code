# 闪回查询

@(Oracle)

```
select * from table as of timestamp sysdate-5/1440;
```

```
select * from TMC0730 as of timestamp (systimestamp - interval '1'day);
```
```
select * from test as of timestamp to_date('2012-08-29 19:49:00', 'yyyy-mm-dd hh24:mi:ss')
```

http://blog.csdn.net/cooljun618/article/details/7180401
http://docs.oracle.com/cd/B28359_01/appdev.111/b28424/adfns_flashback.htm#BJFJDBAJ


synonym
index