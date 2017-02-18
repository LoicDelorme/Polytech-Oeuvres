function checkInputs() {
	var error = false;
	
    if (document.artworkStateForm.label.value == "") {
    	alert("Please enter your label");
    	error = true;
    }
    
    return !error;
}