package guru.springframework.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("France")
public class HelloWorldServiceFranceImpl implements HelloWorldService {
	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Say Hello!!!!!!!@@@@From France with love@@@@@@@@##########$$$$$$$$$$$$$$$$$";
	}
}
