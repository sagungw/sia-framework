$(document).ready(function() {
	var peran;
	
	$("#peranTambah").click(function() {
		if($("#peranInput").val() != "") {
			var namaPeran = $("#peranInput").val();
			
			var peran = {
					"idPeran" : null,
					"namaPeran" : namaPeran
			}; 
			
			$.ajax({
				url : "tambah/",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(peran),
				success : function(data) {
					
				}
			});
		}
	});
});