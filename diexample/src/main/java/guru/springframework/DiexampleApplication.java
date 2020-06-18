package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.controllers.GrettingController;

@SpringBootApplication
public class DiexampleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiexampleApplication.class, args);
		GrettingController controller = (GrettingController) ctx.getBean("grettingController");
		controller.sayHello();
	}
}
