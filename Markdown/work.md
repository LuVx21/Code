# work

> [toc]

夢の景色のような、美しい眺めだった。
```
set yyyymmdd=%date:~0,4%%date:~5,2%%date:~8,2%
set time2=%time: =0% 
set hhmi=%time2:~0,2%%time2:~3,2%

mkdir "y:\test\%yyyymmdd%%hhmi%\renxie\"

del "y:\test\%yyyymmdd%%hhmi%\renxie\*.xls"
xcopy ".\*.xls" "y:\test\%yyyymmdd%%hhmi%\renxie"

pause
```
## 自定义类型
```
create or replace type c_pkg."c05001a020d01" as object(
	edit_flg		char(1),		-- 更新フラグ
	kei_kenshu_no		char(19)		-- 契約検収番号
)
/

create or replace type c_pkg."c05001a020t01"　is table of c05001a020d01
/
```
```
-- 契約検収配列
type type_kei_kenshu_rec is record (
	kei_kenshu_key			tmc0110.kei_kenshu_key%type	-- 契約検収キーを格納
);

type type_kei_kenshu_tbl is table of type_kei_kenshu_rec 
index by pls_integer;
```
```
create public synonym tmc0730 for c_master.tmc0730
/
```
## 序列
```
create sequence seq_chohyo_renban
increment by 1
start with 1000
maxvalue 999999999999999999999
nominvalue
nocycle 
nocache
noorder 
/

select
	seq_chohyo_renban.nextval
from
	dual
;

index
```
## 闪回查询
```
执行后仅仅是查询!
select * from TMC0110 as of timestamp sysdate-5/1440;
select * from TMC0110 as of timestamp to_date('2012-08-29 19:49:00', 'yyyy-mm-dd hh24:mi:ss');
```
```
tree /f
tree /a
tree /f > tree.txt

=SUBSTITUTE(RIGHT(CELL("filename",BH4),LEN(CELL("filename",BH4))-FIND("[",CELL("filename",BH4))),".xlsx]","_")

夢の景色のような、美しい眺めだった。

NO_DATA_FOUND			
	sys_ctl.user_error(MC_PGMID || '.' || C_PROCID);		
OTHERS			
	sys_ctl.system_error(SQLCODE, SQLERRM, MC_PGMID || '.' || C_PROCID);
```