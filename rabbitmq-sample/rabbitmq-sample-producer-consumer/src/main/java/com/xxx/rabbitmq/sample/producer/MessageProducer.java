package com.xxx.rabbitmq.sample.producer;

import com.xxx.rabbitmq.sample.MqMessage;
import com.xxx.rabbitmq.sample.ObjectAndByte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Orrin
 * @date: 2016/3/30 14:09
 * @version: V1.0.0
 * @Description: 消息产生, 提交到队列中去
 **/
@Service
public class MessageProducer {

	private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

	@Resource
	private AmqpTemplate amqpTemplate;

	public void sendMessage(String routingKey, MqMessage mqMessage) {
		//logger.info("MessageProducers send message:{}",mqMessage);
		//amqpTemplate.convertAndSend(queue_key,message);
		Message message = new Message(ObjectAndByte.toByteArray(mqMessage), mqMessage.getMessageProperties());
		amqpTemplate.convertAndSend(routingKey, message);

		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sysDatetime = fmt.format(calendar.getTime());

		logger.info(sysDatetime + "  send message");

	}

}
