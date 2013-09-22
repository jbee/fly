package de.jbee.fly;

public final class Count {

	private final int count;

	Count( int count ) {
		super();
		this.count = count;
	}

	@Override
	public String toString() {
		return String.valueOf( count );
	}

	@Override
	public boolean equals( Object obj ) {
		return obj instanceof Count && equalTo( (Count) obj );
	}

	public boolean equalTo( Count other ) {
		return other.count == count;
	}

	@Override
	public int hashCode() {
		return count;
	}
}
