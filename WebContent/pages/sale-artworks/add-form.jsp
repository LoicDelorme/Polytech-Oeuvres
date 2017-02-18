<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Add a sale artwork
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Add a sale artwork
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/js/sale-artwork-add-form.js" var="js_sale_artwork_add_form" />
	    <script src="${js_sale_artwork_add_form}"></script>
	    
    	<form name="saleArtworkForm" method="post" action="" onsubmit="return checkInputs()">
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" id="title" placeholder="Enter your title">
		    </div>
		    <div class="form-group">
				<label for="artworkStateId">Artwork state</label>
				<select class="form-control" id="artworkStateId">
					<option>1</option>
					<core:forEach items="${artworkStates}" var="artworkState">
						<option value="${artworkState.id}">${artworkState.label}</option>
					</core:forEach>
				</select>
		    </div>
		    <div class="form-group">
				<label for="price">Price</label>
				<input type="number" class="form-control" id="price" placeholder="Enter your price">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>