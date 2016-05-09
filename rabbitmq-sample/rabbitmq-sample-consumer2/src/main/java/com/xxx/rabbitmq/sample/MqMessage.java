package com.xxx.rabbitmq.sample;

import org.springframework.amqp.core.MessageProperties;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Orrin
 * @date: 2016/3/30 15:20
 * @version: V1.0.0
 * @Description:
 **/
public class MqMessage<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T object;

	private MessageProperties messageProperties;

	private Class processClass;

	private String methodName;

	private MqMessage(){

	}

	public MqMessage(T t,MessageProperties messageProperties){
		this.object = t;
		this.messageProperties = messageProperties;
	}

	public MqMessage(T t,MessageProperties messageProperties,Class processClass,String methodName){
		this.object = t;
		this.messageProperties = messageProperties;
		this.processClass = processClass;
		this.methodName = methodName;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public MessageProperties getMessageProperties() {
		return messageProperties;
	}

	public void setMessageProperties(MessageProperties messageProperties) {
		this.messageProperties = messageProperties;
	}

	public Class getProcessClass() {
		return processClass;
	}

	public void setProcessClass(Class processClass) {
		this.processClass = processClass;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
}
