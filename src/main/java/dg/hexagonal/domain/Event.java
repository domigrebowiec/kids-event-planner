package dg.hexagonal.domain;

import org.joda.time.DateTime;

public class Event {

	protected int eventId;
	protected String name;
	protected DateTime date;	
	protected EventType type;
	protected EventPlace place;
	
	public Event(String name, DateTime date, EventType type, EventPlace place) {
		super();
		this.name = name;
		this.date = date;
		this.type = type;
		this.place = place;
	}
	
}
