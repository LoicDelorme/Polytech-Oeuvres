<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Update a purchase
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Update a purchase
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/js/purchase-form.js" var="js_purchase_form" />
	    <script src="${js_purchase_form}"></script>
	    
    	<form name="purchaseForm" method="post" action="PurchaseController?action=update" onsubmit="return checkInputs()">
    		<div class="form-group">
				<label for="ownerId">Owner</label>
				<input type="hidden" class="form-control" id="ownerId" name="ownerId" value="${purchase.owner.id}">
				<input type="text" class="form-control" value="${purchase.owner.lastname} ${purchase.owner.firstname}" readonly>
		    </div>
		    <div class="form-group">
				<label for="saleArtworkId">Sale Artwork</label>
				<input type="hidden" class="form-control" id="saleArtworkId" name="saleArtworkId" value="${purchase.saleArtwork.id}">
				<input type="text" class="form-control" value="${purchase.saleArtwork.title}" readonly>
		    </div>
		    <div class="form-group">
		   		<input type="hidden" class="form-control" id="oldPurchaseStatusId" name="oldPurchaseStatusId" value="${purchase.status.id}">
				<label for="newPurchaseStatusId">State</label>
				<select class="form-control" id="newPurchaseStatusId" name="newPurchaseStatusId">
					<core:forEach items="${purchaseStatus}" var="purchaseStatus_">
						<core:choose>
							<core:when test="${purchaseStatus_.id == purchase.status.id}">
								<option value="${purchaseStatus_.id}" selected>${purchaseStatus_.label}</option>
							</core:when>
							<core:otherwise>
								<option value="${purchaseStatus_.id}">${purchaseStatus_.label}</option>
							</core:otherwise>
						</core:choose>
					</core:forEach>
				</select>
		    </div>
		    <div class="form-group">
				<label for="purchaseDate">Purchase Date</label>
				<input type="date" class="form-control" id="purchaseDate" name="purchaseDate" value="${purchase.date}">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>