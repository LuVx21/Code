set serveroutput on
declare

col1 char(1);
col2 char(100);

col11 char(1);
col22 char(100);
count0 number := 1;
p_chohyo_renban_i  LEASSYS.FWVARRAY := NULL;

type t_table is table of varchar2(10) index by BINARY_integer; 
   MyTab   t_table; 

begin

    p_chohyo_renban_i(1):='A';
    dbms_output.put_line(p_chohyo_renban_i(1));

/*
for num1 in 1..3 LOOP

    p_chohyo_renban_i := null;
    p_chohyo_renban_i(count0):='test';
    count0:=count0+1;
    dbms_output.put_line(count0);
  
END LOOP;
*/
--dbms_output.put_line('==========================================================');
end;
/
