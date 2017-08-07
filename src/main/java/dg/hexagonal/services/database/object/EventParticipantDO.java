package dg.hexagonal.services.database.object;

public class EventParticipantDO {

	private Long id;
	private Long eventId;
	private Long familyIdGo;
	private Long familyIdInterested;

	public EventParticipantDO() {
		super();
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

	public Long getFamilyIdGo() {
		return familyIdGo;
	}

	public void setFamilyIdGo(Long familyIdGo) {
		this.familyIdGo = familyIdGo;
	}

	public Long getFamilyIdInterested() {
		return familyIdInterested;
	}

	public void setFamilyIdInterested(Long familyIdInterested) {
		this.familyIdInterested = familyIdInterested;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((familyIdGo == null) ? 0 : familyIdGo.hashCode());
		result = prime * result + ((familyIdInterested == null) ? 0 : familyIdInterested.hashCode());
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
		if (familyIdGo == null) {
			if (other.familyIdGo != null)
				return false;
		} else if (!familyIdGo.equals(other.familyIdGo))
			return false;
		if (familyIdInterested == null) {
			if (other.familyIdInterested != null)
				return false;
		} else if (!familyIdInterested.equals(other.familyIdInterested))
			return false;
		return true;
	}

}
