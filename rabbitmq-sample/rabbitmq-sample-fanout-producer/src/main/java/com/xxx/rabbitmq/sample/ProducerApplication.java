package com.xxx.rabbitmq.sample;

import com.xxx.rabbitmq.sample.producer.MessageProducer;
import com.xxx.rabbitmq.sample.test.PrintMqMessageService;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Orrin
 * @date: 2016/3/30 14:51
 * @version: V1.0.0
 * @Description:
 **/
public class ProducerApplication {
	private static volatile ApplicationContext ctx;


	public static void main(String[] args) {
		String routingKey = "";
		ctx = new ClassPathXmlApplicationContext("classpath:spring/application-*.xml");

		System.out.println("----------ProducerApplication start completed--------------------");

		System.out.println("----------MessageProducer send message start--------------------");

		MessageProducer messageProducer = ctx.getBean(MessageProducer.class);

		Map<String, Object> msg = new HashMap<>();
		MessageProperties messageProperties = new MessageProperties();

		for (int i = 0; i < 10; i++) {
			/*try {
				Thread.sleep(1000 * 5 );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			msg.put("data", "hello,rabbmitmq!  "+i);

			//msg.put("data"+i,"hello,rabbmitmq!  "+i);
			messageProperties.setMessageId(java.util.UUID.randomUUID().toString());
			messageProperties.setAppId(String.valueOf(i));
			MqMessage<Map> mqMessage = new MqMessage(Map.class, messageProperties);
			mqMessage.setObject(msg);
			mqMessage.setProcessClass(PrintMqMessageService.class);
			mqMessage.setMethodName("printMqMessage");

			routingKey = "queue_"+(i%2+1);

			messageProducer.sendMessage("", mqMessage);
		}


		System.out.println("----------MessageProducer send message completed--------------------");




	}
}