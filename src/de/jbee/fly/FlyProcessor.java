package de.jbee.fly;

import de.jbee.io.IProcessableElement;

public interface FlyProcessor {

	void process( FormalType type, String name, IProcessableElement<FlyScheme> scheme );

	void process( ContentType type, IProcessableElement<FlyElement> structure );

	void process( AuthorialType type, IProcessableElement<FlyLeg> word );
}
