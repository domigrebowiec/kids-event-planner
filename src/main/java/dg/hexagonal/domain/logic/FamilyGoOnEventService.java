package dg.hexagonal.domain.logic;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.ports.required.FamilyNotifier;
import dg.hexagonal.domain.ports.required.FamilyRepository;

public class FamilyGoOnEventService {

	private FamilyRepository repository;
	private FamilyNotifier notifier;
	
	public FamilyGoOnEventService(FamilyRepository repository, FamilyNotifier notifier) {
		super();
		this.repository = repository;
		this.notifier = notifier;
	}

	/**
	 * Family will be added to a list of participant in event with given eventId.
	 * Email notification will be sent to family that is going to event.
	 * @param eventId
	 * @param familyId
	 */
	public void familyGoOnEvent(Long eventId, int familyId) {
		
		Family family = repository.getFamilyById(familyId);
		Event event = repository.familyGoOnEvent(eventId, familyId);
		notifier.notifyFamilyGoOnEvent(event, family);
	}
	
	/** 
	 * Family will be added to list of interested in event with given eventId.
	 * Email notification will be sent to family that is going to event.
	 * @param eventId
	 * @param familyId
	 */
	public void familyIsInterestedInEvent(Long eventId, int familyId) {
		
		Family family = repository.getFamilyById(familyId);
		Event event = repository.familyIsInterestedInEvent(eventId, familyId);
		notifier.notifyFamilyIsInterestedInEvent(event, family);
	}
	
	/**
	 * Family resign from event with given eventId. Family can be on "go" or "interested" families.
	 * Email notification will be sent to family about resignation.
	 * @param eventId
	 * @param familyId
	 */
	public void familyResignFromEvent(Long eventId, int familyId) {
		
		Family family = repository.getFamilyById(familyId);
		Event event = repository.familyResignFromEvent(eventId, familyId);
		notifier.notifyFamilyResignFromEvent(event, family);
	}
}
