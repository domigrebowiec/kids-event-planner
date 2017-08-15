package dg.hexagonal.domain.logic;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.EventParticipants;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.ports.required.EventRepository;
import dg.hexagonal.domain.ports.required.FamilyGoOnEventRepository;
import dg.hexagonal.domain.ports.required.FamilyNotifier;
import dg.hexagonal.domain.ports.required.FamilyRepository;

public class FamilyGoOnEventService {

	private EventRepository eventRepository;
	private FamilyRepository familyRepository;
	private FamilyGoOnEventRepository repository;
	private FamilyNotifier notifier;
	
	public FamilyGoOnEventService(EventRepository eventRepository, FamilyRepository familyRepository, 
			FamilyGoOnEventRepository repository, FamilyNotifier notifier) {
		super();
		this.eventRepository = eventRepository;
		this.familyRepository = familyRepository;
		this.repository = repository;
		this.notifier = notifier;
	}

	/**
	 * Family will be added to a list of participant in event with given eventId.
	 * Email notification will be sent to family that is going to event.
	 * @param eventId
	 * @param familyId
	 */
	@Transactional
	public void familyGoOnEvent(Long eventId, Long familyId) {
		// TODO eventRepository and familyRepository only needed for notifications - think if it is needed
		repository.familyGoOnEvent(eventId, familyId);
		
		Event event = eventRepository.getEventById(eventId);
		Family family = familyRepository.getFamilyById(familyId);
		notifier.notifyFamilyGoOnEvent(event, family);
	}
	
	/** 
	 * Family will be added to list of interested in event with given eventId.
	 * Email notification will be sent to family that is going to event.
	 * @param eventId
	 * @param familyId
	 */
	public void familyIsInterestedInEvent(Long eventId, Long familyId) {
		
		repository.familyIsInterestedInEvent(eventId, familyId);
		
		Event event = eventRepository.getEventById(eventId);
		Family family = familyRepository.getFamilyById(familyId);
		notifier.notifyFamilyIsInterestedInEvent(event, family);
	}
	
	/**
	 * Family resign from event with given eventId. Family can be on "go" or "interested" families.
	 * Email notification will be sent to family about resignation.
	 * @param eventId
	 * @param familyId
	 */
	public void familyResignFromEvent(Long eventId, Long familyId) {
		
		repository.familyResignFromEvent(eventId, familyId);
		
		Event event = eventRepository.getEventById(eventId);
		Family family = familyRepository.getFamilyById(familyId);
		notifier.notifyFamilyResignFromEvent(event, family);
	}
	
	@Transactional
	public EventParticipants getFamiliesGoOn(Long eventId) {
		
		List<Long> familiesId = repository.getFamiliesGoOnEvent(eventId);
		EventParticipants eventParticipants = new EventParticipants(eventId);
		for (Long id : familiesId) {
			eventParticipants.familyGo(id);
		}
		
		return eventParticipants;
	}
}
