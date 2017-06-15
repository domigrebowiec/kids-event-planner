package dg.hexagonal.domain.ports.required;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;

public interface FamilyRepository {

	public void addFamily(Family family);

	public void updateFamily(Family family);

	public Family getFamilyById(Long familyId);
	
	
	///
	public Event familyGoOnEvent(Long eventId, Long familyId);

	public Event familyIsInterestedInEvent(Long eventId, Long familyId);

	public Event familyResignFromEvent(Long eventId, Long familyId);
}
