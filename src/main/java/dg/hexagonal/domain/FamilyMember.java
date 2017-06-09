package dg.hexagonal.domain;

import org.joda.time.DateTime;

public class FamilyMember {

	protected String firstName;
	protected String lastName;
	protected Family family;
	protected DateTime dateOfBirth;
	protected enum sex {FEMALE, MALE};
	
}
