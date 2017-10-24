# Oralce 递归查询

@(Oracle)

> [TOC]

```
SELECT kei_kenshu_key,hktgmt_kei_kenshu_key
FROM
    tmc0110 KEIKN
WHERE
  --  KEIKN.hktgmt_kei_kenshu_key IS NULL
--AND ROWNUM = 1
KEIKN.rnri_sakujo_sgn  = '0'
START WITH
KEIKN.kei_kenshu_key
= '10000000000000845686'
CONNECT BY PRIOR
KEIKN.hktgmt_kei_kenshu_key
= KEIKN.kei_kenshu_key
;
```