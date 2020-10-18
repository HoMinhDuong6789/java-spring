package com.hmd.consumer;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FixeRateRabbitConsumer{
	
	private final Logger log = LoggerFactory.getLogger(FixeRateRabbitConsumer.class);
	
	@RabbitListener(queues = "course.fixedrate")
	public void listen(String message) {
		log.info("Consuming fixedrate on thread:\t"+message, Thread.currentThread().getName());
		
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
