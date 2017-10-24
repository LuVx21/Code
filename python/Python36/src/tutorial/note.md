该文件目录下执行
```
scrapy crawl test -o test.json -t json
```

爬虫项目量非常大时候,可能不能一次执行完毕，需要分好几次执行.
只需要在启动爬虫的时候键入命令
```
scrapy crawl xxx -s JOBDIR=job1
```
想要暂停的时候按下`ctrl+c`
恢复时重新执行上面的命令