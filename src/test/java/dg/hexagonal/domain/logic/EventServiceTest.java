package dg.hexagonal.domain.logic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dg.hexagonal.adapters.required.MockNotificationType;
import dg.hexagonal.adapters.required.MockNotifier;
import dg.hexagonal.adapters.required.MockEventRepository;
import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.EventPlace;
import dg.hexagonal.domain.EventType;
import dg.hexagonal.domain.ports.required.EventRepository;

public class EventServiceTest {
	
	private EventRepository eventRepo;
	private MockNotifier notifier;
	private EventService eventService;
	
	@Before
	public void setup() {
		eventRepo = new MockEventRepository();
		notifier = new MockNotifier();
		eventService = new EventService(eventRepo, notifier);
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
		Event event = eventRepo.getEventByName("test event");
		assertNotNull(event);
		assertTrue(event.getPlace().equals(givenPlace));
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.EVENT_ADDED));
	}
	
	@Test
	public void shouldUpdateEvent() {
		
		// given
		EventPlace givenPlace = new EventPlace(1, 2, "place2");
		EventPlace newPlace = new EventPlace(100, 200, "place updated");
		DateTime date = new DateTime();
		eventService.createEvent("test event", date, EventType.FAMILY, givenPlace);
		notifier.clear();
		
		// when
		eventService.updateEvent(1l, "test event", null, EventType.MOVIE, newPlace);
		
		// then
		Event event = eventRepo.getEventByName("test event");
		assertNotNull(event);
		assertTrue(event.getDate().equals(date.getMillis()));
		assertTrue(event.getType().equals(EventType.MOVIE));
		assertTrue(event.getPlace().equals(newPlace));
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.EVENT_UPDATED));
	}
	
	@Test
	public void shouldNotUpdateEventWhenNullValues() {
		
		// given
		EventPlace givenPlace = new EventPlace(1, 2, "place2");
		DateTime date = new DateTime();
		eventService.createEvent("test event", date, EventType.FAMILY, givenPlace);
		notifier.clear();
		
		// when
		eventService.updateEvent(1l, null, null, null, null);
		
		// then
		Event event = eventRepo.getEventByName("test event");
		assertNotNull(event);
		assertTrue(event.getDate().equals(date.getMillis()));
		assertTrue(event.getType().equals(EventType.FAMILY));
		assertTrue(event.getPlace().equals(givenPlace));
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.EVENT_UPDATED));
	}
	
	@Test
	public void shouldUpdateEventWithAllNewValues() {
		
		// given
		EventPlace givenPlace = new EventPlace(1, 2, "place2");
		EventPlace newPlace = new EventPlace(100, 200, "place updated");
		DateTime date = new DateTime();
		eventService.createEvent("test event", date, EventType.FAMILY, givenPlace);
		notifier.clear();
		
		DateTime newDate = date.plusDays(2);
		
		
		// when
		eventService.updateEvent(1l, "new event name", newDate, EventType.INDOOR, newPlace);
		
		// then
		Event event = eventRepo.getEventById(1l);
		assertNotNull(event);
		assertTrue(event.getName().equals("new event name"));
		assertTrue(event.getDate().equals(newDate.getMillis()));
		assertTrue(event.getType().equals(EventType.INDOOR));
		assertTrue(event.getPlace().equals(newPlace));
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.EVENT_UPDATED));
	}
	
	@Test
	public void shouldAbortEvent() {
		
		// given
		EventPlace givenPlace = new EventPlace(1, 2, "place2");
		eventService.createEvent("test event", new DateTime(), EventType.FAMILY, givenPlace);
		notifier.clear();
		
		// when
		eventService.abortEvent(1l);
		
		// then
		Event event = eventRepo.getEventById(1l);
		assertNotNull(event);
		assertTrue(event.isAborted());
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.EVENT_ABORTED));
	}
	
	@Test
	public void shouldDeleteEvent() {
		
		// given
		EventPlace givenPlace = new EventPlace(1, 2, "place2");
		eventService.createEvent("test event", new DateTime(), EventType.FAMILY, givenPlace);
		notifier.clear();
		
		// when
		eventService.deleteEvent(1l);
		
		// then
		Event event = eventRepo.getEventById(1l);
		assertNull(event);
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.EVENT_DELETED));
	}
}
