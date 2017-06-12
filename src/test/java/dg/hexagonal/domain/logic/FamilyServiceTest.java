package dg.hexagonal.domain.logic;

import org.junit.Before;
import org.junit.Test;

import dg.hexagonal.adapters.required.MockFamilyNotifier;
import dg.hexagonal.adapters.required.MockFamilyRepository;

public class FamilyServiceTest {

	private MockFamilyRepository repository;
	private MockFamilyNotifier notifier;
	private FamilyService service;
	
	@Before
	public void setup() {
		repository = new MockFamilyRepository();
		notifier = new MockFamilyNotifier();
		service = new FamilyService(repository, notifier);
	}
	
	@Test
	public void shouldAddNewFamily() {
		
		// given
		
		// when
		
		
		// then
	}
}
