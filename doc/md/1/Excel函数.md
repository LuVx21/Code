# Excel函数
1. index()
2. min():最小
3. max():最大
4. small():第几小
5. large():第几大
6. row():当前位置的行No
7. rows():当前区域的行数
8. column():当前位置列No
9. columns():当前区域的列数

```
=INDEX(A:A,SMALL(IF($F$2=LEFT($A$2:$A$999,LEN($F$2)),ROW($2:$999),4^8),ROW(A1)))&""
```


