package dg.hexagonal.domain.ports.required;

import org.joda.time.DateTime;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.EventPlace;
import dg.hexagonal.domain.EventType;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;

public interface Repository {

	/* Event */
	
	public void addEvent(Event event);

	public Event updateEventById(int eventId, String name, DateTime date, EventType type, EventPlace place);

	public Event getEventById(int eventId);

	public Event abortEvent(int eventId);

	public Event deleteEvent(int eventId);

	/* Family */
	
	public void addFamily(Family family);

	public Family addKidToFamily(int familyId, FamilyMember kid);

	public Family updateFamily(int familyId, FamilyMember mother, FamilyMember father, String emailAddress,
			FamilyMember... kids);

	public Family getFamilyById(int familyId);

	/* FamilyParticipant */
	
	public Event familyGoOnEvent(int eventId, int familyId);

	public Event familyIsInterestedInEvent(int eventId, int familyId);

	public Event familyResignFromEvent(int eventId, int familyId);
}
