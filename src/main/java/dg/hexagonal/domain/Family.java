package dg.hexagonal.domain;

import java.util.ArrayList;
import java.util.List;

public class Family {

	private int familyId;
	private FamilyMember mother;
	private FamilyMember father;
	private List<FamilyMember> kids;
	private String emailAddress;
	
	public Family(FamilyMember mother, FamilyMember father, String emailAddress, FamilyMember... kids) {
		super();
		this.mother = mother;
		this.father = father;
		this.emailAddress = emailAddress;
		
		this.kids = new ArrayList<FamilyMember>();
		for (FamilyMember kid : kids) {
			this.kids.add(kid);
		}		
	}

	public int getFamilyId() {
		return familyId;
	}

	public FamilyMember getMother() {
		return mother;
	}

	public FamilyMember getFather() {
		return father;
	}

	public List<FamilyMember> getKids() {
		return kids;
	}

	public String getEmailAddress() {
		return emailAddress;
	}	
	
}
