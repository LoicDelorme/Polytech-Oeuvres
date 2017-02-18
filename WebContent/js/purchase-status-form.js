function checkInputs() {
	var error = false;
	
    if (document.purchaseStatusForm.label.value == "") {
    	alert("Please enter your label");
    	error = true;
    }
    
    return !error;
}