$('document').ready(function() {
	$('table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(location,status){
			$('#idEdit').val(location.id);
			$('#descriptionEdit').val(location.description);
			$('#cityEdit').val(location.city);
			$('#addressEdit').val(location.address);
			$('#ddlStateEdit').val(location.stateid);
			$('#ddlCountryEdit').val(location.countryid);
			$('#detailsEdit').val(location.details);
		});
		$('#editModal').modal();
	});
	$('table #detailButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(location,status){
			$('#idDetail').val(location.id);
			$('#descriptionDetail').val(location.description);
			$('#cityDetail').val(location.city);
			$('#addressDetail').val(location.address);
			$('#ddlStateDetail').val(location.stateid);
			$('#ddlCountryDetail').val(location.countryid);
			$('#detailsDetail').val(location.details);
			
		});
		$('#ddlStateDetail').attr("disabled", true); 
		$('#ddlCountryDetail').attr("disabled", true); 
		debugger;
		$('#detailModal').modal();
	});
	
	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();
		
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href',href);
		$('#deleteModal').modal();
	});
});