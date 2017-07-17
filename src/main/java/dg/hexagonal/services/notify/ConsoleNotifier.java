package dg.hexagonal.services.notify;

import dg.hexagonal.domain.Event;
import dg.hexagonal.domain.ports.required.Notifier;

public class ConsoleNotifier implements Notifier {

	@Override
	public void notifyNewEventCreated(Event event) {
		System.out.println("New event added " + event);
	}

	@Override
	public void notifyEventUpdated(Event oldEvent, Event updatedEvent) {
		System.out.println("Event updated " + oldEvent + " to " + updatedEvent);
	}

	@Override
	public void notifyEventAborted(Event event) {
		System.out.println("Event aborted " + event);
	}

	@Override
	public void notifyEventDeleted(Event event) {
		System.out.println("Event deleted " + event);
	}

}
