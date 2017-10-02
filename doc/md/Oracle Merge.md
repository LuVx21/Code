# Oracle Merge

@(Oracle)

> [toc]

MERGE命令,你能够在一个SQL语句中对一个表同时执行inserts和updates操作. MERGE命令从一个或多个数据源中选择行来updating或inserting到一个或多个表.在Oracle10g中MERGE有如下一些改进：

1. UPDATE或INSERT子句是可选的
2. UPDATE和INSERT子句可以加WHERE子句
3. 在ON条件中使用常量过滤谓词来insert所有的行到目标表中,不需要连接源表和目标表
4. UPDATE子句后面可以跟DELETE子句来去除一些不需要的行

语法:
```
merge into schema.table R1
using schema.{table | view |subquery } R2 -- 此处可以使用子查询
on (condition)  -- 关联条件
when matched then
    merge_update_clause / merge_delete_clause
when not matched then
    merge_insert_clause / merge_delete_clause;
```
merge into是特有的功能，相当于在 MSSQL中的

```
if exists(...)
update table
else
Insert into table.
```

mergeinto语法不仅没有if exists语法啰嗦，而且比if exists还要高效很多，常用来在oracle之间同步数据库表
优点：

* 避免了分开更新
* 提高性能并易于使用
* 在数据仓库应用中十分有用
* 使用merge比传统的先判断再选择插入或更新快很多

