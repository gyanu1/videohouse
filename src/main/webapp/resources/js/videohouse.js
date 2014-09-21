$(document).ready(function() {
	$('div .col-md-5').click(function() {
	/*	$.ajax({
			type : "POST",
			url : "play",
			data : "",
			success : function(dataBack) {
				alert(dataBack);
				$('.container').replaceWith(dataBack);
			},
			dataType : "html"
		});*/
		window.location = 'video?id='+"124455";
	});
});