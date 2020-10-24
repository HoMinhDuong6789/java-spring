package com.hmd.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmd.entity.Picture;

@Service
public class PictureProducerTwo {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	private ObjectMapper objectMapper = new ObjectMapper();

	public void sendMessage(Picture picture) throws JsonProcessingException {
		var sb = new StringBuffer();
		sb.append(picture.getSource());
		sb.append(".");

		if (picture.getSize() > 4000) {
			sb.append("large");
			
		}else {
			sb.append("small");
		}
		sb.append(".");
		sb.append(picture.getType());
		
		var json = objectMapper.writeValueAsString(picture);
		var routingKey = sb.toString();
		rabbitTemplate.convertAndSend("course.x.picture2", routingKey, json);

	}
}
