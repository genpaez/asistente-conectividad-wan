$(document).ready(function () {

    $("#search-form").submit(function (event) {      // Desde botón
    	
        //stop submit the form, we will post it manually.
        event.preventDefault();
        shoot_ajax_submit();

    });
    
});


function shoot_ajax_submit() {   
	
//	var search = {}
//    search["nombre"] = $("#username").val();
	
    $("#btn-search").prop("disabled", true);	
	
	
    $.ajax({
    	type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(),
    //    data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
    		}).then(function(data) {
    			$('.result').text(JSON.stringify(data, null, 1));
    			$('#cliente').html('');   // Deja en blanco antes de cargar desde server
    			$('#cliente').append('<option value="">' + 'Seleccione un cliente...' + '</option>');
    			$.each(data, function(i, optionHtml){	
  	            $('#cliente').append('<option value="">' + optionHtml.correo + '</option>');  // Recorre array e inserta opciones
  	           //       dropdown.append('<option value="' + v.id + '">' + v.name + '</option>'); Notación
  	           });
    		});
    
    $("#btn-search").prop("disabled", false);
}





function ajax_ciudad() {      // onchange en select boxes
	
//	var search = {}
//    search["nombre"] = $("#username").val();	
	event.preventDefault();
	$("#btn-search").prop("disabled", true);  // <<--
	
    $.ajax({
    	type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(),
    //    data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
    		}).then(function(data) {
    			$('.result').text(JSON.stringify(data, null, 1));
    			$('#ciudad').html('');   // Deja en blanco antes de cargar desde server
    			$('#ciudad').append('<option value="">' + 'Seleccione una ciudad...' + '</option>');
    			$.each(data, function(i, optionHtml){	
  	            $('#ciudad').append('<option value="">' + optionHtml.nombre + '</option>');  // Recorre array e inserta opciones
  	           //       dropdown.append('<option value="' + v.id + '">' + v.name + '</option>'); Notación
  	           });
    		});
    
    $("#btn-search").prop("disabled", false);
}



function ajax_sede() {      // onchange en select boxes
	
//	var search = {}
//    search["nombre"] = $("#username").val();	
	event.preventDefault();
	$("#btn-search").prop("disabled", true);  // <<--
	
    $.ajax({
    	type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(),
    //    data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
    		}).then(function(data) {
    			$('.result').text(JSON.stringify(data, null, 1));
    			$('#sede').html('');   // Deja en blanco antes de cargar desde server
    			$('#sede').append('<option value="">' + 'Seleccione una sede...' + '</option>');
    			$.each(data, function(i, optionHtml){	
  	            $('#sede').append('<option value="">' + optionHtml.correo + '</option>');  // Recorre array e inserta opciones
  	           //       dropdown.append('<option value="' + v.id + '">' + v.name + '</option>'); Notación
  	           });
    		});
    
    $("#btn-search").prop("disabled", false);
}



function ajax_canal() {      // onchange en select boxes
	
//	var search = {}
//    search["nombre"] = $("#username").val();	
	event.preventDefault();
	$("#btn-search").prop("disabled", true);  // <<--
	
    $.ajax({
    	type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(),
    //    data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
    		}).then(function(data) {
    			$('.result').text(JSON.stringify(data, null, 1));
    			$('#canal').html('');   // Deja en blanco antes de cargar desde server
    			$('#canal').append('<option value="">' + 'Seleccione un canal...' + '</option>');
    			$.each(data, function(i, optionHtml){	
  	            $('#canal').append('<option value="">' + optionHtml.nombre + '</option>');  // Recorre array e inserta opciones
  	           //       dropdown.append('<option value="' + v.id + '">' + v.name + '</option>'); Notación
  	           });
    		});
    
    $("#btn-search").prop("disabled", false);
}



function ajax_vias() {      // onchange en select boxes
	
//	var search = {}
//    search["nombre"] = $("#username").val();	
	event.preventDefault();
	$("#btn-search").prop("disabled", true);  // <<--
	
    $.ajax({
    	type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(),
    //    data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
    		}).then(function(data) {
    			$('#vias').append('<h4>' + 'Información del canal: ' + '<h4>');
  	            $('#vias').append('<p>' + $('.result').text(JSON.stringify(data, null, 1)) + '<p>'); 

    		});
    
    $("#btn-search").prop("disabled", false);
}

