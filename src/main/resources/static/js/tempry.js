/**
 * 
 */
$(document).ready(function(){
	
	$('.table .eBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(data,status){
			$('.myForm #id').val(data.id);
			$('.myForm #fname').val(data.fname);
			$('.myForm #NIC').val(data.NIC);
			$('.myForm #DOB').val(data.DOB);
			$('.myForm #pro').val(data.pro);
			$('.myForm #address').val(data.address);
			$('.myForm #nat').val(data.nat);
			$('.myForm #gender').val(data.gender);
			$('.myForm #email').val(data.email);
			$('.myForm #pass').val(data.pass);
			
		});
		$('.myForm #exampleModal').modal();
		
	});
	
	$('.table .delBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href',href);
		$('#myModal').modal();
		
	});
});