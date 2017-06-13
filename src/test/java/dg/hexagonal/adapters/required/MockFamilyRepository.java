package dg.hexagonal.adapters.required;

import java.util.HashMap;
import java.util.Map;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;
import dg.hexagonal.domain.ports.required.FamilyRepository;

public class MockFamilyRepository implements FamilyRepository {
	
	private Map<Long, Family> familyMap;
	
	public MockFamilyRepository() {
		familyMap = new HashMap<Long, Family>();
	}
	
	public void addFamily(Family family) {
		Long id = (long) (familyMap.size() + 1);
		
		family.setFamilyId(id);
		familyMap.put(id, family);
	}

	public Family addKidToFamily(Long familyId, FamilyMember kid) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateFamily(Family family) {
		familyMap.put(family.getFamilyId(), family);		
	}
	
	public Family updateFamily(Long familyId, FamilyMember mother, FamilyMember father, String emailAddress,
			FamilyMember... kids) {
		// TODO Auto-generated method stub
		return null;
	}

	public Family getFamilyById(Long familyId) {
		return familyMap.get(familyId);
	}

	public Event familyGoOnEvent(Long eventId, Long familyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event familyIsInterestedInEvent(Long eventId, Long familyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event familyResignFromEvent(Long eventId, Long familyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
