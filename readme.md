# 1、创建配置数据库
执行脚本：config-bus-server/src/main/resources/db.sql
# 2、启动配置总线服务器
运行程序：config-bus-server/src/main/java/monkey.config.bus.server/ConfigBusServerApplication
# 3、设置配置总线服务器地址
配置环境变量：CONFIG_BUS_SERVER_URL=配置总线服务器地址（默认为http://localhost:60000）
# 4、启动服务提供端程序
运行程序：demo/test-service-provider/src/main/java/monkey.test.service.provider/ServiceProviderApplication
# 5、启动服务消费端程序
运行程序：demo/test-service-consumer/src/main/java/monkey.test.service.consumer/ServiceConsumerApplication
# 6、测试服务访问功能是否正常
请求接口：http://localhost:38080/say?words=ok，返回ok代表成功
# 7、创建测试数据库
执行脚本：demo/test-data-mapper/src/main/resources/db.sql
配置环境：在配置数据库中，根据实际情况配置集群(sc_db_cluster)、节点(sc_db_node)、路由(sc_db_path)
# 8、测试数据库访问功能是否正常
请求接口：http://localhost:38080/save?name=ok，返回ok代表成功,查看表“test_city”里有无数据