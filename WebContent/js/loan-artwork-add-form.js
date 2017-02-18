function checkInputs() {
	var error = false;
	
    if (document.loanArtworkForm.title.value == "") {
    	alert("Please enter a title");
    	error = true;
    }
    
    if (document.loanArtworkForm.duration.value == "") {
    	alert("Please enter a duration");
    	error = true;
    }
    
    return !error;
}