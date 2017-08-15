package dg.hexagonal.domain.ports.required;

import org.joda.time.DateTime;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.EventPlace;
import dg.hexagonal.domain.EventType;

public interface EventRepository {
	
	public Event addEvent(Event event);

	public Event updateEvent(Event event);

	public Event getEventById(Long eventId);
	
	public Event getEventBy(String name, DateTime date, EventType type, EventPlace place);

	public Event deleteEvent(Long eventId);

	public EventPlace getEventPlaceBy(EventPlace place);	
}
