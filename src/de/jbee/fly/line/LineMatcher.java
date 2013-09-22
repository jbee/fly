package de.jbee.fly.line;

import de.jbee.fly.Percentage;

public interface LineMatcher { // correlation ? 

	Percentage matches( Line line ); //TODO add information about the previous line's type
}
