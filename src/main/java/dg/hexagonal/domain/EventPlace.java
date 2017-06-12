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
		
}
