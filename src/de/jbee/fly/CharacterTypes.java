package de.jbee.fly;

import static java.lang.Character.LOWERCASE_LETTER;
import static java.lang.Character.UPPERCASE_LETTER;

public class CharacterTypes {

	public static final CharacterType LOWER_CASE_LETTER = unicodeType( LOWERCASE_LETTER );
	public static final CharacterType UPPER_CASE_LETTER = unicodeType( UPPERCASE_LETTER );

	public static CharacterType unicodeType( byte type ) {
		return new UnicodeCharacterType( type );
	}

	private static final class UnicodeCharacterType
			implements CharacterType {

		private final int type;

		UnicodeCharacterType( byte type ) {
			super();
			this.type = type;
		}

		@Override
		public boolean isMember( Char character ) {
			return character.unicodeType() == type;
		}

	}

}
