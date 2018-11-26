function ajax_conexion() {      // onchange en select boxes
	

    $.ajax({
    	type: "POST",
        contentType: "application/json",
        url: "/api/conexion",
        data: JSON.stringify(),
        dataType: 'json',
        cache: false,
        timeout: 60000,
    		}).then(function(data) 
    				{	

    			$('#ipservermpls').val(data[0].ip_servidor_mpls);

    			$('#usermpls').val(data[0].usuario_mpls);

    			$('#clave1mpls').val(data[0].clave_1_mpls);

    			$('#clave2mpls').val(data[0].clave_2_mpls);

    			$('#ipserverradius').val(data[0].ip_servidor_radius);

    			$('#userradius').val(data[0].usuario_radius);

    			$('#claveradius').val(data[0].clave_radius);

    			$('#userrouter').val(data[0].usuario_router);

    			$('#claverouter').val(data[0].clave_router);

    	});
}

