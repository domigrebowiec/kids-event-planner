package dg.hexagonal.domain;

import java.util.List;

public class EventParticipants {

	private Event event;
	private List<Family> familiesGo;
	private List<Family> familiesInterested;
	
	public Event getEvent() {
		return event;
	}
	public List<Family> getFamiliesGo() {
		return familiesGo;
	}
	public List<Family> getFamiliesInterested() {
		return familiesInterested;
	}
	
}
