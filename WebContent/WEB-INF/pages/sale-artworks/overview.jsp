<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Sale artwork overview
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Sale artwork overview
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
    	<form>
    		<div class="form-group">
    			<label for="id">ID</label>
				<input type="number" class="form-control" id="id" name="id" value="${saleArtwork.id}" readonly>
		    </div>
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" id="title" name="title" value="${saleArtwork.title}" readonly>
		    </div>
		    <div class="form-group">
				<label for="artworkState">State</label>
				<input type="text" class="form-control" id="artworkState" name="artworkState" value="${saleArtwork.state.label}" readonly>
		    </div>
		    <div class="form-group">
				<label for="price">Price</label>
				<input type="number" class="form-control" id="price" name="price" value="${saleArtwork.price}" readonly>
		    </div>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>