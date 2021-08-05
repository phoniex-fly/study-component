package com.example.a_direct;

import com.example.util.MessageUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        Connection connection = MessageUtil.createConnection();
        //4.创建通道,创建通道的原因是，connection是一个tcp连接，频繁创建销毁开销较大，channel是对connection的多路复用，channel是一个双向连接
        Channel channel = connection.createChannel();
        //5.绑定队列
        /**
         * param1:队列名称
         * param2:是否持久化
         * param3:是否独享 true代表只有当前连接可以访问到这个队列
         * param4:是否自动删除，是否用完之后自动删除这个队列
         * param5:其他参数
         */
        channel.queueDeclare("hello", true, false, false, null);
        //6.发送消息
        /**
         * param1:交换机
         * param2:队列名称
         * param3:其他属性
         * param4:消息内容
         */
        channel.basicPublish("", "hello", null, "hello-MQ".getBytes());
        //关闭资源
        MessageUtil.closeChannelAndConnection(connection, channel);
    }

}
