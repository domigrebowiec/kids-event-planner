package dg.hexagonal.domain;

import org.joda.time.DateTime;

public class FamilyMember {

	private String firstName;
	private String lastName;
	private Family family;
	private DateTime dateOfBirth;
	private enum sex {FEMALE, MALE};
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Family getFamily() {
		return family;
	}
	public DateTime getDateOfBirth() {
		return dateOfBirth;
	}
	
}
