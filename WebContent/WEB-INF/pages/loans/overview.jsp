<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Loan overview
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Loan overview
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
    	<form>
    		<div class="form-group">
				<label for="memberId">Member</label>
				<input type="text" class="form-control" id="memberId" name="memberId" value="${loan.member.lastname} ${loan.member.firstname}" readonly>
		    </div>
		    <div class="form-group">
				<label for="loanArtworkId">Loan Artwork</label>
				<input type="text" class="form-control" id="loanArtworkId" name="loanArtworkId" value="${loan.loanArtwork.title}" readonly>
		    </div>
		    <div class="form-group">
				<label for="loanDate">Loan Date</label>
				<input type="date" class="form-control" id="loanDate" name="loanDate" value="${loan.date}" readonly>
		    </div>
		    <div class="form-group">
				<label for="duration">Duration</label>
				<input type="number" class="form-control" id="duration" name="duration" value="${loan.duration}" readonly>
		    </div>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>