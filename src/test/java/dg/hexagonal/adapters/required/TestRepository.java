package dg.hexagonal.adapters.required;

import java.util.HashMap;
import java.util.Map;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;
import dg.hexagonal.domain.ports.required.Repository;

public class TestRepository implements Repository {

	private Map<Long, Event> eventMap;
		
	public TestRepository() {
		eventMap = new HashMap<Long, Event>();
	}

	public void addEvent(Event event) {
		Long id = (long) (eventMap.size() + 1);
		
		event.setEventId(id);
		eventMap.put(id, event);
	}

	public Event updateEventById(Long eventId, Event event) {
		return eventMap.put(eventId, event);
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

	public void addFamily(Family family) {
		// TODO Auto-generated method stub

	}

	public Family addKidToFamily(int familyId, FamilyMember kid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Family updateFamily(int familyId, FamilyMember mother, FamilyMember father, String emailAddress,
			FamilyMember... kids) {
		// TODO Auto-generated method stub
		return null;
	}

	public Family getFamilyById(int familyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event familyGoOnEvent(Long eventId, int familyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event familyIsInterestedInEvent(Long eventId, int familyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event familyResignFromEvent(Long eventId, int familyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
