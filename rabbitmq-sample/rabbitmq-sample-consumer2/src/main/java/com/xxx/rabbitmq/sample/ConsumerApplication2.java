package com.xxx.rabbitmq.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Orrin
 * @date: 2016/3/30 14:51
 * @version: V1.0.0
 * @Description:
 **/
public class ConsumerApplication2 {
	private static volatile ApplicationContext ctx;

	final static String exchange = "my-mq-exchange";

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:spring/application-*.xml");

		System.out.println("----------ConsumerApplication start completed--------------------");


	}
}