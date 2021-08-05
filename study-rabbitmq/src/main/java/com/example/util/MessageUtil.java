package com.example.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageUtil {

    /**
     * 创建连接
     *
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Connection createConnection() throws IOException, TimeoutException {
        //1、创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2.设置连接参数
        factory.setHost("127.0.0.1");//连接主机
        factory.setPort(5672);//连接端口
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("v-phoenix");//虚拟主机
        //3、创建连接
        Connection connection = factory.newConnection();
        return connection;
    }

    public static void closeChannelAndConnection(Connection connection, Channel channel) throws IOException, TimeoutException {
        //7.关闭连接
        channel.close();
        connection.close();
    }
}
