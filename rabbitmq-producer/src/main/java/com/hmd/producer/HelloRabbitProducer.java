package com.hmd.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloRabbitProducer {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendHello(String name) {
		rabbitTemplate.convertAndSend("course.hello", "Hello\t" + name);
	}
}
