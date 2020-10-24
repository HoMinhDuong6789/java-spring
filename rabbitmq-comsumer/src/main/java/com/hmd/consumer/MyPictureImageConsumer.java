package com.hmd.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmd.entity.Picture;
import com.rabbitmq.client.Channel;

//@Service
public class MyPictureImageConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger log = LoggerFactory.getLogger(MyPictureImageConsumer.class);

	@RabbitListener(queues = "course.q.picture.log")
	public void lister(Message message, Channel channel) throws JsonParseException, JsonMappingException, IOException {
		var picture= objectMapper.readValue(message.getBody() , Picture.class);
		if(picture.getSize()>9000){
			channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
			throw new AmqpRejectAndDontRequeueException("Picture size too large: "+picture);
		}
		
		log.info("On log consumer: {}", picture.toString());
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}

}