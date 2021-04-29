$('document').ready(function() {
	$('table #editButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(sta,status){
			$('#idEdit').val(sta.id);
			$('#ddlCountryEdit').val(sta.countryid);
			$('#capitalEdit').val(sta.capital);
			$('#codeEdit').val(sta.code);
			$('#nameEdit').val(sta.name);
			$('#detailsEdit').val(sta.details);
			
		});
		$('#editModal').modal();
	});
	$('table #detailButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(sta,status){
			$('#idDetail').val(sta.id);
			$('#ddlCountryDetail').val(sta.countryid);
			$('#capitalDetail').val(sta.capital);
			$('#codeDetail').val(sta.code);
			$('#nameDetail').val(sta.name);
			$('#detailsDetail').val(sta.details);
			
		});
		$('#ddlCountryDetail').attr("disabled", true); 
		$('#detailModal').modal();
	});
	
	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();
		
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href',href);
		$('#deleteModal').modal();
	});
});