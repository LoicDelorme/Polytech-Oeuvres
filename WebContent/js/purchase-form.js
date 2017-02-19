function checkInputs() {
	var error = false;
	
    if (document.purchaseForm.ownerId.value == "") {
    	alert("Please enter a owner");
    	error = true;
    }
    
    if (document.purchaseForm.saleArtworkId.value == "") {
    	alert("Please enter a sale artwork");
    	error = true;
    }
    
    if (document.purchaseForm.purchaseStatus.value == "") {
    	alert("Please enter a status");
    	error = true;
    }
    
    if (document.purchaseForm.purchaseDate.value == "") {
    	alert("Please enter a purchase date");
    	error = true;
    }
    
    return !error;
}