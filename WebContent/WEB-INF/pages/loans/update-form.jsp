<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Update a loan
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Update a loan
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/js/loan-form.js" var="js_loan_form" />
	    <script src="${js_loan_form}"></script>
	    
    	<form name="loanForm" method="post" action="LoanController?action=update" onsubmit="return checkInputs()">
    		<div class="form-group">
				<label for="memberId">Member</label>
				<input type="hidden" class="form-control" id="memberId" name="memberId" value="${loan.member.id}">
				<input type="text" class="form-control" value="${loan.member.lastname} ${loan.member.firstname}" readonly>
		    </div>
		    <div class="form-group">
				<label for="loanArtworkId">Loan Artwork</label>
				<input type="hidden" class="form-control" id="loanArtworkId" name="loanArtworkId" value="${loan.loanArtwork.id}">
				<input type="text" class="form-control" value="${loan.loanArtwork.title}" readonly>
		    </div>
		    <div class="form-group">
				<label for="loanDate">Loan Date</label>
				<input type="date" class="form-control" id="loanDate" name="loanDate" value="${loan.date}" readonly>
		    </div>
		    <div class="form-group">
				<label for="duration">Duration</label>
				<input type="number" class="form-control" id="duration" name="duration" placeholder="Enter your duration" value="${loan.duration}">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>