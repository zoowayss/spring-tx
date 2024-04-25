# Spring 事务使用 Demo



## 源码地址

[github-spring-tx](https://github.com/zoowayss/spring-tx)



## 发布事件事物问题

1. 在事物状态下发布事件，前面执行的sql ，在事件监听事务中读取不到（因为Mysql事物隔离级别默认**读已提交**）

   ![image-20240424090618358](https://cdn.jsdelivr.net/gh/zooways/picgo/img/image-20240424090618358.png)

   可以看到修改之后，发布事件，在事件事物中，读取到的还是旧值

   ![image-20240424090735486](https://cdn.jsdelivr.net/gh/zooways/picgo/img/image-20240424090735486.png)

2. 如果将 @Transactional 去掉 那么执行完 update 之后，事务已经提交了，在事件事物中就能拿到最新的值

   ![image-20240424091123147](https://cdn.jsdelivr.net/gh/zooways/picgo/img/image-20240424091123147.png)

   结果：

   ![image-20240424091141603](https://cdn.jsdelivr.net/gh/zooways/picgo/img/image-20240424091141603.png)

   ## 定时任务事务问题

   ![image-20240425185337160](https://cdn.jsdelivr.net/gh/zooways/picgo/img/image-20240425185337160.png)

   结果： 能够正常回滚
