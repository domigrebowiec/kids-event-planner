package dg.hexagonal.domain.logic;

import org.joda.time.DateTime;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.EventPlace;
import dg.hexagonal.domain.EventType;
import dg.hexagonal.domain.ports.required.Notifier;
import dg.hexagonal.domain.ports.required.Repository;

public class EventService {

	private Repository repository;
	private Notifier notifier;
	
	public EventService(Repository repository, Notifier notifier) {
		super();
		this.repository = repository;
		this.notifier = notifier;
	}

	/** 
	 * New event will be created in repository. EventId will be given as incremental value.
	 * @param name
	 * @param date
	 * @param type
	 * @param place
	 */
	public void createEvent(String name, DateTime date, EventType type, EventPlace place) {
		
		Event event = new Event(name, date, type, place);
		repository.addEvent(event);
		notifier.notifyNewEventCreated(event);
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
	public void updateEvent(int eventId, String name, DateTime date, EventType type, EventPlace place) {
		
		Event oldEvent = repository.getEventById(eventId);
		Event updatedEvent = repository.updateEventById(eventId, name, date, type, place);
		notifier.notifyEventUpdated(oldEvent, updatedEvent);
	}
	
	/** 
	 * Event with given eventId will be aborted. It will not be deleted from repository.
	 * @param eventId
	 */
	public void abortEvent(int eventId) {
		
		Event event = repository.abortEvent(eventId);
		notifier.notifyEventAborted(event);
	}
	
	/** 
	 * Event with given eventId will be deleted from repository.
	 * @param eventId
	 */
	public void deleteEvent(int eventId) {
		
		Event event = repository.deleteEvent(eventId);
		notifier.notifyEventDeleted(event);
	}
}
