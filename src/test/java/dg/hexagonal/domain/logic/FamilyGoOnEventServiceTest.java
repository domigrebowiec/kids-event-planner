package dg.hexagonal.domain.logic;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dg.hexagonal.adapters.required.MockEventRepository;
import dg.hexagonal.adapters.required.MockFamilyGoOnEventRepository;
import dg.hexagonal.adapters.required.MockFamilyRepository;
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
	}
}
