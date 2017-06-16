package dg.hexagonal.domain;

import java.util.ArrayList;
import java.util.List;

public class EventParticipants {

	private Long eventId;
	private List<Long> familiesGoId;
	private List<Long> familiesInterestedId;
	
	public EventParticipants(Long eventId) {
		this.eventId = eventId;
		this.familiesGoId = new ArrayList<Long>();
		this.familiesInterestedId = new ArrayList<Long>();
	}
	
	public Long getEvent() {
		return eventId;
	}
	public List<Long> getFamiliesGo() {
		return familiesGoId;
	}
	public List<Long> getFamiliesInterested() {
		return familiesInterestedId;
	}
	
	public void familyGo(Long familyId) {
		if (!familiesGoId.contains(familyId)) {
			familiesGoId.add(familyId);
		}
	}
	
	public void familyInterestedIn(Long familyId) {
		if (!familiesInterestedId.contains(familyId)) {
			familiesInterestedId.add(familyId);
		}
	}
}
