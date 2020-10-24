package com.hmd.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmd.entity.Employee;

//@Service
public class AccoutingConsumer {
	private ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger log = LoggerFactory.getLogger(AccoutingConsumer.class);

	@RabbitListener(queues = "course.q.hr.accounting")
	public void listen(String message) {
		Employee emp = null;

		try {
			emp = objectMapper.readValue(message, Employee.class);
			log.info("On accounting, employee is {}", emp);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
