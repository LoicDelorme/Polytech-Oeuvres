<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Purchase overview
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Purchase overview
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
    	<form>
    		<div class="form-group">
				<label for="ownerId">Owner</label>
				<input type="text" class="form-control" value="${purchase.owner.lastname} ${purchase.owner.firstname}" readonly>
		    </div>
		    <div class="form-group">
				<label for="saleArtworkId">Sale Artwork</label>
				<input type="text" class="form-control" value="${purchase.saleArtwork.title}" readonly>
		    </div>
		    <div class="form-group">
				<label for="purchaseStatusId">Purchase Status</label>
				<input type="text" class="form-control" value="${purchase.status.label}" readonly>
		    </div>
		    <div class="form-group">
				<label for="purchaseDate">Purchase Date</label>
				<input type="date" class="form-control" value="${purchase.date}" readonly>
		    </div>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>