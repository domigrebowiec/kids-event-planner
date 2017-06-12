package dg.hexagonal.domain.logic;

import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;
import dg.hexagonal.domain.ports.required.EmailNotifier;
import dg.hexagonal.domain.ports.required.FamilyRepository;

public class FamilyService {

	private FamilyRepository repository;
	private EmailNotifier emailNotifier;
	
	public FamilyService(FamilyRepository repository, EmailNotifier emailNotifier) {
		super();
		this.repository = repository;
		this.emailNotifier = emailNotifier;
	}

	/**
	 * New family will be created in repository. Appropriate notification will be sent to email address.
	 * @param mother
	 * @param father
	 * @param emailAddress
	 * @param kids
	 */
	public void createNewFamily(FamilyMember mother, FamilyMember father, String emailAddress, FamilyMember... kids) {
		
		Family family = new Family(mother, father, emailAddress, kids);
		repository.addFamily(family);
		emailNotifier.notifyNewFamily(family);
	}
	
	/**
	 * Kid will be added to family with given familyId. Family will be updated in repository. 
	 * Appropriate notification will be sent to email address.
	 * @param familyId
	 * @param kid
	 */
	public void addKidToFamily(int familyId, FamilyMember kid) {
		
		Family family = repository.addKidToFamily(familyId, kid);
		emailNotifier.notifyAddNewKid(family, kid);
	}
	
	/**
	 * Update family with given values. If value is null then existing value stay the same. If new value is present then existing
	 * value is changed with new value.
	 * @param familyId
	 * @param mother
	 * @param father
	 * @param emailAddress
	 * @param kids
	 */
	public void updateFamily(int familyId, FamilyMember mother, FamilyMember father, String emailAddress, FamilyMember... kids) {
		
		Family oldFamily = repository.getFamilyById(familyId);
		Family updatedFamily = repository.updateFamily(familyId, mother, father, emailAddress, kids);
		emailNotifier.notifyFamilyChanged(oldFamily, updatedFamily);
	}
}