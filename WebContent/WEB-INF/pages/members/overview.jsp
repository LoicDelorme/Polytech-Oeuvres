<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Member overview
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Member overview
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
    	<form>
    		<div class="form-group">
				<label for="id">ID</label>
				<input type="number" class="form-control" id="id" name="id" value="${member.id}" readonly>
		    </div>
			<div class="form-group">
				<label for="lastname">Last name</label>
				<input type="text" class="form-control" id="lastname" name="lastname" value="${member.lastname}" readonly>
		    </div>
		    <div class="form-group">
				<label for="firstname">First name</label>
				<input type="text" class="form-control" id="firstname" name="firstname" value="${member.firstname}" readonly>
		    </div>
		    <div class="form-group">
				<label for="address">Address</label>
				<input type="text" class="form-control" id="address" name="address" value="${member.address}" readonly>
		    </div>
		    <div class="form-group">
				<label for="zipcode">Zipcode</label>
				<input type="number" class="form-control" id="zipcode" name="zipcode" value="${member.zipcode}" readonly>
		    </div>
		    <div class="form-group">
				<label for="city">City</label>
				<input type="text" class="form-control" id="city" name="city" value="${member.city}" readonly>
		    </div>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>