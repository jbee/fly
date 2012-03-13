package de.jbee.fly.probability;

import static de.jbee.fly.probability.Probability.probability;

public class Cohesions {

	public interface Influence { // or Impact or Importance

	}

	//probability.increases( upTo(50, onlyWhen()), startsWith(upper_case_letter) ); 
	//probability.increases( onlyWhen(), continues(1,lower_case_letter));
	// letters following makes the change slightly smaller since words normally are not endlessly long
	// but non-letters make us pretty sure its not a noun

	// N A M I N G

	// consists of -> fragments in loose order without the need to really have them
	// consistsOf(nouns, verbs, abbreviation) -> means: can be nouns, verbs or abbreviations

	public static Cohesion upTo( int index, Cohesion lessThanOrEqual, Cohesion greaterThan ) {
		return new IndexDependendCohesion( lessThanOrEqual, greaterThan, index );
	}

	public static Cohesion plus( int increment, Cohesion increased ) {
		return new IncrementCohesion( increased, increment );
	}

	public static Cohesion minus( int decrement, Cohesion decreased ) {
		return plus( -decrement, decreased );
	}

	public static Cohesion characters( CharacterType type ) {
		return new CharacterTypeCohesion( type );
	}

	public static Cohesion atLeast( int minimum, Cohesion limited ) {
		return new RequiredMinimumCohesion( limited, minimum );
	}

	public static Cohesion required( Cohesion cohesion ) {
		return atLeast( 1, cohesion );
	}

	public static Cohesion moreProbable( Cohesion one, Cohesion other ) {
		return new HigherCohesion( one, other );
	}

	public static Cohesion lessProbable( Cohesion one, Cohesion other ) {
		return new LowerCohesion( one, other );
	}

	public static Cohesion retains( int value, Cohesion retained ) {
		return moreProbable( new ConstantCohesion( probability( value ) ), retained );
	}

	public static Cohesion terminable( Cohesion terminable ) {
		return new TerminableCohesion( terminable );
	}

	public static Cohesion interminable( Cohesion interminable ) {
		return new InterminableCohesion( interminable );
	}

	private static class ConstantCohesion
			implements Cohesion {

		private final Probability value;

		ConstantCohesion( Probability value ) {
			super();
			this.value = value;
		}

		@Override
		public Probability probability( Char character, Probability previous ) {
			return value;
		}
	}

	private static class LowerCohesion
			implements Cohesion {

		private final Cohesion one;
		private final Cohesion other;

		LowerCohesion( Cohesion one, Cohesion other ) {
			super();
			this.one = one;
			this.other = other;
		}

		@Override
		public Probability probability( Char character, Probability previous ) {
			return one.probability( character, previous ).lower(
					other.probability( character, previous ) );
		}

	}

	private static class HigherCohesion
			implements Cohesion {

		private final Cohesion one;
		private final Cohesion other;

		HigherCohesion( Cohesion one, Cohesion other ) {
			super();
			this.one = one;
			this.other = other;
		}

		@Override
		public Probability probability( Char character, Probability previous ) {
			return one.probability( character, previous ).higher(
					other.probability( character, previous ) );
		}

	}

	private static class IndexDependendCohesion
			implements Cohesion {

		private final Cohesion lessThanOrEqual;
		private final Cohesion greaterThan;
		private final int index;

		IndexDependendCohesion( Cohesion lessThanOrEqual, Cohesion greaterThan, int index ) {
			super();
			this.lessThanOrEqual = lessThanOrEqual;
			this.greaterThan = greaterThan;
			this.index = index;
		}

		@Override
		public Probability probability( Char character, Probability previous ) {
			return character.layerIndex() <= index
				? lessThanOrEqual.probability( character, previous )
				: greaterThan.probability( character, previous );
		}

	}

	private static class IncrementCohesion
			implements Cohesion {

		private final Cohesion increased;
		private final int increment;

		IncrementCohesion( Cohesion increased, int increment ) {
			super();
			this.increased = increased;
			this.increment = increment;
		}

		@Override
		public Probability probability( Char character, Probability previous ) {
			return increased.probability( character, previous.plus( increment ) );
		}
	}

	private static class CharacterTypeCohesion
			implements Cohesion {

		private final CharacterType type;

		CharacterTypeCohesion( CharacterType type ) {
			super();
			this.type = type;
		}

		@Override
		public Probability probability( Char character, Probability previous ) {
			return type.isMember( character )
				? previous
				: Probability.zero;
		}

	}

	private static class RequiredMinimumCohesion
			implements Cohesion {

		private final Cohesion limited;
		private final int minimum;

		RequiredMinimumCohesion( Cohesion limited, int minimum ) {
			super();
			this.limited = limited;
			this.minimum = minimum;
		}

		@Override
		public Probability probability( Char character, Probability previous ) {
			return limited.probability( character, previous ).atLeast( minimum );
		}

	}

	private static class TerminableCohesion
			implements Cohesion {

		private final Cohesion terminable;

		TerminableCohesion( Cohesion terminable ) {
			super();
			this.terminable = terminable;
		}

		@Override
		public Probability probability( Char character, Probability previous ) {
			return terminable.probability( character, previous ).terminable();
		}

	}

	private static class InterminableCohesion
			implements Cohesion {

		private final Cohesion interminable;

		InterminableCohesion( Cohesion interminable ) {
			super();
			this.interminable = interminable;
		}

		@Override
		public Probability probability( Char character, Probability previous ) {
			return interminable.probability( character, previous ).interminable();
		}

	}
}
