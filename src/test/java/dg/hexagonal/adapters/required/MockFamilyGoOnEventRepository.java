package dg.hexagonal.adapters.required;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dg.hexagonal.domain.ports.required.FamilyGoOnEventRepository;

public class MockFamilyGoOnEventRepository implements FamilyGoOnEventRepository {

	private Map<Long, List<Long>> familiesOnEvent;
	
	public MockFamilyGoOnEventRepository() {
		familiesOnEvent = new HashMap<Long, List<Long>>();
	}
	
	public void familyGoOnEvent(Long eventId, Long familyId) {
		if (!familiesOnEvent.containsKey(eventId)) {
			familiesOnEvent.put(eventId, new ArrayList<Long>());
		}
		familiesOnEvent.get(eventId).add(familyId);
	}

	public void familyIsInterestedInEvent(Long eventId, Long familyId) {
		// TODO Auto-generated method stub
		
	}

	public void familyResignFromEvent(Long eventId, Long familyId) {
		// TODO Auto-generated method stub
		
	}

	public List<Long> getFamiliesGoOnEvent(Long eventId) {
		return familiesOnEvent.get(eventId);
	}

}
