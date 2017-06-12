package dg.hexagonal.domain.ports.required;

import dg.hexagonal.domain.Event;

public interface EventRepository {
	
	public void addEvent(Event event);

	public Event updateEventById(Long eventId, Event event);

	public Event getEventById(Long eventId);
	
	public Event getEventByName(String string);

	public Event deleteEvent(Long eventId);
}
