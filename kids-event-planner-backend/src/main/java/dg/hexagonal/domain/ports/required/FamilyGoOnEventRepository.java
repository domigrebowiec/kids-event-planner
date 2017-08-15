package dg.hexagonal.domain.ports.required;

import java.util.List;

public interface FamilyGoOnEventRepository {
	
	public void familyGoOnEvent(Long eventId, Long familyId);

	public void familyIsInterestedInEvent(Long eventId, Long familyId);

	public void familyResignFromEvent(Long eventId, Long familyId);

	public List<Long> getFamiliesGoOnEvent(Long eventId);
	
	public List<Long> getFamiliesInterestedInEvent(Long eventId);
}
