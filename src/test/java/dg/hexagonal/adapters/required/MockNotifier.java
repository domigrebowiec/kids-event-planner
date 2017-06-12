package dg.hexagonal.adapters.required;

import java.util.ArrayList;
import java.util.List;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.ports.required.Notifier;

public class MockNotifier implements Notifier {
	
	private List<NotificationType> notifications;
	
	public MockNotifier() {
		notifications = new ArrayList<NotificationType>();
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
	public boolean containsOnlyNotification(NotificationType notifType) {
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
		notifications.add(NotificationType.EVENT_ADDED);
	}

	public void notifyEventUpdated(Event oldEvent, Event updatedEvent) {
		System.out.println("[TEST] Event updated.");
		notifications.add(NotificationType.EVENT_UPDATED);
	}

	public void notifyEventAborted(Event event) {
		System.out.println("[TEST] Event aborted.");
		notifications.add(NotificationType.EVENT_ABORTED);
	}

	public void notifyEventDeleted(Event event) {
		System.out.println("[TEST] Event deleted.");
		notifications.add(NotificationType.EVENT_DELETED);
	}

}
