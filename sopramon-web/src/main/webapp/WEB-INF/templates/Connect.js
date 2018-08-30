// Se connecter

		$('form').bind('submit', function() { 

		    		$.ajax({
			method: 'POST',	
			url: 'http://192.168.1.100:8080/sopramon-web/api/auth',
			data: { username: $('input[name="username"]').val(),
					password: $('input[name="password"]').val() },
			success: function() {
					document.location.href = "Espace-sopramon.html";
			}
			
					});
return false;
		});