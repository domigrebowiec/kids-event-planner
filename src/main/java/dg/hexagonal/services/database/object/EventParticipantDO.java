package dg.hexagonal.services.database.object;

public class EventParticipantDO {

	private Long id;
	private Long eventId;
	private Long familyId;
	private boolean onlyInterested;

	public EventParticipantDO() {
		super();
		onlyInterested = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public boolean isOnlyInterested() {
		return onlyInterested;
	}

	public void setOnlyInterested(boolean onlyInterested) {
		this.onlyInterested = onlyInterested;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((familyId == null) ? 0 : familyId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (onlyInterested ? 1231 : 1237);
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
		EventParticipantDO other = (EventParticipantDO) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (familyId == null) {
			if (other.familyId != null)
				return false;
		} else if (!familyId.equals(other.familyId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (onlyInterested != other.onlyInterested)
			return false;
		return true;
	}

}
