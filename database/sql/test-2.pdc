set serveroutput on

declare
ren number := 0;
col1 char(1);
col2 char(100);
col11 char(1);
col22 char(100);
count0 number := 1;
CURSOR caseCursor IS
select char_a,char_b from testa order by char_a;
num0 caseCursor%ROWTYPE;

begin

-- for num1 in 1..1  -- if there are 1 covenant
for num1 in 1..2  -- if there are 2 covenant
LOOP

  OPEN caseCursor;
    LOOP
      -- カーソルをフェッチする。
      FETCH caseCursor INTO num0;
      EXIT WHEN caseCursor%NOTFOUND;
      
      dbms_output.put_line('==========================================================');
      dbms_output.put_line(num0.char_a||'--'||num0.char_b);
      dbms_output.put_line('backup:'||col11||'--'||col22);
      dbms_output.put_line('==========================================================');
      IF num0.char_a = col11 and num0.char_b = col22 THEN
        dbms_output.put_line('結果：yiyang');
      ELSE
        dbms_output.put_line('結果：buyiyang');
      END IF;
      
      col11:=num0.char_a;
      col22:=num0.char_b;
      -- dbms_output.put_line('renxie');

      insert into testb(char_a,char_b) values(num0.char_a,num0.char_b);
      ren := ren + SQL%ROWCOUNT;
      dbms_output.put_line('Line:'||ren);
    END LOOP;
  CLOSE caseCursor;

END LOOP;
end;
/
