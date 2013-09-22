package de.jbee.fly.line;

import de.jbee.fly.Percentage;
import de.jbee.fly.line.LetterAnalyser.LetterStatistic;
import de.jbee.fly.line.WhitespaceAnalyser.WhitespaceStatistic;

public class PhraseMatcher
		implements LineMatcher {

	@Override
	public Percentage matches( Line line ) {
		WhitespaceStatistic whitespace = line.statistic( WhitespaceStatistic.class );
		LetterStatistic letters = line.statistic( LetterStatistic.class );
		return null;
	}

}
