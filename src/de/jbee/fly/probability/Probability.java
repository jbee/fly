package de.jbee.fly.probability;

public final class Probability
		extends Number {

	public static Probability zero = new Probability( 0, false );
	public static Probability impossible = new Probability( -1, false );

	private final int value;
	private final boolean terminable;

	private Probability( int value ) {
		this( value, false );
	}

	private Probability( int value, boolean terminable ) {
		super();
		this.value = value;
		this.terminable = terminable;
	}

	public boolean isTerminable() {
		return terminable;
	}

	public boolean isImpossible() {
		return value < 0;
	}

	public Probability terminable() {
		return terminable || isImpossible()
			? this
			: new Probability( value, true );
	}

	public Probability interminable() {
		return terminable
			? new Probability( value, false )
			: this;
	}

	public static Probability probability( int value ) {
		return new Probability( value );
	}

	public Probability plus( int increment ) {
		return probability( value + increment );
	}

	public Probability minus( int decrement ) {
		return probability( value - decrement );
	}

	public Probability lower( Probability other ) {
		return value < other.value
			? this
			: other;
	}

	public Probability higher( Probability other ) {
		return this == impossible || other == impossible
			? impossible
			: value > other.value
				? this
				: other;
	}

	public Probability atLeast( int minimum ) {
		return value < minimum
			? impossible
			: this;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( obj instanceof Probability ) {
			return value == ( (Probability) obj ).value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf( value );
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return value;
	}

	@Override
	public int intValue() {
		return value;
	}

	@Override
	public long longValue() {
		return value;
	}
}
