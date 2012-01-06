package de.jbee.fly;

import de.jbee.io.IProcessableElement;

public interface FlyProcessor {

	void process( FormalType type, String name, IProcessableElement<FlyScheme> scheme );

	void process( ContextualType type, IProcessableElement<FlyScheme> structure );

	void process( AuthorialType type, IProcessableElement<FlyLeg> word );
}
