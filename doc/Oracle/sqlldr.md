# 使用sqlldr导入文本数据到oracle

## 1.sqlldr介绍

用法:
	SQLLDR keyword=value [,keyword=value,...]

有效的关键字:

* userid -- ORACLE 用户名/口令
* control -- 控制文件名
* log -- 日志文件名
* bad -- 错误文件名
* data -- 数据文件名
* discard -- 废弃文件名
* discardmax -- 允许废弃的文件的数目 (全部默认)
* skip -- 要跳过的逻辑记录的数目 (默认 0)
* load -- 要加载的逻辑记录的数目 (全部默认)
* errors -- 允许的错误的数目 (默认 50)
* rows -- 常规路径绑定数组中或直接路径保存数据间的行数(默认:常规路径 64, 所有直接路径)
* bindsize -- 常规路径绑定数组的大小 (以字节计) (默认 256000)
* silent -- 运行过程中隐藏消息 (标题,反馈,错误,废弃,分区)
* direct -- 使用直接路径 (默认 FALSE)
* parfile -- 参数文件: 包含参数说明的文件的名称
* parallel -- 执行并行加载 (默认 FALSE)
* file -- 要从以下对象中分配区的文件
* skip_unusable_indexes -- 不允许/允许使用无用的索引或索引分区 (默认 FALSE)
* skip_index_maintenance -- 没有维护索引, 将受到影响的索引标记为无用 (默认 FALSE)
* commit_discontinued -- 提交加载中断时已加载的行 (默认 FALSE)
* readsize -- 读取缓冲区的大小 (默认 1048576)
* external_table -- 使用外部表进行加载; NOT_USED, GENERATE_ONLY, EXECUTE (默认 NOT_USED)
* columnarrayrows -- 直接路径列数组的行数 (默认 5000)
* streamsize -- 直接路径流缓冲区的大小 (以字节计) (默认 256000)
* multithreading -- 在直接路径中使用多线程
* resumable -- 启用或禁用当前的可恢复会话 (默认 FALSE)
* resumable_name -- 有助于标识可恢复语句的文本字符串
* resumable_timeout -- RESUMABLE 的等待时间 (以秒计) (默认 7200)
* date_cache -- 日期转换高速缓存的大小 (以条目计) (默认 1000)
* no_index_errors -- 出现任何索引错误时中止加载 (默认 FALSE)


NOTE: 命令行参数可以由位置或关键字指定
前一种的例子是
'sqlldr scott/tiger foo'
后一种情况的一个示例是
'sqlldr userid=scott/tiger control=foo'

位置指定参数的时间必须早于但不可迟于由关键字指定的参数。
例如
允许'sqlldr scott/tiger control=foo logfile=log',
但是
不允许'sqlldr scott/tiger control=foo log',
即使参数'log'的位置正确。

## 2.实战

先有需求：

将000000_0.txt文件导入Oracle数据库

000000_0.txt大小：123MB，几十万行

000000_0.txt内容格式：

20160514|未知|未知|未知|3G|057431041116|55349|41116|28173301261774|460007863660008|1.224609375|13.0|\N|\N
20160514|HTC|手机|D728w|3G|057431001157|55097|1157|35153907023514|460006620667069|0.513671875|10.0|\N|\N
20160514|HTC|手机|D728w|3G|057431043861|55084|43861|35153907033487|460027685036740|2937.208984375|8052.0|\N|\N
20160514|HTC|手机|D728w|3G|057431003011|55084|3011|35153907033487|460027685036740|1.755859375|56.0|\N|\N



导入的数据库表结构：

create table TEST201605
(
  SHI_JIAN,
  ZDCS,
  ZDFL,
  ZDXH,
  XQWLLX,
  XQWYBH,
  LAC,
  CI,
  IMEI,
  IMSI,
  THREEG_LL,
  THREEG_SZ,
  FOURG_LL
)



### 2.1编写控制文件 load.ctl：
```
load data
CHARACTERSET UTF8  //查看下文件的编码，设为同一个编码
infile "E:\datafile\000000_0.txt"   //只能一个个导入，可以把多个文件合并到一个里，然后导入
append into table TEST201605
fields terminated by '|'
trailing nullcols
(
    --"时间",
    SHI_JIAN,
    ZDCS,
    ZDFL,
    ZDXH,
    XQWLLX,
    XQWYBH,
    LAC,
    CI,
    IMEI,
    IMSI,
    THREEG_LL,
    THREEG_SZ,
    FOURG_LL
)
```


### 2.2 windows下
dos命令窗，cd 到load.ctl所在目录

使用命令：
```
sqlldr daily/mdasil@daily control=load.ctl log=log.log bad=bad.log errors=5000 rows=1000 bindsize=10485760
```

rows与bindsize相关，rows默认64行，如果不修改bindsize，只修改rows无效。

bindsize --（ 每次提交记录的缓冲区的大小，字节为单位，默认256000)

dos窗口会打印：

达到提交点 - 逻辑记录计数 441884
达到提交点 - 逻辑记录计数 441954
达到提交点 - 逻辑记录计数 442024
达到提交点 - 逻辑记录计数 442094



sqllder 导入的时候，不支持中文列名，因为文件里的都是string，导入的表字段也要 字符串 类型 。

（可以控制类型，但是如果数据内容格式不对，导入出错就比较麻烦，还是以string文本导入后，再修改表结构）