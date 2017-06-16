package dg.hexagonal.adapters.required;

import java.util.ArrayList;
import java.util.List;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.Family;
import dg.hexagonal.domain.FamilyMember;
import dg.hexagonal.domain.ports.required.FamilyNotifier;
import dg.hexagonal.domain.ports.required.Notifier;

public class MockNotifier implements Notifier, FamilyNotifier {
	
	private List<MockNotificationType> notifications;
	
	public MockNotifier() {
		notifications = new ArrayList<MockNotificationType>();
	}
	
	/** 
	 * Get notifications list size.
	 * @return
	 */
	public int size() {
		return notifications.size();
	}
	
	/**
	 * Check if notifications list contains only one notification with given type.
	 * @param notifType
	 * @return True when there is only one notification with given type. 
	 * False otherwise.
	 */
	public boolean containsOnlyNotification(MockNotificationType notifType) {
		return notifications.size() == 1 && notifications.get(0).equals(notifType);
	}
	
	/**
	 * Clear notifications list.
	 */
	public void clear() {
		notifications.clear();
	}
	
	public void notifyNewEventCreated(Event event) {
		System.out.println("[TEST] New event created.");
		notifications.add(MockNotificationType.EVENT_ADDED);
	}

	public void notifyEventUpdated(Event oldEvent, Event updatedEvent) {
		System.out.println("[TEST] Event updated.");
		notifications.add(MockNotificationType.EVENT_UPDATED);
	}

	public void notifyEventAborted(Event event) {
		System.out.println("[TEST] Event aborted.");
		notifications.add(MockNotificationType.EVENT_ABORTED);
	}

	public void notifyEventDeleted(Event event) {
		System.out.println("[TEST] Event deleted.");
		notifications.add(MockNotificationType.EVENT_DELETED);
	}

	public void notifyNewFamily(Family family) {
		System.out.println("[TEST] New family added.");
		notifications.add(MockNotificationType.FAMILY_ADDED);
	}

	public void notifyAddNewKid(Family family, FamilyMember kid) {
		System.out.println("[TEST] Kid added to family.");
		notifications.add(MockNotificationType.KID_ADDED);
	}

	public void notifyFamilyChanged(Family oldFamily, Family updatedFamily) {
		System.out.println("[TEST] Family changed.");
		notifications.add(MockNotificationType.FAMILY_UPDATED);
	}

	public void notifyFamilyGoOnEvent(Event event, Family family) {
		System.out.println("[TEST] Family go on event.");
		notifications.add(MockNotificationType.FAMILY_GO_ON_EVENT);
	}

	public void notifyFamilyIsInterestedInEvent(Event event, Family family) {
		System.out.println("[TEST] Family go on event.");
		notifications.add(MockNotificationType.FAMILY_INTERESTED_IN_EVENT);
	}

	public void notifyFamilyResignFromEvent(Event event, Family family) {
		// TODO Auto-generated method stub
		
	}

}
