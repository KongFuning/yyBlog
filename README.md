# yy博客系统

支持登录和注册

非登录状态不能查看、修改和删除文章

登录状态下 可以查看、修改、删除自己的文章，他人文章只能查看

登录状态下可以发表文章

# 环境

MySQL 8

Tomcat 8.5

jdk 1.8

IDEA

# 使用说明

jdbc相关的jar存放在web-WEB INF-libs下

需要tomcat安装目录下lib中的servlet包，自行导入

sql文件在yyblog.sql文件中，自行导入至数据库

数据库配置文件在druid.properties中，修改自己需要的数据即可



@author KongFuning

@Email 1114638323@qq.com

@Date 2021.10.05 23:51
