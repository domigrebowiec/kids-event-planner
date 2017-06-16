package dg.hexagonal.adapters.required;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dg.hexagonal.domain.EventParticipants;
import dg.hexagonal.domain.ports.required.FamilyGoOnEventRepository;

public class MockFamilyGoOnEventRepository implements FamilyGoOnEventRepository {

	private Map<Long, EventParticipants> eventParticipants;
	
	public MockFamilyGoOnEventRepository() {
		eventParticipants = new HashMap<Long, EventParticipants>();
	}
	
	public void familyGoOnEvent(Long eventId, Long familyId) {
		if (!eventParticipants.containsKey(eventId)) {
			EventParticipants participants = new EventParticipants(eventId);
			eventParticipants.put(eventId, participants);
		}
		eventParticipants.get(eventId).familyGo(familyId);
	}

	public void familyIsInterestedInEvent(Long eventId, Long familyId) {
		if (!eventParticipants.containsKey(eventId)) {
			EventParticipants participants = new EventParticipants(eventId);
			eventParticipants.put(eventId, participants);
		}
		eventParticipants.get(eventId).familyInterestedIn(familyId);
	}

	public void familyResignFromEvent(Long eventId, Long familyId) {
		// TODO Auto-generated method stub
		
	}

	public List<Long> getFamiliesGoOnEvent(Long eventId) {
		return eventParticipants.get(eventId).getFamiliesGo();
	}

	public List<Long> getFamiliesInterestedInEvent(Long eventId) {
		return eventParticipants.get(eventId).getFamiliesInterested();
	}

}
