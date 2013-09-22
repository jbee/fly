package de.jbee.fly.line;

import java.util.Arrays;

import de.jbee.fly.Char;

public final class Line {

	public final Char[] sequence;
	public final int length;
	private final LineStatistic statistic;

	Line( Char[] characters, LineStatistic statistic ) {
		super();
		this.sequence = characters;
		this.length = characters.length;
		this.statistic = statistic;
	}

	public <T> T statistic( Class<T> type ) {

		return null;
	}

	@Override
	public String toString() {
		return Arrays.toString( sequence );
	}
}
