package de.jbee.fly;

/**
 * A formal view a text's (document's) content.
 * 
 * What kind of structure and elements do I see when I look at the text.
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
	 * Use {@link #SECTION}s as children to model 'Appendix A, B, C'.
	 * 
	 * When nested into a {@link #PART}, {@link #CHAPTER}, {@link #SECTION}, {@link #SUBSECTION} or
	 * {@link #PARAGRAPH} it contains the (foot)notes of the parent modeled through {@link #NOTE}s.
	 */
	APPENDIX,

	/*
	 * Basic (substance) Elements
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
	 * A note can contain multiple {@link #CAPTION}s and {@link #PARAGRAPH}s. Each of them again can
	 * be annotated with a note.
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
	 * Non-Textual Elements
	 */

	/**
	 * A hint how to understand the text/markup like a page-break or vertical space.
	 * 
	 * Line-breaks are special since they are already translated into a sequence of
	 * {@link #PARAGRAPH}s when the document tree is created.
	 */
	HINT,

	/**
	 * A parting line, triple asterisk, dingbat symbol or something similar.
	 */
	SEPARATOR,

	/**
	 * A link (textual reference) to external content (no FLY-document) that is included by the
	 * viewer properly. This are all types of image or foreign format files like JPG, PNG, PDF and
	 * so on.
	 */
	INCLUDE,

	/**
	 * The subtree is physically stored in another FLY-document source (e.g. another file)
	 * 
	 * A import can predefine what kind of block node the 'top level' of the imported elements will
	 * be.
	 */
	INPORT,
}
