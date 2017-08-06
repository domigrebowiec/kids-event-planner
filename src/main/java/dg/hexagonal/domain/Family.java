package dg.hexagonal.domain;

import java.util.ArrayList;
import java.util.List;

public class Family {

	private Long familyId;
	private FamilyMember mother;
	private FamilyMember father;
	private List<FamilyMember> kids;
	private String emailAddress;

	public Family() {
	}

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

	public void setFamilyId(Long familyId) {
		if (this.familyId != null) { // do not assign familyId if already
										// assigned
			return;
		}
		this.familyId = familyId;
	}

	public FamilyMember getMother() {
		return mother;
	}

	public void setMother(FamilyMember mother) {
		this.mother = mother;
	}

	public FamilyMember getFather() {
		return father;
	}

	public void setFather(FamilyMember father) {
		this.father = father;
	}

	public List<FamilyMember> getKids() {
		return kids;
	}

	public void setKids(List<FamilyMember> kids) {
		this.kids = kids;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Long getFamilyId() {
		return familyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((familyId == null) ? 0 : familyId.hashCode());
		result = prime * result + ((father == null) ? 0 : father.hashCode());
		result = prime * result + ((kids == null) ? 0 : kids.hashCode());
		result = prime * result + ((mother == null) ? 0 : mother.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Family other = (Family) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (familyId == null) {
			if (other.familyId != null)
				return false;
		} else if (!familyId.equals(other.familyId))
			return false;
		if (father == null) {
			if (other.father != null)
				return false;
		} else if (!father.equals(other.father))
			return false;
		if (kids == null) {
			if (other.kids != null)
				return false;
		} else if (!kids.equals(other.kids))
			return false;
		if (mother == null) {
			if (other.mother != null)
				return false;
		} else if (!mother.equals(other.mother))
			return false;
		return true;
	}

}
