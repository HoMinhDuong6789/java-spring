package springboots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import guru.springframework.controllers.GrettingController;

@SpringBootApplication

//@ComponentScan("guru.springframework")
@ImportResource("classpath:/spring/spring-config.xml")
public class DiexampleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiexampleApplication.class, args);
		GrettingController controller = (GrettingController) ctx.getBean("grettingController");
		controller.sayHello();
	}
}
