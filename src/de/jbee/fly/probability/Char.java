package de.jbee.fly.probability;

import static java.lang.Character.getType;

/**
 * A specific character at a specific position in a block of characters.
 * 
 * All this information will be avaiable.
 * 
 * @author Jan Bernitt (jan.bernitt@gmx.de)
 * 
 */
public final class Char {

	private final char character;
	private final int index;
	private int type = 0;

	public Char( char character, int index ) {
		super();
		this.character = character;
		this.index = index;
	}

	public int unicodeType() {
		if ( type == 0 ) {
			type = getType( character );
		}
		return type;
	}

	public int layerIndex() {
		return index;
	}

	// is start of a word ?
	// is end of a word ? -> maybe we recognize this just through the next start

	// int layerIndex() -> the nth character in a token, the nth token in a part, the nth part in a block but not the nth block in a schema - we don't know that -> we just know about the structure the current block is occurring under
	// maybe we need more indexes
}
