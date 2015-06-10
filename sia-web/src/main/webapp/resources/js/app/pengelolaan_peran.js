$(document).ready(function() {
	
	toastr.options = {
			  "closeButton": true,
			  "debug": false,
			  "newestOnTop": true,
			  "progressBar": false,
			  "positionClass": "toast-top-right",
			  "preventDuplicates": false,
			  "onclick": null,
			  "showDuration": "300",
			  "hideDuration": "1000",
			  "timeOut": "5000",
			  "extendedTimeOut": "1000",
			  "showEasing": "swing",
			  "hideEasing": "linear",
			  "showMethod": "fadeIn",
			  "hideMethod": "fadeOut"
			}
	
	var namaPeranLama;
	
	$("#peranTambah").click(function() {
		if($("#peranInputAdd").val() != "") {
			var namaPeran = $("#peranInputAdd").val();
			var tempData = {'namaPeran' : namaPeran };
			$.ajax({
				url : context_path + "pengelolaanPeran/tambah",
				type : "POST",
				data : tempData,
				success : function(data) {
					if(data.status == "ok") {
						toastr["success"](data.message);
						location.reload();
					}
					else
						toastr["error"](data.message);
				}
			});
		}
		else {
			toastr["error"]("isian tidak boleh kosong");
		}
	});
	
	$(".delete").click(function() {
		var element = $(this);
		var idPeran = $(this).closest("tr").attr("id");
		var namaPeran = $(this).closest("tr").children("td.nama-peran").text();
		$.ajax({
			url : context_path + "pengelolaanPeran/hapus",
			type : "POST",
			data : {
				'idPeran' : idPeran,
				'namaPeran' : namaPeran
			},
			success : function(data) {
				 $(element).closest("tr").remove();
				 toastr["success"](data.message);
			}
		});
	});
	
	var idPeranEdit;
	
	$(".edit").click(function() {
		idPeranEdit = $(this).closest("tr").attr("id");
		var namaPeran = $(this).closest("tr").children("td.nama-peran").text();
		$("#peranInputEdit").val(namaPeran);
	});
	
	$("#peranUbah").click(function() {
		if($("#peranInputEdit").val() != "") {
			var namaPeran = $("#peranInputEdit").val();
			
			$.ajax({
				url : context_path + "pengelolaanPeran/ubah",
				type : "POST",
				data : {
						'namaPeran' : namaPeran,
						'idPeran' : idPeranEdit
					},
				success : function(data) {
					if(data.status == "ok") {
						toastr["success"](data.message);
						location.reload();
					}
					else
						toastr["error"](data.message);
				}
			});
		}
		else {
			toastr["error"]("isian tidak boleh kosong");
		}
	});
});