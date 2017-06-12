package dg.hexagonal.adapters.required;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;
import dg.hexagonal.domain.ports.required.FamilyNotifier;

public class MockFamilyNotifier implements FamilyNotifier {

	public void notifyNewFamily(Family family) {
		// TODO Auto-generated method stub
		
	}

	public void notifyAddNewKid(Family family, FamilyMember kid) {
		// TODO Auto-generated method stub
		
	}

	public void notifyFamilyChanged(Family oldFamily, Family updatedFamily) {
		// TODO Auto-generated method stub
		
	}

	public void notifyFamilyGoOnEvent(Event event, Family family) {
		// TODO Auto-generated method stub
		
	}

	public void notifyFamilyIsInterestedInEvent(Event event, Family family) {
		// TODO Auto-generated method stub
		
	}

	public void notifyFamilyResignFromEvent(Event event, Family family) {
		// TODO Auto-generated method stub
		
	}

}
