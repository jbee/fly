package de.jbee.fly.probability;

import static de.jbee.fly.probability.CharacterTypes.LOWER_CASE_LETTER;
import static de.jbee.fly.probability.CharacterTypes.UPPER_CASE_LETTER;
import static de.jbee.fly.probability.Cohesions.characters;
import static de.jbee.fly.probability.Cohesions.minus;
import static de.jbee.fly.probability.Cohesions.moreProbable;
import static de.jbee.fly.probability.Cohesions.plus;
import static de.jbee.fly.probability.Cohesions.required;
import static de.jbee.fly.probability.Cohesions.retains;
import static de.jbee.fly.probability.Cohesions.upTo;
import static de.jbee.fly.probability.Unit.SYMBOL;
import static de.jbee.fly.probability.Unit.TERM;

public class TestScheme
		extends RootScheme {

	private static final String letters = "letter";
	private static final String lower_case_letters = "lower-case-letter";
	private static final String upper_case_letters = "upper-case-letter";

	@Override
	public void setup( Lexicon lexicon ) {
		def( SYMBOL, upper_case_letters, characters( UPPER_CASE_LETTER ) );
		def( SYMBOL, lower_case_letters, characters( LOWER_CASE_LETTER ) );
		def( SYMBOL, letters, moreProbable( symbol( upper_case_letters ),
				symbol( lower_case_letters ) ) );

		def( TERM,
				"noun", //
				upTo( 0,
						required( plus( 50, symbol( upper_case_letters ) ) ), // 
						upTo( 7, required( plus( 10, symbol( lower_case_letters ) ) ), // 
								required( retains( 50, minus( -5, symbol( lower_case_letters ) ) ) ) ) ) );
	}

}
