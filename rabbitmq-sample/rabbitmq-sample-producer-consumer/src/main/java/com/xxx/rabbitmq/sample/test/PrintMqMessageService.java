package com.xxx.rabbitmq.sample.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Orrin
 * @date: 2016/3/31 11:09
 * @version: V1.0.0
 * @Description:
 **/
@Component
public class PrintMqMessageService {
	private Logger logger = LoggerFactory.getLogger(PrintMqMessageService.class);

	public void printMqMessage(HashMap hashMap){
		logger.info("[*]PrintMqMessageService printMqMessage:" + hashMap.toString());
	}

}
