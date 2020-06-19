package guru.springframework.services;

public class HelloWorldFactory {

	public HelloWorldService createHelloWorldService(String language) {
		HelloWorldService service = null;

		switch (language) {
		case "en":
			service = new HelloWorldServiceEnglishImpl();
			break;
		case "sp":
			service = new HelloWorldServiceSpanishImpl();
			break;
		case "fr":
			service = new HelloWorldServiceFranceImpl();
			break;
		case "ru":
			service = new HelloWorldServiceRussianImpl();
			break;
		default:
			service = new HelloWorldServiceEnglishImpl();
		}
		return service;
	}

}
