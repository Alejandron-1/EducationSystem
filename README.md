# 家教系统

# 基于Spring Boot 后台的鸿蒙OS家教APP

# 更新了mappers文件的位置，这里的Mybits的默认设置为resoures下的mappers，请注意

## 在测试过程中使用postman进行json的发送

#### 6/10 本次更新还未解决鸿蒙OS使用ZZRHttp发送json请求到后台失败的原因

#### 6/13 解决了鸿蒙OS使用ZZRHttp发送json请求到后台失败的原因

##### 使用花生壳做 外网穿透 ，鸿蒙OS_APP，使用远程模拟运行，那么鸿蒙就从外网寻找本机ip，一般来说本机ip都是内网ip，需要映射到外网的唯一ip去；

发现了Result返回给客户端存在bug，修改了全部的controller代码，以后发送给客户端都带有实体类数据