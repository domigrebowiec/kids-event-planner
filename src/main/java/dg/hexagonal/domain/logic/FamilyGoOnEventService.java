package dg.hexagonal.domain.logic;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.ports.required.EmailNotifier;
import dg.hexagonal.domain.ports.required.Repository;

public class FamilyGoOnEventService {

	private Repository repository;
	private EmailNotifier emailNotifier;
	
	public FamilyGoOnEventService(Repository repository, EmailNotifier emailNotifier) {
		super();
		this.repository = repository;
		this.emailNotifier = emailNotifier;
	}

	/**
	 * Family will be added to a list of participant in event with given eventId.
	 * Email notification will be sent to family that is going to event.
	 * @param eventId
	 * @param familyId
	 */
	public void familyGoOnEvent(int eventId, int familyId) {
		
		Family family = repository.getFamilyById(familyId);
		Event event = repository.familyGoOnEvent(eventId, familyId);
		emailNotifier.notifyFamilyGoOnEvent(event, family);
	}
	
	/** 
	 * Family will be added to list of interested in event with given eventId.
	 * Email notification will be sent to family that is going to event.
	 * @param eventId
	 * @param familyId
	 */
	public void familyIsInterestedInEvent(int eventId, int familyId) {
		
		Family family = repository.getFamilyById(familyId);
		Event event = repository.familyIsInterestedInEvent(eventId, familyId);
		emailNotifier.notifyFamilyIsInterestedInEvent(event, family);
	}
	
	/**
	 * Family resign from event with given eventId. Family can be on "go" or "interested" families.
	 * Email notification will be sent to family about resignation.
	 * @param eventId
	 * @param familyId
	 */
	public void familyResignFromEvent(int eventId, int familyId) {
		
		Family family = repository.getFamilyById(familyId);
		Event event = repository.familyResignFromEvent(eventId, familyId);
		emailNotifier.notifyFamilyResignFromEvent(event, family);
	}
}
