# 重置mysql密码
1. 关闭mysql服务
2. cd /usr/local/mysql/bin/
3. 登录管理员权限 sudo su
4. 禁止mysql验证功能 ./mysqld_safe --skip-grant-tables &
5. 此时服务状态为running
6. ./mysql
7. FLUSH PRIVILEGES; 
8. set password for 'root'@'localhost'=1121

## 进入mysql命令行



