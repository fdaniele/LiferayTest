$(document).ready(function() {
	var topDiv = $('.thisone').offset();
	var top = topDiv.top;
	$('.trigger').click(function() {
		$('.thisone').css('position', '');
		$('.center').toggle('slow', function() {
			top = $('.thisone').offset().top;
		});

	});

	$(document).scroll(function() {
		// calculating the minimal top position of the div
		$('.thisone').css('position', '');
		top = $('.thisone').offset().top;

		$('.thisone').css('position', 'relative');
		$('.thisone').css('top', Math.max(top, $(document).scrollTop()));
	});
	
	$('#btnAnswer .btn-success').click(function(){
		colorCssAnswer(true, $(this));
		addRisposta(true);
	});
	$('#btnAnswer .btn-danger').click(function(){
		colorCssAnswer(false,$(this));
		addRisposta(false);
	});
	
	$('#btnShuffle .btn-default').click(function(){
		window.location.href = "/?shuffle=true";
	});
});

function colorCssAnswer(giusta,clickId){
	var pan = $(clickId).parent().parent().parents().get(1);
	$(pan).find('button').attr("disabled", true);
	var pan2 = $(pan).children().get(0);
	var h4 = $(pan2).children().get(0);
	if(giusta){
		$(h4).addClass("bg-success");
	} else {
		$(h4).addClass("bg-danger");
	}
}

function addRisposta(giusta){
	if(giusta){
		var g = parseInt($('#infoAnsGiusta').text(), 10);
		$('#infoAnsGiusta').html(++g);
	} else {
		var s = parseInt($('#infoAnsSbagliata').text(), 10);
		$('#infoAnsSbagliata').html(++s);
	}
}