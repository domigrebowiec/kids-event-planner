package dg.hexagonal.adapters.required;

import java.util.HashMap;
import java.util.Map;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.ports.required.EventRepository;

public class MockEventRepository implements EventRepository {

	private Map<Long, Event> eventMap;
		
	public MockEventRepository() {
		eventMap = new HashMap<Long, Event>();
	}

	public void addEvent(Event event) {
		Long id = (long) (eventMap.size() + 1);
		
		event.setEventId(id);
		eventMap.put(id, event);
	}

	public Event updateEvent(Event event) {
		eventMap.remove(event.getEventId());
		eventMap.put(event.getEventId(), event);
		
		return null;
	}

	public Event getEventById(Long eventId) {
		return eventMap.get(eventId);
	}

	public Event getEventByName(String name) {
		for (Event event : eventMap.values()) {
			if (event.getName().equals(name)){
				return event;
			}
		}
		return null;
	}

	public Event deleteEvent(Long eventId) {
		return eventMap.remove(eventId);
	}

}
