package dg.hexagonal.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Event implements Serializable {

	private static final long serialVersionUID = -5612869853483128693L;
	
	private Long eventId;
	private String name;
	private Long date;	
	private EventType type;
	private EventPlace place;
	private boolean aborted;
	
	public Event() {}
	
	public Event(String name, DateTime date, EventType type, EventPlace place) {
		super();
		this.name = name;
		this.date = date.getMillis();
		this.type = type;
		this.place = place;
		this.aborted = false;
	}
	
	public void setEventId(Long eventId) {
		if (this.eventId != null) { // do not assign eventId if already assigned
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

	public Long getDate() {
		return date;
	}

	public EventType getType() {
		return type;
	}

	public EventPlace getPlace() {
		return place;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public void setPlace(EventPlace place) {
		this.place = place;
	}

	public boolean isAborted() {
		return aborted;
	}

	public void setAborted(boolean aborted) {
		this.aborted = aborted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (aborted ? 1231 : 1237);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (aborted != other.aborted)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", date=" + date + ", type=" + type + ", place=" + place + "]";
	}
	
}
