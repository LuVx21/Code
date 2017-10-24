质数：
    除2以外,所有质数都是奇数,并且紧挨着6的倍数左右出现,但6的倍数左右不一定是质数.
    所以判断质数,进行整除处理时,只需要对小于判断对象平方根的质数进行整除处理即可(偶数除外,非质数奇数除外)



declare
    type t_record is table of number index by binary_integer;
    v_result t_record;
    v_flag boolean;
    i number default 3;
begin
    v_result(0) := 2;
    while(i < 100000) loop
        v_flag := true;
        for j in 1..v_result.count - 1 loop
            if v_result(j) * v_result(j) > i then
                exit;
            end if;
            if mod(i,v_result(j)) = 0 then
                v_flag := false;
                exit;
            end if;
        end loop;
        if v_flag then
            v_result(v_result.count) := i;
        end if;
        i := i + 2;
    end loop;
end;
/

--------------------------------------------------------
declare
    type t_record is table of number index by binary_integer;
    v_result t_record;
    i number default 3;
begin
    v_result(1) := 3;
    while(i < 100000) loop
        for j in 1..v_result.count loop
            if mod(i,v_result(j)) = 0 then
                exit;
            end if;
            if v_result(j) * v_result(j) > i then
                v_result(v_result.count + 1) := i;
                exit;
            end if;
        end loop;
        i := i + 2;
    end loop;
    v_result(0) := 2;
end;
/

--------------------------------------------------------

declare
    type t_record is table of number index by binary_integer;
    v_result t_record;
    i number default 3;
begin
    v_result(1) := 3;
    while(i < 100000) loop
        for j in 1..v_result.count loop
            if v_result(j) * v_result(j) > i then
                v_result(v_result.count + 1) := i;
                exit;
            end if;
            if trunc(i/v_result(j)) = i/v_result(j) then
                exit;
            end if;
        end loop;
        i := i + 2;
    end loop;
    v_result(0) := 2;
end;
/
--------------------------------------------------------
declare
    type t_record is table of number index by binary_integer;
    v_result t_record;
    i number default 3;
    n number default 0;
begin
    v_result(1) := 3;
    while(i < 100000) loop
        for j in 1..v_result.count loop
            if v_result(j) * v_result(j) > i then
                v_result(v_result.count + 1) := i;
                exit;
            end if;
            if trunc(i/v_result(j)) = i/v_result(j) then
                exit;
            end if;
        end loop;
        if n = 2 then
            i := i + 4;
            n := 1;
        else
            i := i + 2;
            n := n + 1;
        end if;
    end loop;
    v_result(0) := 2;
end;
/