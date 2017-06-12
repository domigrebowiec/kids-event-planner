package dg.hexagonal.domain.logic;

import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dg.hexagonal.adapters.required.NotificationType;
import dg.hexagonal.adapters.required.StdioNotifier;
import dg.hexagonal.adapters.required.TestRepository;
import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.EventPlace;
import dg.hexagonal.domain.EventType;
import dg.hexagonal.domain.ports.required.Repository;

public class EventServiceTest {
	
	private Repository repository;
	private StdioNotifier notifier;
	private EventService eventService;
	
	@Before
	public void setup() {
		repository = new TestRepository();
		notifier = new StdioNotifier();
		eventService = new EventService(repository, notifier);
	}
	
	@After
	public void tearDown() {
		notifier.clear();
	}
	
	@Test
	public void shouldAddEventToRepository() {
		
		// given
		EventPlace givenPlace = new EventPlace(1, 2, "place1");
		
		// when
		eventService.createEvent("test event", new DateTime(), EventType.INDOOR, givenPlace);
		
		// then
		Event event = repository.getEventByName("test event");
		assertTrue(event.getPlace().equals(givenPlace));
		assertTrue(notifier.containsOnlyNotification(NotificationType.EVENT_ADDED));
	}
}
