package com.xxx.template.core.mq;

import com.xxx.template.core.mq.producer.queue.QueueSender;
import com.xxx.template.core.mq.producer.topic.TopicSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Orrin
 * @date: 2016/5/9 14:22
 * @version: V1.0.0
 * @Description:
 **/
public class TestMain {
	private static volatile ApplicationContext ctx;


	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContex*.xml");

		QueueSender queueSender = ctx.getBean(QueueSender.class);

		TopicSender topicSender = ctx.getBean(TopicSender.class);

		queueSender.send("test.queue", "test.queue");

		topicSender.send("test.topic", "test.topic");
	}
}
