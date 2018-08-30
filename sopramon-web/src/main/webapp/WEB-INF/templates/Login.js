//créer la fonction js

$('body ').bind('submit', function(list) {
	list();
	return false;
});



//Récupérer la liste des sopramon

function appendSopramon(sopramon){
	
	var myLigne = $("<tr/>");
	var myColonneNom = $("<td/>");
	var myColonnePrenom = $("<td/>");
	var myColonneUsername = $("<td/>");
	
	myColonneNom.html (sopramon.nom);
	myColonnePrenom.html (sopramon.prenom);
	myColonneUsername.html (sopramon.username);
	
	myLigne.append(myColonneNom);
	myLigne.append(myColonnePrenom);
	myLigne.append(myColonneUsername);
	
	$('#sopramons tbody').append(myLigne);
}
	

$(".list").bind('click', function() { 
	
	//liste des sopramon
		$.ajax({
			method: 'GET',
			url: 'http://192.168.1.100:8080/sopramon-web/api/sopramons',
			success: function(sopramons) {				// liste de sopramon
				console.log(sopramons)
				;
				for (let sopramon of sopramons) {
					appendSopramon(sopramon);
				}
			}
		});
	});











// LISTER ITEMS

//Récupérer la liste des sopramon

$('.btn-listitem').bind('click', function() { 

$.ajax({
	method: 'GET',	
	url: 'http://192.168.1.100:8080/sopramon-web/api/items',
	success: function(items) {
		console.log(items);

		// AJOUT DE CHAQUE ITEM
		for (let item of items) {
			appendItem(item);
		}
	}
	});

});


function appendItem(item) {
		var myRow = $("<tr />");
		var myColNom = $("<td />");
		var myColPrix= $("<td />");
		var myColCapacite = $("<td />");
	
		myRow.append(myRow);
		myRow.append(myColNom);
		myRow.append(myColPrix);
		myRow.append(myColCapacite);

		myColNom.html(item.nom);
		myColPrix.html(item.prix);
		myColCapacite.html(item.capacite);
		
		$('#items tbody').append(myRow);
		
}


// se connecter

$('btn-seconnecter').bind('click', function() { 

	$.ajax({
		  method: "POST",
		  url: 'http://192.168.1.100:8080/sopramon-web/api/auth',
		  data: JSON.stringify(sopramon), 		
		  success: function(sopramon) {				
			;
			}
		});
		
	});

	