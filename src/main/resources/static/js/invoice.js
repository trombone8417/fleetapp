/**
 * 
 */

$('document').ready(function() {	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(invoice, status){
			$('#idEdit').val(invoice.id);
			$('#ddlClientEdit').val(invoice.clientid);			
			
			var invoiceDate = invoice.invoiceDate.substr(0,10);
			$('#invoiceDateEdit').val(invoiceDate);
			$('#ddlStatusEdit').val(invoice.invoicestatusid);
			$('#remarksEdit').val(invoice.remarks);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		debugger;
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(inv, status){
			$('#idDetails').val(inv.id);
			$('#ddlClientDetails').val(inv.clientid);			
			
			var invoiceDate = inv.invoiceDate.substr(0,10);
			$('#invoiceDateDetails').val(invoiceDate);
			$('#ddlInvoiceStatusDetails').val(inv.invoicestatusid);
			$('#remarksDetails').val(inv.remarks);
			$('#lastModifiedByDetails').val(inv.lastModifiedBy);
			$('#lastModifiedDateDetails').val(inv.lastModifiedDate);
		
		});
		$('#invoiceDateDetails').attr("disabled", true); 	
		$('#ddlInvoiceStatusDetails').attr("disabled", true); 	
			
		$('#ddlClientDetails').attr("disabled", true); 			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});