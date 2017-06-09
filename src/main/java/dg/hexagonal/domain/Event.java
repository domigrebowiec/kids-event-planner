package dg.hexagonal.domain;

import org.joda.time.DateTime;

public class Event {

	protected String name;
	protected DateTime date;	
	protected EventType type;
	protected EventPlace place;
	
}
