package guru.springframework.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("English")
public class HelloWorldServiceEnglishImpl implements HelloWorldService {
	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Say Hello with English";
	}
}
