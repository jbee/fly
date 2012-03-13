package de.jbee.fly;

import static de.jbee.fly.probability.CharacterTypes.LOWER_CASE_LETTER;
import static de.jbee.fly.probability.CharacterTypes.UPPER_CASE_LETTER;
import static de.jbee.fly.probability.Cohesions.characters;
import static de.jbee.fly.probability.Cohesions.minus;
import static de.jbee.fly.probability.Cohesions.plus;
import static de.jbee.fly.probability.Cohesions.required;
import static de.jbee.fly.probability.Cohesions.upTo;
import static de.jbee.fly.probability.Probability.impossible;
import static de.jbee.fly.probability.Probability.probability;
import static de.jbee.fly.probability.Probability.zero;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.jbee.fly.probability.Char;
import de.jbee.fly.probability.Cohesion;
import de.jbee.fly.probability.Probability;

public class TestCohesion {

	@Test
	public void test() {
		Cohesion ucl50 = plus( 50, characters( UPPER_CASE_LETTER ) );
		Cohesion lcl10 = plus( 10, characters( LOWER_CASE_LETTER ) );
		Cohesion lclm5 = minus( 5, characters( LOWER_CASE_LETTER ) );
		Cohesion c1 = upTo( 0, ucl50, lcl10 );
		Probability p50 = probability( 50 );
		Probability p60 = probability( 60 );
		Probability p70 = probability( 70 );
		Probability p55 = probability( 55 );
		assertThat( c1.probability( new Char( 'H', 0 ), zero ), is( p50 ) );
		assertThat( c1.probability( new Char( 'a', 1 ), p50 ), is( p60 ) );
		assertThat( c1.probability( new Char( '1', 1 ), p50 ), is( zero ) );
		assertThat( c1.probability( new Char( 'l', 2 ), p60 ), is( p70 ) );
		Cohesion c2 = upTo( 0, required( ucl50 ), required( lcl10 ) );
		assertThat( c2.probability( new Char( 'H', 0 ), zero ), is( p50 ) );
		assertThat( c2.probability( new Char( 'a', 1 ), p50 ), is( p60 ) );
		assertThat( c2.probability( new Char( '1', 1 ), p50 ), is( impossible ) );
		assertThat( c2.probability( new Char( 'l', 2 ), p60 ), is( p70 ) );
		Cohesion c3 = upTo( 0, ucl50, upTo( 2, lcl10, lclm5 ) );
		assertThat( c3.probability( new Char( 'l', 3 ), p60 ), is( p55 ) );
	}
}
