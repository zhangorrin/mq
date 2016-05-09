package com.xxx.template.core.mq.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 
 * @author liang
 * @description  队列消息监听器
 * 
 */

public class QueueReceiver implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("ALL QueueReceiver1接收到消息:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
