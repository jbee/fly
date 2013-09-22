package de.jbee.fly;

import static java.lang.Character.getType;

/**
 * A specific character.
 * 
 * @author Jan Bernitt (jan.bernitt@gmx.de)
 * 
 */
public final class Char {

	//TODO use flyweights so for each char just one Char object is created ever - thereby it soon becomes very cheap to use Char instead of char with all its benefits 

	private final char character;
	private final int unicodeType;

	public Char( char character ) {
		super();
		this.character = character;
		this.unicodeType = getType( character );
	}

	public int unicodeType() {
		return unicodeType;
	}

	@Override
	public String toString() {
		return String.valueOf( character );
	}
}
