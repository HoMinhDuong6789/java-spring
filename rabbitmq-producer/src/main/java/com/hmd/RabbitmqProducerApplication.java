package com.hmd;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.hmd.entity.Employee;
import com.hmd.producer.EmployeeJsonProducer;

@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner{

//	@Autowired
//	private HelloRabbitProducer helloRabbitProducer;
	
	@Autowired
	private EmployeeJsonProducer employeeJsonProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//helloRabbitProducer.sendHello("Mitt\t"+Instant.now());
		for(int i=0; i<5; i++) {
			var employee = new Employee("employee "+i, "Employee: "+i, LocalDate.now());
			employeeJsonProducer.sendMessage(employee);
		}
	}

}
