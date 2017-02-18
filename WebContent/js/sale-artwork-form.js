function checkInputs() {
	var error = false;
	
    if (document.saleArtworkForm.title.value == "") {
    	alert("Please enter a title");
    	error = true;
    }
    
    if (document.saleArtworkForm.state.value == "") {
    	alert("Please enter a state");
    	error = true;
    }
    
    if (document.saleArtworkForm.price.value == "") {
    	alert("Please enter a price");
    	error = true;
    }
    
    return !error;
}