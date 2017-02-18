<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Add a loan artwork
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Add a loan artwork
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/js/loan-artwork-form.js" var="js_loan_artwork_form" />
	    <script src="${js_loan_artwork_form}"></script>
	    
    	<form name="loanArtworkForm" method="post" action="LoanArtworkController?action=insert" onsubmit="return checkInputs()">
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" id="title" name="title" placeholder="Enter your title">
		    </div>
		    <div class="form-group">
				<label for="duration">Duration</label>
				<input type="number" class="form-control" id="duration" name="duration" placeholder="Enter your duration">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>