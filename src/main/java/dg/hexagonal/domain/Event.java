package dg.hexagonal.domain;

import org.joda.time.DateTime;

public class Event {

	private int eventId;
	private String name;
	private DateTime date;	
	private EventType type;
	private EventPlace place;
	
	public Event(String name, DateTime date, EventType type, EventPlace place) {
		super();
		this.name = name;
		this.date = date;
		this.type = type;
		this.place = place;
	}

	public int getEventId() {
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
	
	
}
