package de.jbee.fly.concept.v1;

// get rid of this completely ?

public enum FormalType { // PhysicalType ?

	DOCUMENT,

	/**
	 * A part of a document. Examples: Cover-page, Abstract, Content, Appendix
	 * 
	 * Each part has its own interpretation of markup. Parts can be nested into each other. The
	 * {@link #DOCUMENT}-part is the basic (and parent) part of all different parts of a document.
	 */
	PART,

	/**
	 * A section is everything smaller than a part. That means the interpretation of markup will not
	 * change during the section.
	 */
	SECTION,

	LINE, // ????
	WORD, // ????
	;
}
