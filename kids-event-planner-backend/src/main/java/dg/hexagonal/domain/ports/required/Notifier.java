package dg.hexagonal.domain.ports.required;

import dg.hexagonal.domain.Event;

public interface Notifier {

	public void notifyNewEventCreated(Event event);

	public void notifyEventUpdated(Event oldEvent, Event updatedEvent);

	public void notifyEventAborted(Event event);

	public void notifyEventDeleted(Event event);

}
