package com.joe.qiao.domain.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Joe Qiao
 * @Date 22/03/2018.
 */
public class MsgListener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        TextMessage textMsg=(TextMessage)message;
        try {
            System.out.println(textMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
