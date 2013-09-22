package de.jbee.fly.concept.v2;


/**
 * Transforms a physical document (markup) made of lines, words and characters to a logical document
 * made of parts, chapters, sections, paragraphs, enumerations, lists, tables, images, figures and
 * so on.
 * 
 * There is a global scheme controlling the switch between the special schemes used for parts or
 * special purpose elements.
 * 
 * @author Jan Bernitt (jan.bernitt@gmx.de)
 * 
 */
public interface FlyScheme {

	// ein schema ist etwa der header eines dokuments - wechselt die logische/technische struktur
	// eines dokuments beginnt gewöhnlich auch eine neues schema -> ein schema muss ihr ende erkennen
	// und mitteilen können ---> es sollte ein markup geben, dass ein neues schema einleitet, damit
	// der autor selbst ein schema erzwingen kann (der doctype könnte bereits dieses markup nutzen)

	//void process( CharReader in, FlyProcessor out );

	// statt des readers das dokument als eingabe, welches an einer bestimmten position bearbeitet wird ?

	// vielleicht ist ein schema auch ein art scanner, welcher ein prozessor bekommt:
	// sicher sogar: denn so ist nur ein return typ möglich - es wäre besser hier flexieber zu sein

	//
	//
	//OPEN Eine simple Parser-API und als ein Prozessor (Empfänger) dann eine Impl. die daraus den Baum baut der durch die entsprechenden element beschrieben wird.

	// --------> Zwischensprache nötig, die alles bereits beschreiben kann - geht das ? passt das ?

	// die unterscheidung ist vielleicht komplizierter als nötig. wenn ein schema gefunden wird,
	// heißt das eigentlich nichts weiter als dass das schema selbst von nun den parent spielt und 
	// den rest des eingabestroms bis zu einem punkt (der für das schmea das ende bedetet) verarbeitet.
	// die parse-funktion wird als mit dem scheme als argument weitergeführt, bis dies beendet ist
	// oder ein neues sich noch unten einhängt usw.
}
