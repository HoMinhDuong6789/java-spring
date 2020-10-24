package com.hmd.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmd.entity.Picture;

@Service
public class PictureLogConsumer {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger log = LoggerFactory.getLogger(PictureLogConsumer.class);
	
	@RabbitListener(queues = "course.q.picture.log")
	public void lister(String message) throws JsonParseException, JsonMappingException, IOException {
		var picture= objectMapper.readValue(message, Picture.class);
		log.info("On log consumer: {}", picture.toString());
	}
}
