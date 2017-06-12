package dg.hexagonal.domain;

import org.joda.time.DateTime;

public class Event {

	private Long eventId;
	private String name;
	private DateTime date;	
	private EventType type;
	private EventPlace place;
	private boolean aborted;
	
	public Event(String name, DateTime date, EventType type, EventPlace place) {
		super();
		this.name = name;
		this.date = date;
		this.type = type;
		this.place = place;
		this.aborted = false;
	}
	
	public void setEventId(Long eventId) {
		if (eventId != null) { // do not assign eventId if already assigned
			return;	
		}		
		this.eventId = eventId;
	}
	
	public Long getEventId() {
		return eventId;
	}

	public String getName() {
		return name;
	}

	public DateTime getDate() {
		return date;
	}

	public EventType getType() {
		return type;
	}

	public EventPlace getPlace() {
		return place;
	}

	public boolean isAborted() {
		return aborted;
	}

	public void setAborted(boolean aborted) {
		this.aborted = aborted;
	}
	
}
