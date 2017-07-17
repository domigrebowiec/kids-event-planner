package dg.hexagonal.domain;

import java.io.Serializable;

public class EventPlace implements Serializable {

	private static final long serialVersionUID = -2346797048891580379L;
	
	private long id;
	private long coordX;
	private long coordY;
	private String name;

	public EventPlace() {}
	
	public EventPlace(long coordX, long coordY, String name) {
		super();
		this.coordX = coordX;
		this.coordY = coordY;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCoordX() {
		return coordX;
	}

	public void setCoordX(long coordX) {
		this.coordX = coordX;
	}

	public long getCoordY() {
		return coordY;
	}

	public void setCoordY(long coordY) {
		this.coordY = coordY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "EventPlace [coordX=" + coordX + ", coordY=" + coordY + ", name=" + name + "]";
	}

}
