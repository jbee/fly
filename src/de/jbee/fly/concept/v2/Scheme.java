package de.jbee.fly.concept.v2;

public interface Scheme {

	void setup( Lexicon lexicon );

	Cohesion ref( Unit unit, String name );

	void def( Unit unit, String name, Cohesion cohesion );

	//schema.note(term, 'Noun').given(at(50));

	// there is a virtual schema called 'root' that can be used to start with the 'normal' bindings 
	// after a uses-statement the schema does its overrides by doing binds like so: noteThat(name).actuallyIs(class/type);  

	// S I M P L E R
	// schema has a setup method to initialize known rules

	// but rules can be grouped together like terms, fragments, blocks or headings and such
}
