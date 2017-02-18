function checkInputs() {
	var error = false;
	
    if (document.memberForm.lastname.value == "") {
    	alert("Please enter your last name");
    	error = true;
    }
    
    if (document.memberForm.firstname.value == "") {
    	alert("Please enter your first name");
    	error = true;
    }
    
    if (document.memberForm.address.value == "") {
    	alert("Please enter your address");
    	error = true;
    }
    
    if (document.memberForm.zipcode.value == "") {
    	alert("Please enter your zipcode");
    	error = true;
    }
    
    if (document.memberForm.city.value == "") {
    	alert("Please enter your city");
    	error = true;
    }
    
    return !error;
}