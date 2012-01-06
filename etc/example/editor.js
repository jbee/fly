

$(document).ready( function() {
	var editor = new Editor();
	editor.init();
	editor.startBlink();

});


function Editor() {
	this.text = $('#t1').get();
	this.markup = $('#m1').get()
	this.instruction = true;
	
	this.appendMarkup = function(character) {
		$(this.markup).children('code').first().append(character);
	}
	this.appendText = function(character) {
		$(this.text).append(character);
	}
	this.startBlink = function() {
		window.blinker = setInterval(function() {
			if (window.blink) {
				$('#cursor').css('background-color', 'black');
				window.blink = false;
			} else {
				$('#cursor').css('background-color', '#888');
				window.blink = true;
			}
		}, 500);
	}
	
	this.onTab = function(event) {
		if (this.instruction) {
			this.instruction = false;
			this.appendMarkup('<em>	</em>');
		} else {
			this.appendText(' ');
		}
	}
	
	this.onEnter = function(event) {
		this.instruction = true;
		this.appendMarkup('\n');
		var m = $(this.markup);
		var sib = m.next().size;
		if (sib > 0) {
			alert(sib);
		} else {
			m.after('<li><code></code></li>');
			var m2 = m.next();
			m2.append($('#cursor'))
			this.markup = m2.get();
		}
	}
	
	this.onVisibleCharacter = function(event) {
		var c = String.fromCharCode(event.charCode);
		this.appendText(c);
		this.appendMarkup(c);		
	}
	
	this.init = function() {
		$(document).bind('keydown', 'Tab', function(event) {
			this.onTab(event);
			return false;
		});
		$(document).bind('keydown', 'ctrl+d', function(event) {
			var m = $(this.markup);
			var prev = m.prev();
			prev.append($('#cursor'));
			m.remove();
			this.markup = prev.get();
			return false;
		});
		$(document).bind('keydown', 'Backspace', function(event) {
			
			
		});
		$(document).bind('keydown', 'Return', function(event) {
			this.onEnter(event);
			return false;
		});
		$(document).bind('keypress', function(event) {
			if (event.which == 13) {
				return false;
			}
			this.onVisibleCharacter(event);
			return false;
		});
	}
	
}