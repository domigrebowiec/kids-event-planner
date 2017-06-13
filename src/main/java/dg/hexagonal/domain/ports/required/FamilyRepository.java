package dg.hexagonal.domain.ports.required;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;

public interface FamilyRepository {

	public void addFamily(Family family);

	public Family addKidToFamily(Long familyId, FamilyMember kid);

	public void updateFamily(Family family);

	public Family getFamilyById(Long familyId);
	
	
	///
	public Event familyGoOnEvent(Long eventId, Long familyId);

	public Event familyIsInterestedInEvent(Long eventId, Long familyId);

	public Event familyResignFromEvent(Long eventId, Long familyId);
}
