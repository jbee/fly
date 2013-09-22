package de.jbee.fly.line;

import de.jbee.fly.Count;
import de.jbee.fly.Percentage;

/**
 * A example for a {@link LineAnalyser}.
 * 
 * @author Jan Bernitt (jan.bernitt@gmx.de)
 * 
 */
public class WhitespaceAnalyser
		implements LineAnalyser<de.jbee.fly.line.WhitespaceAnalyser.WhitespaceStatistic> {

	// OPEN maybe this is something more generic since it makes sense to have it for other character types too and another class feels wrong
	// by adding an parameter this could work more generic but less final
	public static class WhitespaceStatistic {

		public final Count count;
		public final Percentage percentage;

		WhitespaceStatistic( Count count, Percentage percentage ) {
			super();
			this.count = count;
			this.percentage = percentage;
		}

		// could sum up the 3 unicode separator categories

	}

	@Override
	public WhitespaceStatistic analyse( Line line ) {
		return null;
	}
}
