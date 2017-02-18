function checkInputs() {
	var error = false;
	
    if (document.ownerForm.lastname.value == "") {
    	alert("Please enter your last name");
    	error = true;
    }
    
    if (document.ownerForm.firstname.value == "") {
    	alert("Please enter your first name");
    	error = true;
    }
    
    return !error;
}