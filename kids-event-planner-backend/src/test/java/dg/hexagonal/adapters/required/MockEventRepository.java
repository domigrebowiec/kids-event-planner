package dg.hexagonal.adapters.required;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.EventPlace;
import dg.hexagonal.domain.EventType;
import dg.hexagonal.domain.ports.required.EventRepository;

public class MockEventRepository implements EventRepository {

	private Map<Long, Event> eventMap;
		
	public MockEventRepository() {
		eventMap = new HashMap<Long, Event>();
	}

	public Event addEvent(Event event) {
		Long id = (long) (eventMap.size() + 1);
		
		event.setEventId(id);
		eventMap.put(id, event);
		
		return event;
	}

	public Event updateEvent(Event event) {
		eventMap.remove(event.getEventId());
		eventMap.put(event.getEventId(), event);
		
		return null;
	}

	public Event getEventById(Long eventId) {
		return eventMap.get(eventId);
	}
	
	public Event deleteEvent(Long eventId) {
		return eventMap.remove(eventId);
	}

	@Override
	public Event getEventBy(String name, DateTime date, EventType type, EventPlace place) {
		for (Event event : eventMap.values()) {
			if (event.getName().equals(name)){
				return event;
			}
		}
		return null;
	}

	@Override
	public EventPlace getEventPlaceBy(EventPlace place) {
		for (Event event : eventMap.values()) {
			if (event.getPlace().getName().equals(place.getName())){
				return event.getPlace();
			}
		}
		return null;
	}

}
