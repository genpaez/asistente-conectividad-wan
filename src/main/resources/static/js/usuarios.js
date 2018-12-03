function ajax_cargarusuarios() {
		
	    $.ajax({
	    	type: "POST",
	        contentType: "application/json",
	        url: "/registration/usuarios",
	        data: JSON.stringify(),
	        dataType: 'json',
	        cache: false,
	        timeout: 600000,
	    		}).then(function(data) {
	    			$('#seleccionUsuario').html('');   // Deja en blanco antes de cargar desde server
	    			$('#seleccionUsuario').append('<option value="">' + ' Seleccione usuario a eliminar...' + '</option>');
	    			$.each(data, function(i, optionHtml){	
	  	            $('#seleccionUsuario').append('<option value="'+optionHtml.id+'">' + optionHtml.email + '</option>');  // Recorre array e inserta opciones
	  	           });
	    		});
	    
}


function ajax_eliminarusuario() {
	
	event.preventDefault();
	
	var usuario = {}
	usuario["id"] = $('#seleccionUsuario').val();
	
    $.ajax({
    	type: "POST",
        contentType: "application/json",
        url: "/registration/eliminarUsuario",
        data: JSON.stringify(usuario),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function() {
            $("#labelEliminar").text("usuario eliminado con éxito");
        },
        error: function() {
        	$("#labelEliminar").text("Error. Intente nuevamente");
        }
    }).then(function(data) {});
}