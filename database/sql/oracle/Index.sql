-- 
create unique index use_pk
on user(userid desc)



-- 创建
alter index index_name rename to bitmap_index;
-- 合并
alter index index_name coalesce;
-- 重建
alter index index_name rebuild;
-- 删除
drop index index_sno;
