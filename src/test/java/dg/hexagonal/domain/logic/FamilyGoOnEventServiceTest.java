package dg.hexagonal.domain.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dg.hexagonal.adapters.required.MockEventRepository;
import dg.hexagonal.adapters.required.MockFamilyGoOnEventRepository;
import dg.hexagonal.adapters.required.MockFamilyRepository;
import dg.hexagonal.adapters.required.MockNotificationType;
import dg.hexagonal.adapters.required.MockNotifier;
import dg.hexagonal.domain.ports.required.EventRepository;
import dg.hexagonal.domain.ports.required.FamilyGoOnEventRepository;
import dg.hexagonal.domain.ports.required.FamilyRepository;

public class FamilyGoOnEventServiceTest {

	private EventRepository eventRepository;
	private FamilyRepository familyRepository;
	private FamilyGoOnEventRepository repository;
	private FamilyGoOnEventService service;	
	private MockNotifier notifier;
	
	@Before
	public void setup() {
		eventRepository = new MockEventRepository();
		familyRepository = new MockFamilyRepository();
		repository = new MockFamilyGoOnEventRepository();
		notifier = new MockNotifier();
		service = new FamilyGoOnEventService(eventRepository, familyRepository, repository, notifier);
	}
	
	@Test
	public void shouldAddFamilyToEvent() {
		
		// given
		Long eventId = 4l;
		Long familyId = 22l;
		
		// when
		service.familyGoOnEvent(eventId, familyId);
		
		// then
		List<Long> familiesId = repository.getFamiliesGoOnEvent(eventId);
		assertEquals(1, familiesId.size());
		assertEquals((Long)22l, familiesId.get(0));
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.FAMILY_GO_ON_EVENT));
	}
	
	@Test
	public void shouldAddFamilyAsInterestedInEvent() {
		
		// given
		Long eventId = 4l;
		Long familyId = 34l;
		
		// when
		service.familyIsInterestedInEvent(eventId, familyId);
		
		// then
		List<Long> familiesId = repository.getFamiliesInterestedInEvent(eventId);
		assertEquals(1, familiesId.size());
		assertEquals((Long)34l, familiesId.get(0));
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.FAMILY_INTERESTED_IN_EVENT));
	}
	
	@Test
	public void shouldFamilyResignFromEventWhenGo() {
		
		// given
		Long eventId = 4l;
		Long familyId = 50l;
		
		service.familyGoOnEvent(eventId, familyId);
		notifier.clear();
		// check before test
		List<Long> familiesId = repository.getFamiliesGoOnEvent(eventId);
		assertEquals(1, familiesId.size());
		assertEquals((Long)50l, familiesId.get(0));
		
		// when
		service.familyResignFromEvent(eventId, familyId);
				
		// then
		assertEquals(0, repository.getFamiliesGoOnEvent(eventId).size());
				
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.FAMILY_RESIGN_FROM_EVENT));
	}
	
	@Test
	public void shouldFamilyResignFromEventWhenInterestedIn() {
		
		// given
		Long eventId = 4l;
		Long familyId = 51l;
		
		service.familyIsInterestedInEvent(eventId, familyId);
		notifier.clear();
		// check before test
		List<Long> familiesId = repository.getFamiliesInterestedInEvent(eventId);
		assertEquals(1, familiesId.size());
		assertEquals((Long)51l, familiesId.get(0));
		
		// when
		service.familyResignFromEvent(eventId, familyId);
				
		// then
		assertEquals(0, repository.getFamiliesInterestedInEvent(eventId).size());
				
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.FAMILY_RESIGN_FROM_EVENT));
	}
}
