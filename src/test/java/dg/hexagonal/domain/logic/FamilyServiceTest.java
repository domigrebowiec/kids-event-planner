package dg.hexagonal.domain.logic;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dg.hexagonal.adapters.required.MockFamilyRepository;
import dg.hexagonal.adapters.required.MockNotificationType;
import dg.hexagonal.adapters.required.MockNotifier;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;

public class FamilyServiceTest {

	private MockFamilyRepository repository;
	private MockNotifier notifier;
	private FamilyService service;
	
	@Before
	public void setup() {
		repository = new MockFamilyRepository();
		notifier = new MockNotifier();
		service = new FamilyService(repository, notifier);
	}
	
	@After
	public void teardown(){
		notifier.clear();
	}
	
	@Test
	public void shouldAddNewFamily() {
		
		// given		
		FamilyMember mother = new FamilyMember("Ela", "Kowalska", new DateTime());
		FamilyMember father = new FamilyMember("Jan", "Kowalski", new DateTime());
		String emailAddress = "address@hots.com";
		FamilyMember kids = new FamilyMember("Kasia", "Kowalska", new DateTime());
		
		// when
		service.createNewFamily(mother, father, emailAddress, kids);
		
		// then
		Family family = repository.getFamilyById(1l);
		assertNotNull(family);
		assertEquals("Ela", family.getMother().getFirstName());
		assertEquals("Jan", family.getFather().getFirstName());
		assertEquals("Kasia", family.getKids().get(0).getFirstName());
		assertEquals("address@hots.com", family.getEmailAddress());
		assertTrue(family.getMother().getFamily().equals(family));
		assertTrue(family.getFather().getFamily().equals(family));
		assertTrue(family.getKids().get(0).getFamily().equals(family));
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.FAMILY_ADDED));
	}
	
	@Test
	public void shouldAddKidToFamily() {
		
		// given		
		FamilyMember mother = new FamilyMember("Ela", "Kowalska", new DateTime());
		FamilyMember father = new FamilyMember("Jan", "Kowalski", new DateTime());
		String emailAddress = "address@hots.com";
		FamilyMember kids = new FamilyMember("Kasia", "Kowalska", new DateTime());
		
		service.createNewFamily(mother, father, emailAddress, kids);
		notifier.clear();
		
		// when
		service.addKidToFamily(1l, new FamilyMember("Mirek", "Kowalski", new DateTime()));
		
		// then
		Family family = repository.getFamilyById(1l);
		assertNotNull(family);
		assertEquals(2, family.getKids().size());
		assertEquals("Kasia", family.getKids().get(0).getFirstName());
		assertEquals("Mirek", family.getKids().get(1).getFirstName());
		assertTrue(family.getKids().get(1).getFamily().equals(family));
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.KID_ADDED));
	}
	
	@Test
	public void shouldNotUpdateFamilyWhenOnlyNullGiven() {
		
		// given
		FamilyMember mother = new FamilyMember("Ela", "Kowalska", new DateTime());
		FamilyMember father = new FamilyMember("Jan", "Kowalski", new DateTime());
		String emailAddress = "address@hots.com";
		FamilyMember kid = new FamilyMember("Kasia", "Kowalska", new DateTime());
		
		service.createNewFamily(mother, father, emailAddress, kid);
		notifier.clear();
				
		// when
		service.updateFamily(1l, null, null, null, kid);
		
		// then
		Family family = repository.getFamilyById(1l);
		assertNotNull(family);
		assertEquals("Ela", family.getMother().getFirstName());
		assertEquals("Jan", family.getFather().getFirstName());
		assertEquals("Kasia", family.getKids().get(0).getFirstName());
		assertEquals("address@hots.com", family.getEmailAddress());
		assertTrue(family.getMother().getFamily().equals(family));
		assertTrue(family.getFather().getFamily().equals(family));
		assertTrue(family.getKids().get(0).getFamily().equals(family));
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.FAMILY_UPDATED));
	}
	
	@Test
	public void shouldUpdateFamilyWhenNotNullValuesGiven() {
		
		// given
		FamilyMember mother = new FamilyMember("Ela", "Kowalska", new DateTime());
		FamilyMember father = new FamilyMember("Jan", "Kowalski", new DateTime());
		String emailAddress = "address@hots.com";
		FamilyMember kid = new FamilyMember("Kasia", "Kowalska", new DateTime());
		
		service.createNewFamily(mother, father, emailAddress, kid);
		notifier.clear();
				
		FamilyMember nMother = new FamilyMember("Elzbieta", "Kowalska", new DateTime());
		FamilyMember nFather = new FamilyMember("Janusz", "Kowalski", new DateTime());
		String nEmailAddress = "other@test.com";
		FamilyMember kid2 = new FamilyMember("Zosia", "Kowalska", new DateTime());
		
		// when
		service.updateFamily(1l, nMother, nFather, nEmailAddress, kid, kid2);
		
		// then
		Family family = repository.getFamilyById(1l);
		assertNotNull(family);
		assertEquals("Elzbieta", family.getMother().getFirstName());
		assertEquals("Janusz", family.getFather().getFirstName());
		assertEquals(2, family.getKids().size());
		assertEquals("Kasia", family.getKids().get(0).getFirstName());
		assertEquals("Zosia", family.getKids().get(1).getFirstName());
		assertEquals("other@test.com", family.getEmailAddress());
		assertTrue(family.getMother().getFamily().equals(family));
		assertTrue(family.getFather().getFamily().equals(family));
		assertTrue(family.getKids().get(0).getFamily().equals(family));
		assertTrue(family.getKids().get(1).getFamily().equals(family));
		
		assertTrue(notifier.containsOnlyNotification(MockNotificationType.FAMILY_UPDATED));
	}
}
