package de.jbee.fly.line;

/**
 * Description of what types are possible inside a scheme.
 * 
 * @author Jan Bernitt (jan.bernitt@gmx.de)
 * 
 */
public class Scheme {

	LinePattern[] nonterminal; // keep using this scheme --> what if a LineType is a hole Scheme again ?  There must be something in common --> in general: what does a line become when recognized by a pattern - there must be some kind of mapping here - one possible mapped consumer is a scheme
	LinePattern[] terminal; // ends using the scheme and starts using the parent scheme again
}
