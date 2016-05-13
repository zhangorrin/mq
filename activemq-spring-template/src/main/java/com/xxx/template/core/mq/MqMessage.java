package com.xxx.template.core.mq;

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

	private volatile String messageId;

	private volatile String appId;

	private volatile String functionId;

	private volatile String type;

	private Class processClass;

	private String methodName;

	private MqMessage(){

	}

	public MqMessage(T t, String messageId, String appId, String functionId, String type){
		this.object = t;
		this.messageId = messageId;
		this.appId = appId;
		this.functionId = functionId;
		this.type = type;
	}

	public MqMessage(T t, String messageId, String appId, String functionId, String type, Class processClass, String methodName){
		this.object = t;
		this.messageId = messageId;
		this.appId = appId;
		this.functionId = functionId;
		this.type = type;
		this.processClass = processClass;
		this.methodName = methodName;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
