package dg.hexagonal.domain.logic;

import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;
import dg.hexagonal.domain.ports.required.FamilyNotifier;
import dg.hexagonal.domain.ports.required.FamilyRepository;

public class FamilyService {

	private FamilyRepository repository;
	private FamilyNotifier notifier;
	
	public FamilyService(FamilyRepository repository, FamilyNotifier notifier) {
		super();
		this.repository = repository;
		this.notifier = notifier;
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
		mother.setFamily(family);
		father.setFamily(family);
		for (FamilyMember kid : kids) {
			kid.setFamily(family);
		}
		
		repository.addFamily(family);
		notifier.notifyNewFamily(family);
	}
	
	/**
	 * Kid will be added to family with given familyId. Family will be updated in repository. 
	 * Appropriate notification will be sent to email address.
	 * @param familyId
	 * @param kid
	 */
	public void addKidToFamily(Long familyId, FamilyMember kid) {
		
		Family family = repository.getFamilyById(familyId);
		kid.setFamily(family);
		family.getKids().add(kid);
		repository.updateFamily(family);
		notifier.notifyAddNewKid(family, kid);
	}
	
	/**
	 * Update family with given values. If value is null then existing value stay the same. If new value is present then existing
	 * value is changed with new value.
	 * Kids are updated if count of kids changed. It means that if size of existing list with kids is equal to new list with kids 
	 * then existing one will be used without update.
	 * @param familyId
	 * @param mother
	 * @param father
	 * @param emailAddress
	 * @param kids
	 */
	public void updateFamily(Long familyId, FamilyMember mother, FamilyMember father, String emailAddress, FamilyMember... kids) {
		
		Family oldFamily = repository.getFamilyById(familyId);
				
		FamilyMember uMother = (mother == null) ? oldFamily.getMother() : mother;
		FamilyMember uFather = (father == null) ? oldFamily.getFather() : father;
		String uEmail = (emailAddress == null) ? oldFamily.getEmailAddress() : emailAddress;
		
		int oldKidsSize = oldFamily.getKids().size();
		FamilyMember[] uKids;
		if (kids != null) {
			uKids = (oldKidsSize == kids.length) ? oldFamily.getKids().toArray(new FamilyMember[oldKidsSize]) : kids;
		} else {
			uKids = oldFamily.getKids().toArray(new FamilyMember[oldKidsSize]);
		}		
				
		Family updatedFamily = new Family(uMother, uFather, uEmail, uKids);
		uMother.setFamily(updatedFamily);
		uFather.setFamily(updatedFamily);
		for (FamilyMember kid : uKids) {
			kid.setFamily(updatedFamily);
		}		
		updatedFamily.setFamilyId(familyId);
		
		repository.updateFamily(updatedFamily);
		notifier.notifyFamilyChanged(oldFamily, updatedFamily);
	}
}