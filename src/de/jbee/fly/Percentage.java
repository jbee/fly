package de.jbee.fly;

public final class Percentage {

	private final int points;

	Percentage( int points ) {
		super();
		this.points = points;
	}

	@Override
	public String toString() {
		return String.valueOf( points );
	}

	@Override
	public boolean equals( Object obj ) {
		return obj instanceof Percentage && equalTo( (Percentage) obj );
	}

	public boolean equalTo( Percentage other ) {
		return other.points == points;
	}

	@Override
	public int hashCode() {
		return points;
	}
}
