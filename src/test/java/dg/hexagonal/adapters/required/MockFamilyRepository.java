package dg.hexagonal.adapters.required;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;
import dg.hexagonal.domain.ports.required.FamilyRepository;

public class MockFamilyRepository implements FamilyRepository {

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
