# **个人项目api**

## **项目介绍**
    个人项目api集成到springcloud
    
## **默认用户介绍**
    用户名： 
    密码：  	
	

##  **技术栈**
    1、SpringCloud Greenwich.SR1
    2、SpringBoot 2.1.3.RELEASE
    3、Redis    缓存
    4、Mysql 5.6    数据库
   
        
    
## **本地运行 启动顺序**
    1、server
    2、zuul
    3、auth
    4、admin
  

## **代码模块划分**
    ├── common   基础配置及工具类
    ├── server   注册中心
    ├── zuul     网关
    ├── auth     统一鉴权模块
    ├── tx-lcn   分布式事务中心 http://127.0.0.1:7970/admin/index.html#/   密码 123456
    ├── admin     后台管理

    
## **开发环境**
    JDK 1.8
    Redis 3.2及以上
    
## **部署运行**