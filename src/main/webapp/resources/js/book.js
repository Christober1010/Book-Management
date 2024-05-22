/**
 * 
 */
$(document).ready(function() {


	bookDataTable();
	var $loading = $('#loading').hide();

	$(document).ajaxStart(function() {
		$loading.show();
	}).ajaxStop(function() {
		$loading.hide();
	});

	$('#refreshPage').click(function() {
		window.location.reload();
	});

	$('#addBookDetails').click(function() {
		$("#myForm").show();
	});
	
	
	$('#saveBookDetails').click(function() {

		var id = $("#bookid").val();
		var bookName = $("#bookname").val();
		var price = $("#bookprice").val();
		var remarks = $("#remarks").val();
		
		if (bookName != "" && bookName != null && price != "" && price != null && remarks != "" && remarks != null) {
			
			var bookDetailDto = {
					"id":id,
					"bookName" : bookName,
					"price" : price,
					"remarks" : remarks,
			}
			
			if(id == ""){
			
				$.ajax({
				url : "books/saveBookDetails",
				type :"POST",
				dataType : 'json',
				contentType:"application/json",
				data : JSON.stringify(bookDetailDto),

				success : function(data) {

					if(data == true){
						swal({
							title: "",
							text: "Save Successfully.",
							type: "success",
							confirmButtonColor: '#DD6B55',
							confirmButtonText: 'Ok',
						},function(isConfirm){

							if (isConfirm){
								window.location.reload();
							} else {

							}
						});
					}
					else{

						swal({
							title: "",
							text: "Not Save",
							type: "warning",
						});
					}
				}
			});
			
			}else{
				$.ajax({
				url : "books/updateBookDetails",
				type :"POST",
				dataType : 'json',
				contentType:"application/json",
				data : JSON.stringify(bookDetailDto),

				success : function(data) {

					if(data == true){
						swal({
							title: "",
							text: "Updated Successfully.",
							type: "success",
							confirmButtonColor: '#DD6B55',
							confirmButtonText: 'Ok',
						},function(isConfirm){

							if (isConfirm){
								window.location.reload();
							} else {

							}
						});
					}
					else{

						swal({
							title: "",
							text: "Not Update",
							type: "warning",
						});
					}
				}
			});
			}


		}else{
			swal({
				title: "",
				text: "Please enter a mandatory fields",
				type: "warning",
			});

		}
	});
});






function bookDataTable() {

	$('#bookdataTable').dataTable(
		{
			//http://localhost:8082/book-mgmt/books/getAllDetails
			"ajax": {
				"url": "book/getAllDetails",
				"type": 'GET',
				"datatype": "json",
				"dataSrc": ""
			},
			"columns": [
				{
					"data": "id"
				},
				{
					"data": "bookname"
				},
				{
					"data": "price"
				},
				{
					"data": "remarks"
				}, {
					'mRender': function(data, type, row, meta) {
						var id = row.id;
						return '<a href="#" type="buttonclick" class="button" onclick="getbyID(' + id + ')">Edit</a>';
					}
				}


			],

		});

}


function getbyID(id) {

	$("#bookid").val(id);

	$.ajax({
		url: "book/getBookDetailsById",
		type: "GET",
		data: {
			'id': id,
		},
		success: function(data) {

			$("#bookname").val(data.bookname);
			$("#bookprice").val(data.price);
			$("#remarks").val(data.remarks);

			$("#saveBookDetails").val("Update");

			$("#myForm").show();

		}
	});


}

function refreshPage() {
	window.location.reload();
}

