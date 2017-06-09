package dg.hexagonal.domain.ports.required;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;

public interface EmailNotifier {

	void notifyNewFamily(Family family);

	void notifyAddNewKid(Family family, FamilyMember kid);

	void notifyFamilyChanged(Family oldFamily, Family updatedFamily);

	void notifyFamilyGoOnEvent(Event event, Family family);

	void notifyFamilyIsInterestedInEvent(Event event, Family family);

	void notifyFamilyResignFromEvent(Event event, Family family);

}
