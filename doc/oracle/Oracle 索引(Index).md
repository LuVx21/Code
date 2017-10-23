# Oracle 索引(Index)
alter index TMC0110_PK unusable;
alter index TMC0110_PK rebuild;
alter session set skip_unusable_indexes=false;
select * from user_indexes

