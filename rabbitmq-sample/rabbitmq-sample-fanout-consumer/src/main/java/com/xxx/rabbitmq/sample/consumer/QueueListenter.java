package com.xxx.rabbitmq.sample.consumer;

import com.xxx.rabbitmq.sample.MqMessage;
import com.xxx.rabbitmq.sample.ObjectAndByte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Orrin
 * @date: 2016/3/30 14:05
 * @version: V1.0.0
 * @Description: 定义监听器, 消费接收
 **/
public class QueueListenter implements MessageListener {

	private Logger logger = LoggerFactory.getLogger(QueueListenter.class);

	@Override
	public void onMessage(Message message) {

		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sysDatetime = fmt.format(calendar.getTime());

		logger.info(sysDatetime + " fanout consumer  receive message");

		logger.info("[*]QueueListenter receive message body length:"+message.getBody().length);
		Object bodyObject = ObjectAndByte.toObject(message.getBody());

		if(bodyObject instanceof MqMessage){

			MqMessage mqMessage = (MqMessage)bodyObject;

			if(mqMessage.getProcessClass()!=null && !StringUtils.isEmpty(mqMessage.getMethodName())){

				Class parameterTypes = mqMessage.getObject().getClass();
				Class processClass = mqMessage.getProcessClass();

				Object processObject = null;
				try{
					processObject = ContextLoader.getCurrentWebApplicationContext().getBean(processClass);
				}catch (Exception e){
					try {
						processObject = processClass.newInstance();
					} catch (InstantiationException e1) {
						logger.info("[*]QueueListenter get processing message object error:"+e.getMessage());
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						logger.info("[*]QueueListenter get processing message object error:"+e.getMessage());
						e1.printStackTrace();
					}
				}

				try {
					Method method = processClass.getMethod(mqMessage.getMethodName(),parameterTypes);

					Object obj = method.invoke(processObject,mqMessage.getObject());

					logger.info("[*]QueueListenter process message result:"+ (obj ==null?obj:obj.toString()));

				} catch (NoSuchMethodException e) {
					logger.info("[*]QueueListenter not found the method of processing message:"+e.getMessage());
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					logger.info("[*]QueueListenter not found invocation target of the processing message method:"+e.getMessage());
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					logger.info("[*]QueueListenter processing message but IllegalAccessException:"+e.getMessage());
					e.printStackTrace();
				}
			}


		}

	}

}