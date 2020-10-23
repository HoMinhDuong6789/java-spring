package com.hmd.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmd.entity.Picture;

@Service
public class PictureProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public void sendMessage(Picture picture) throws JsonProcessingException {
		var json  = objectMapper.writeValueAsString(picture);
		rabbitTemplate.convertAndSend("course.x.picture", picture.getType(), json);
		
	}
}
