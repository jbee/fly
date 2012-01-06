
function Structure(name) {
	this.name = name;
}

var StructureType = {
	DOCUMENT	: new Structure("DOCUMENT"),
	PART		: new Structure("PART"),
	CHAPTER 	: new Structure("CHAPTER"),
	SECTION		: new Structure("SECTION"),
	PARAGRAPH	: new Structure("PARAGRAPH"),
}

function MarkupLine(element) {

	
	this.element = element;
	
	this.prev = /* Markup */ function {
		
	}
	
	this.code = /* char */ function {
		
	}
	this.tag = /* String */ function {
		
	}
	this.attributes = /*String[]*/ function {
		
	}
}