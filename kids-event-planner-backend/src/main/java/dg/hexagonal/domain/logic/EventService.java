package dg.hexagonal.domain.logic;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.EventPlace;
import dg.hexagonal.domain.EventType;
import dg.hexagonal.domain.ports.required.EventRepository;
import dg.hexagonal.domain.ports.required.Notifier;

public class EventService {

	private EventRepository repository;
	private Notifier notifier;
	
	public EventService(EventRepository eventRepo, Notifier notifier) {
		super();
		this.repository = eventRepo;
		this.notifier = notifier;
	}

	/** 
	 * New event will be created in repository. EventId will be given as incremental value.
	 * @param name
	 * @param date
	 * @param type
	 * @param place
	 * @return 
	 */
	@Transactional
	public Event createEvent(String name, DateTime date, EventType type, EventPlace place) {
		
		Event event = repository.getEventBy(name, date, type, place);
		// already found event - don't add it again
		if (event != null) {
			System.out.println("Event already found in DB. " + event);
			return event;
		}
		
		EventPlace placeFromDB = repository.getEventPlaceBy(place);
		if (placeFromDB != null) {
			place = placeFromDB;
			System.out.println("Place was already in DB. "  + place);
		}
		
		event = new Event(name, date, type, place);		
		event = repository.addEvent(event);
		notifier.notifyNewEventCreated(event);
		
		System.out.println("Event added to DB. " + event);
		
		return event;
	}
	
	/**
	 * Event with given eventId will be updated. All existing in repository values will be replaces with given values.
	 * If param is null then old value stay unchanged.
	 * @param eventId
	 * @param name
	 * @param date
	 * @param type
	 * @param place
	 */
	@Transactional
	public void updateEvent(Long eventId, String name, DateTime date, EventType type, EventPlace place) {
		
		Event oldEvent = repository.getEventById(eventId);
		
		String uName = (name == null) ? oldEvent.getName() : name;
		DateTime uDate = (date == null) ? new DateTime(oldEvent.getDate()) : date;
		EventType uType = (type == null) ? oldEvent.getType() : type;
		EventPlace uPlace = (place == null) ? oldEvent.getPlace() : place;
		Event updatedEvent = new Event(uName, uDate, uType, uPlace); 
		updatedEvent.setEventId(eventId);
		
		repository.updateEvent(updatedEvent);
		notifier.notifyEventUpdated(oldEvent, updatedEvent);
	}
	
	/** 
	 * Event with given eventId will be aborted. It will not be deleted from repository.
	 * @param eventId
	 */
	@Transactional
	public void abortEvent(Long eventId) {
		
		Event event = repository.getEventById(eventId);
		event.setAborted(true);
		repository.updateEvent(event);
		notifier.notifyEventAborted(event);
	}
	
	/** 
	 * Event with given eventId will be deleted from repository.
	 * @param eventId
	 */
	@Transactional
	public void deleteEvent(Long eventId) {
		
		Event event = repository.deleteEvent(eventId);
		notifier.notifyEventDeleted(event);
	}
}
