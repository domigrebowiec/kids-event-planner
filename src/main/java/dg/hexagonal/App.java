package dg.hexagonal;

import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dg.hexagonal.domain.EventPlace;
import dg.hexagonal.domain.EventType;
import dg.hexagonal.domain.logic.EventService;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		@SuppressWarnings("resource")
		EventService eventService = (EventService) new ClassPathXmlApplicationContext("spring.xml").getBean("eventService");
				
		EventPlace monkeyTown = new EventPlace(10, 20, "Monkey Town");
		EventPlace ballorig = new EventPlace(3456, 11111, "Ballorig");	
		eventService.createEvent("7th Ola's birthday", new DateTime(2019, 1, 5, 10, 30), EventType.FAMILY, monkeyTown);
		eventService.createEvent("5th Wojtek's birthday", new DateTime(2019, 1, 15, 12, 30), EventType.FAMILY, ballorig);
				
	}
}
