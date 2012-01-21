package de.jbee.fly;

/**
 * A formal content view of text (a document).
 * 
 * @author Jan Bernitt (jan.bernitt@gmx.de)
 */
public enum ContentType {

	/*
	 * Block Elements
	 */

	/**
	 * E.g. a book part. *NOT* at document part.
	 * 
	 * Parts are always just top level elements in a document (if present). They cannot be nested or
	 * contained in any of the other types.
	 */
	PART,

	/**
	 * A chapter is a top level element of a document or a direct child of a {@link #PART}.
	 */
	CHAPTER,

	/**
	 * A section is a top level element of a document or a direct child of a {@link #CHAPTER} or
	 * {@link #PART}.
	 */
	SECTION,

	/**
	 * A subsection has to be a direct child of a {@link #SECTION}. Further nested subsections can
	 * be modeled by nesting a subsection into another {@link #SUBSECTION} element.
	 * 
	 * In contrast to a {@link #PARAGRAPH} a sub-section is a block element that may have multiple
	 * child nodes. In contract to a {@link #SECTION} a sub-section often has no {@link #CAPTION}
	 * element as first child.
	 */
	SUBSECTION,

	/**
	 * Some kind of listing like a enumeration. All direct children are {@link #ITEM}s.
	 * 
	 * It may be a child of a {@link #CHAPTER}, {@link #SECTION}, {@link #SUBSECTION},
	 * {@link #APPENDIX} or {@link #NOTE}.
	 * 
	 * Tables are also itemisations described by a sequence of cells (we know how may rows and
	 * columns)
	 */
	ITEMISATION,

	/**
	 * A item can be used in different ways:
	 * 
	 * As direct child of an {@link #ITEMISATION} it integrates all its children as one 'item'.
	 */
	ITEM,

	/**
	 * A appendix can be used in different ways:
	 * 
	 * As a top level element it is a special document part known (and often titled) as 'Appendix'.
	 * 
	 * When nested into a {@link #PART}, {@link #CHAPTER}, {@link #SECTION}, {@link #SUBSECTION} or
	 * {@link #PARAGRAPH} it contains the footnotes of the parent modeled through {@link #NOTE}s.
	 * The notes itself my again contain multiple {@link #PARAGRAPH}s.
	 */
	APPENDIX,

	/*
	 * Basic Elements
	 */

	/**
	 * A headline, image or listing caption or similar.
	 * 
	 * A {@link #NOTE} can be attached as a child.
	 */
	CAPTION,

	/**
	 * A paragraph is a continuous (plain) text block. It can be a direct child of a {@link #PART},
	 * {@link #CHAPTER}, {@link #SECTION}, {@link #SUBSECTION}, {@link #NOTE} or {@link #VERBATIM}.
	 * 
	 * A {@link #NOTE} can be attached as a child.
	 */
	PARAGRAPH,

	/**
	 * A legend, footnote, side note or similar.
	 * 
	 * A note can contain multiple {@link #PARAGRAPH}s.
	 */
	NOTE,

	/**
	 * A text fragment meant literally like a code block or line.
	 * 
	 * It can be titled and described using an {@link #ITEM} that includes a {@link #CAPTION}
	 * followed by one or more {@link #VERBATIM}s and finally a {@link #NOTE} as description/legend.
	 */
	VERBATIM,

	/*
	 * Invisible Non-Textual Elements
	 */

	/**
	 * A textual reference to external content that is included in the view later.
	 */
	INCLUDE,

	/**
	 * A hint how to understand the text/markup like a page-break or line-break.
	 */
	HINT,
}
