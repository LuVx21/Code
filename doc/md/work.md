# work

> [toc]

夢の景色のような、美しい眺めだった。
```

set yyyymmdd=%date:~0,4%%date:~5,2%%date:~8,2%
set time2=%time: =0% 
set hhmi=%time2:~0,2%%time2:~3,2%

mkdir "y:\999_work\xxx_dba作業場\005_定例作業\%yyyymmdd%%hhmi%\専用\"

del "y:\999_work\xxx_dba作業場\005_定例作業\%yyyymmdd%%hhmi%\専用\*.xls"
xcopy ".\*.xls" "y:\999_work\xxx_dba作業場\005_定例作業\%yyyymmdd%%hhmi%\専用"

pause


CREATE OR REPLACE TYPE C_PKG."C05001A020T01"　IS TABLE OF c05001a020d01
/
CREATE OR REPLACE TYPE C_PKG."C05001A020D01" AS OBJECT(
	edit_flg		CHAR(1),		-- 更新フラグ
	kei_kenshu_no		CHAR(19)		-- 契約検収番号
)
/

-- 契約検収配列
TYPE type_kei_kenshu_rec IS record (
	kei_kenshu_key			tmc0110.kei_kenshu_key%TYPE,	-- 契約検収キーを格納
);

TYPE type_kei_kenshu_tbl IS TABLE OF type_kei_kenshu_rec INDEX BY PLS_INTEGER;

create public synonym tmc0730 for c_master.tmc0730
/

CREATE SEQUENCE LEASSYS.SEQ_CHOHYO_RENBAN
INCREMENT BY 1
START WITH 6223
MAXVALUE 999999999999999999999
NOMINVALUE
NOCYCLE 
NOCACHE
NOORDER 
/

		SELECT
			seq_chohyo_renban.NEXTVAL
		FROM
			DUAL
		;

index


执行后仅仅是查询!
select * from TMC0730 as of timestamp sysdate-5/1440;
select * from test as of timestamp to_date('2012-08-29 19:49:00', 'yyyy-mm-dd hh24:mi:ss');
------------
select * from TMC0730 as of timestamp to_date('2017-01-19 12:00:00', 'yyyy-mm-dd hh24:mi:ss');
select * from TMC0740 as of timestamp to_date('2017-01-19 12:00:00', 'yyyy-mm-dd hh24:mi:ss');
select * from TMC0110 as of timestamp to_date('2017-01-19 12:00:00', 'yyyy-mm-dd hh24:mi:ss');

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