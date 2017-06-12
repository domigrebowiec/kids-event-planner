package dg.hexagonal.domain;

public class EventPlace {

	private long coordX;
	private long coordY;
	private String name;
	
	public EventPlace(long coordX, long coordY, String name) {
		super();
		this.coordX = coordX;
		this.coordY = coordY;
		this.name = name;
	}

	public long getCoordX() {
		return coordX;
	}

	public long getCoordY() {
		return coordY;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Comparing EventPlace");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventPlace other = (EventPlace) obj;
		if (coordX != other.coordX)
			return false;
		if (coordY != other.coordY)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
		
}
