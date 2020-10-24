package com.hmd;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hmd.entity.Picture;
import com.hmd.producer.MyPictureProducer;
import com.hmd.producer.PictureProducerTwo;
import com.hmd.producer.RetryPictureProducer;

@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {

	@Autowired
	private RetryPictureProducer pictureProducer;

	private final List<String> SOURCES = List.of("mobile", "web");
	private final List<String> TYPES = List.of("jpg", "png", "svg");

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// helloRabbitProducer.sendHello("Mitt\t"+Instant.now());

		for (int i = 0; i < 10; i++) {
			var picture = new Picture();
			picture.setName("Picture: " + i);
			picture.setSize(ThreadLocalRandom.current().nextLong(9994, 10001));
			picture.setSource(SOURCES.get(i % SOURCES.size()));
			picture.setType(TYPES.get(i % TYPES.size()));

			pictureProducer.sendMessage(picture);
		}
	}

}
