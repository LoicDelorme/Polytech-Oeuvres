<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Update an artwork state
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Update an artwork state
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/js/artwork-state-form.js" var="js_artwork_state_form" />
	    <script src="${js_artwork_state_form}"></script>
	    
    	<form name="artworkStateForm" method="post" action="ArtworkStateController?action=update" onsubmit="return checkInputs()">
			<div class="form-group">
				<input type="hidden" class="form-control" id="id" name="id" value="${artworkState.id}">
		    </div>
			<div class="form-group">
				<label for="label">Label</label>
				<input type="text" class="form-control" id="label" name="label" placeholder="Enter your label" value="${artworkState.label}">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>