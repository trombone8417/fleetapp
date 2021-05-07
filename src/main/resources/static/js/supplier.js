/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(supplier, status){
			$('#txtAddressEdit').val(supplier.address);
			$('#txtCityEdit').val(supplier.city);
			$('#ddlCountryEdit').val(supplier.countryid);
			$('#txtDetailsEdit').val(supplier.details);
			$('#txtEmailEdit').val(supplier.email);
			$('#txtIdEdit').val(supplier.id);
			$('#txtMobileEdit').val(supplier.mobile);
			$('#txtNameEdit').val(supplier.name);	
			$('#txtPhoneEdit').val(supplier.phone);			
			$('#ddlStateEdit').val(supplier.stateid);	
			$('#txtWebsiteEdit').val(supplier.website);
		});			
		
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(suppliers, status){
			$('#txtAddressDetails').val(suppliers.address);
			$('#txtCityDetails').val(suppliers.city);
			$('#ddlCountryDetails').val(suppliers.countryid);
			$('#txtDetailsDetails').val(suppliers.details);
			$('#txtEmailDetails').val(suppliers.email);
			$('#txtIdDetails').val(suppliers.id);
			$('#txtMobileDetails').val(suppliers.mobile);
			$('#txtNameDetails').val(suppliers.name);	
			$('#txtPhoneDetails').val(suppliers.phone);			
			$('#ddlStateDetails').val(suppliers.stateid);	
			$('#txtWebsiteDetails').val(suppliers.website);
		});			
		$('#ddlCountryDetails').attr("disabled", true);
		$('#ddlStateDetails').attr("disabled", true);
		$('#detailsModal').modal();		
	});
	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});