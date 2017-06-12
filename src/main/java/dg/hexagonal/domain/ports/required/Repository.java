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

	public Event updateEventById(Long eventId, String name, DateTime date, EventType type, EventPlace place);

	public Event getEventById(Long eventId);
	
	public Event getEventByName(String string);

	public Event abortEvent(Long eventId);

	public Event deleteEvent(Long eventId);

	/* Family */
	
	public void addFamily(Family family);

	public Family addKidToFamily(int familyId, FamilyMember kid);

	public Family updateFamily(int familyId, FamilyMember mother, FamilyMember father, String emailAddress,
			FamilyMember... kids);

	public Family getFamilyById(int familyId);

	/* FamilyParticipant */
	
	public Event familyGoOnEvent(Long eventId, int familyId);

	public Event familyIsInterestedInEvent(Long eventId, int familyId);

	public Event familyResignFromEvent(Long eventId, int familyId);

	
}
