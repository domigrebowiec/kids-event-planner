package dg.hexagonal;

import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dg.hexagonal.domain.EventPlace;
import dg.hexagonal.domain.EventType;
import dg.hexagonal.domain.FamilyMember;
import dg.hexagonal.domain.logic.EventService;
import dg.hexagonal.domain.logic.FamilyService;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		
		EventService eventService = (EventService) context.getBean("eventService");
				
		EventPlace monkeyTown = new EventPlace(10, 20, "Monkey Town");
		EventPlace ballorig = new EventPlace(3456, 11111, "Ballorig");	
		eventService.createEvent("7th Ola's birthday", new DateTime(2019, 1, 5, 10, 30), EventType.FAMILY, monkeyTown);
		eventService.createEvent("5th Wojtek's birthday", new DateTime(2019, 1, 15, 12, 30), EventType.FAMILY, ballorig);
				
		FamilyService familyService = (FamilyService) context.getBean("familyService");
		FamilyMember mother = new FamilyMember("Dominika", "Grebowiec", new DateTime(1986, 7, 1, 0, 0));
		FamilyMember father = new FamilyMember("Artur", "Grebowiec", new DateTime(1982, 10, 26, 0, 0));
		FamilyMember kidOla = new FamilyMember("Ola", "Grebowiec", new DateTime(2012, 1, 5, 0, 0));
		FamilyMember kidWojtek = new FamilyMember("Wojtek", "Grebowiec", new DateTime(2014, 1, 15, 0, 0));
		familyService.createNewFamily(mother, father, "dominika.grebowiec@gmail.com", kidOla, kidWojtek);
		
		FamilyMember mother2 = new FamilyMember("Paulina", "Kowalska", new DateTime(1990, 6, 16, 0, 0));
		FamilyMember father2 = new FamilyMember("Pawel", "Kowalski", new DateTime(1982, 12, 10, 0, 0));
		FamilyMember kid21 = new FamilyMember("Lena", "Kowalska", new DateTime(2011, 3, 30, 0, 0));
		FamilyMember kid22 = new FamilyMember("Bartek", "Kowalski", new DateTime(2017, 1, 25, 0, 0));
		familyService.createNewFamily(mother2, father2, "kowalscy@gmail.com", kid21, kid22);
	}
}
