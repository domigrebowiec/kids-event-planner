package dg.hexagonal.services.notify;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;
import dg.hexagonal.domain.ports.required.FamilyNotifier;

public class ConsoleFamilyNotifier implements FamilyNotifier {

	@Override
	public void notifyNewFamily(Family family) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyAddNewKid(Family family, FamilyMember kid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyFamilyChanged(Family oldFamily, Family updatedFamily) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyFamilyGoOnEvent(Event event, Family family) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyFamilyIsInterestedInEvent(Event event, Family family) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyFamilyResignFromEvent(Event event, Family family) {
		// TODO Auto-generated method stub
		
	}

}
