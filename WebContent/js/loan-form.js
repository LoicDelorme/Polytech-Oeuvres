function checkInputs() {
	var error = false;
	
    if (document.loanForm.memberId.value == "") {
    	alert("Please enter a member");
    	error = true;
    }
    
    if (document.loanForm.loanArtworkId.value == "") {
    	alert("Please enter a loan artwork");
    	error = true;
    }
    
    if (document.loanForm.loanDate.value == "") {
    	alert("Please enter a loan date");
    	error = true;
    }
    
    if (document.loanForm.duration.value == "") {
    	alert("Please enter a duration");
    	error = true;
    }
    
    return !error;
}