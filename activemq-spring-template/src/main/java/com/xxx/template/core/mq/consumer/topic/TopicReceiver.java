package com.xxx.template.core.mq.consumer.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * 
 * @author liang
 * @description  Topic消息监听器
 * 
 */

public class TopicReceiver implements MessageListener{


	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("ALL TopicReceiver1接收到消息:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
