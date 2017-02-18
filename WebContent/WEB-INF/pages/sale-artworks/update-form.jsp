<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Update a sale artwork
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Update a sale artwork
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/js/sale-artwork-form.js" var="js_sale_artwork_form" />
	    <script src="${js_sale_artwork_form}"></script>
	    
    	<form name="saleArtworkForm" method="post" action="SaleArtworkController?action=update" onsubmit="return checkInputs()">
    		<div class="form-group">
				<input type="hidden" class="form-control" id="id" name="id" value="${saleArtwork.id}">
		    </div>
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" id="title" name="title" placeholder="Enter your title" value="${saleArtwork.title}">
		    </div>
		    <div class="form-group">
				<label for="artworkStateId">State</label>
				<select class="form-control" id="artworkStateId" name="artworkStateId">
					<core:forEach items="${artworkStates}" var="artworkState">
						<core:choose>
							<core:when test="${artworkState.id == saleArtwork.state.id}">
								<option value="${artworkState.id}" selected>${artworkState.label}</option>
							</core:when>
							<core:otherwise>
								<option value="${artworkState.id}">${artworkState.label}</option>
							</core:otherwise>
						</core:choose>
					</core:forEach>
				</select>
		    </div>
		    <div class="form-group">
				<label for="price">Price</label>
				<input type="number" class="form-control" id="price" name="price" placeholder="Enter your price" value="${saleArtwork.price}">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>