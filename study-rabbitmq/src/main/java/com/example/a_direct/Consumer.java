package com.example.a_direct;

import com.example.util.MessageUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        Connection connection = MessageUtil.createConnection();
        //创建信道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare("hello", true, false, false, null);
        //消费消息
        /**
         *
         */
        channel.basicConsume("hello", new DefaultConsumer(channel) {
            /**
             *
             * @param consumerTag
             * @param envelope
             * @param properties
             * @param body
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者接收消息:" + new String(body));
            }
        });
        System.in.read();
    }
}
