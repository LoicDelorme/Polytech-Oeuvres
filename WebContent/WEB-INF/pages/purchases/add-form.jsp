<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Add a purchase
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Add a purchase
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/js/purchase-form.js" var="js_purchase_form" />
	    <script src="${js_purchase_form}"></script>
	    
    	<form name="purchaseForm" method="post" action="PurchaseController?action=insert" onsubmit="return checkInputs()">
			<div class="form-group">
				<label for="ownerId">Owner</label>
				<select class="form-control" id="ownerId" name="ownerId">
					<core:forEach items="${owners}" var="owner">
						<option value="${owner.id}">${owner.lastname} ${owner.firstname}</option>
					</core:forEach>
				</select>
		    </div>
		    <div class="form-group">
				<label for="saleArtworkId">Sale Artwork</label>
				<select class="form-control" id="saleArtworkId" name="saleArtworkId">
					<core:forEach items="${saleArtworks}" var="saleArtwork">
						<option value="${saleArtwork.id}">${saleArtwork.title}</option>
					</core:forEach>
				</select>
		    </div>
		    <div class="form-group">
				<label for="purchaseStatusId">Purchase Status</label>
				<select class="form-control" id="purchaseStatusId" name="purchaseStatusId">
					<core:forEach items="${purchaseStatus}" var="purchaseStatus_">
						<option value="${purchaseStatus_.id}">${purchaseStatus_.label}</option>
					</core:forEach>
				</select>
		    </div>
		    <div class="form-group">
				<label for="purchaseDate">Purchase Date</label>
				<input type="date" class="form-control" id="purchaseDate" name="purchaseDate">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>