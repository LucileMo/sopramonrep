function addSopramon(){
	
	let mySopramon = {
			
			
			
			//nom, prenom, username, password, dateNaissance
			
			nom : $('input[name="nom"]').val(),
			prenom : $('input[name="prenom"]').val(),
			username : $('input[name="username"]').val(),
			password : $('input[name="password"]').val(),
			dateNaissance : $('input[name="dateNaissance"]').val()
}	

	
	$.ajax({
		method: 'POST',
		url: 'http://192.168.1.100:8080/sopramon-web/api/sopramons',
		data: mySopramon,
		success: function(data) {
			addSopramon(mySopramon);
		}
	   

		});
	
	}
	
	$('form').bind('submit', function(){
		
		addSopramon();
		document.location.href = "Connexion.html"
		return false;
	});
	
	$('.arene').bind('mouseenter', function() {
		$('picture/arene.png').attr('src', 'pictures/arene_effet.png');
	});
	
	$('off').mouseover(
			$('button.clear').attr('src', 'pictures/arene.png'));

		