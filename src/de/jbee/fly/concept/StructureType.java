package de.jbee.fly.concept;

/**
 * Knoten im Baum der Dokumenten-Struktur. Enthalten selbst keinen Text.
 * 
 * Können jeweils in einer Datei liegen also einer Datei zugewiesen werden (hier auch mit UUID
 * arbeiten).
 * 
 * @author Jan Bernitt (jan.bernitt@gmx.de)
 * 
 */
public enum StructureType {

	DOCUMENT,
	PART,
	CHAPTER,
	SECTION,
	PARAGRAPH,

	PASSAGE, // ist relativ zur aktuellen sturktur-tiefe
	// oben: hier geht es nur um die ebene/größe - es sind alles blöcke eines Schriftstücks

	// unten: hier hat das ganze auch noch inhaltlichen kontext: was sieht man - das muss noch getrennt werden 

	ADDRESS,
	FIGURE, // bilder, code, etc. (alles nicht wie text zu lesende)
	TABLE,
	LISTING,

	TEXT, // hier steckt der eigentlich text drin 

	// unten: ab hier geht es mehr um die gedankliche struktur-und das page layout

	SNIPPET, // kein ganzer abschnitt aber kann mehrere paragraphen, figuren und tabllen beinhalten

	;
	// PAGE, FOOTNOTE, HEADER, FOOTER
}
