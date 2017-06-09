package dg.hexagonal.domain;

import java.util.ArrayList;
import java.util.List;

public class Family {

	protected int familyId;
	protected FamilyMember mother;
	protected FamilyMember father;
	protected List<FamilyMember> kids;
	protected String emailAddress;
	
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
	
}
