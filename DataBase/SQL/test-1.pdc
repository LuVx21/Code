set serveroutput on
declare

col1 char(1);
col2 char(100);

col11 char(1);
col22 char(100);
count0 number := 1;
--p_chohyo_renban_i		FWVARRAY;
begin

--dbms_output.put_line('==========================================================');

for num1 in 1..1 LOOP

  for num0 in (select char_a,char_b from testa order by char_a) LOOP
  dbms_output.put_line('==========================================================');
  dbms_output.put_line(num0.char_a||'--'||num0.char_b);
  dbms_output.put_line('backup:'||col11||'--'||col22);
  dbms_output.put_line('==========================================================');
  IF num0.char_a = col11 and num0.char_b = col22 THEN
    dbms_output.put_line('Œ‹‰ÊFyiyang');
  ELSE
    dbms_output.put_line('Œ‹‰ÊFbuyiyang');
--    p_chohyo_renban_i(count0):='test';
--    count0:=count0+1;
  END IF;
  
  col11:=num0.char_a;
  col22:=num0.char_b;
  --dbms_output.put_line('renxie');
  END LOOP;

END LOOP;

--dbms_output.put_line('==========================================================');
end;
/
