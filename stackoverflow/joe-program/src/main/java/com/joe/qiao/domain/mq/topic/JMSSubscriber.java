package com.joe.qiao.domain.mq.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Joe Qiao
 * @Date 22/03/2018.
 */


public class JMSSubscriber {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//默认连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认连接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认连接地址

    public static void main(String[] args){
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接

        Session session = null;//会话 接受或者发送消息的线程
        Topic topic;//消息的主题

        MessageConsumer messageConsumer;//消息的消费者
        messageConsumer = null;

        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSSubscriber.USERNAME, JMSSubscriber.PASSWORD, JMSSubscriber.BROKEURL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建一个连接Joe_Topic的消息主题
            topic = session.createTopic("Joe_Topic");
            //创建Subscriber
            messageConsumer = session.createConsumer(topic);
            while (true) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive(10000);//阻塞方法
                if(textMessage != null){
                    System.out.println("收到的消息:" + textMessage.getText());
                }else{
                    break;
                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                if (messageConsumer != null) {
                    messageConsumer.close();
                }
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}