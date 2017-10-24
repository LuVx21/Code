# mac下python使用cx_Oracle

访问
http://www.oracle.com/technetwork/topics/intel-macsoft-096467.html
下载压缩包:`instantclient-basic-macos.x64-12.1.0.2.0.zip`
解压在`/usr/local/instantclient_12_1/`文件夹下

主目录下创建lib文件夹
`mkdir ~/lib`
创建快捷方式
`ln -s /usr/local/instantclient_12_1/libclntsh.dylib.12.1 ~/lib/`

或者直接拷贝文件
`cp /usr/local/instantclient_12_1/{libclntsh.dylib.12.1,libclntshcore.dylib.12.1,libons.dylib,libnnz12.dylib,libociei.dylib} ~/lib/`
11.2版本
`cp /usr/local/instantclient_11_2/{libclntsh.dylib.11.1,libnnz11.dylib,libociei.dylib} ~/lib/`
