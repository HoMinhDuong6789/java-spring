package com.hmd;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.hmd.entity.Employee;
import com.hmd.entity.Picture;
import com.hmd.producer.EmployeeJsonProducer;
import com.hmd.producer.HumanResourceProducer;
import com.hmd.producer.PictureProducer;

@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {

//	@Autowired
//	private HelloRabbitProducer helloRabbitProducer;

//	@Autowired
//	private EmployeeJsonProducer employeeJsonProducer;

	/*
	 * @Autowired private PictureProducer pictureProducer;
	 * 
	 * private final List<String> SOURCES = List.of("mobile", "web");
	 * 
	 * private final List<String> TYPES = List.of("jpg", "png", "svg");
	 */

	@Autowired
	private HumanResourceProducer employeeJsonProducer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// helloRabbitProducer.sendHello("Mitt\t"+Instant.now());

		for (int i = 0; i < 5; i++) {
			var employee = new Employee("employee " + i, "Employee: " + i, LocalDate.now());
			employeeJsonProducer.sendMessage(employee);
		}

		/*
		 * for (int i = 0; i < 10; i++) { var picture = new Picture();
		 * picture.setName("Picture: " + i);
		 * picture.setSize(ThreadLocalRandom.current().nextLong(1, 10001));
		 * picture.setSource(SOURCES.get(i % SOURCES.size()));
		 * picture.setType(TYPES.get(i % TYPES.size()));
		 * 
		 * pictureProducer.sendMessage(picture); }
		 */

	}

}
