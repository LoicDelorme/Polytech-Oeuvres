<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Update a member
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Update a member
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
	    <core:url value="/js/member-form.js" var="js_member_form" />
	    <script src="${js_member_form}"></script>
	    
    	<form name="memberForm" method="post" action="MemberController?action=update" onsubmit="return checkInputs()">
    		<div class="form-group">
				<input type="hidden" class="form-control" id="id" name="id" value="${member.id}">
		    </div>
			<div class="form-group">
				<label for="lastname">Last name</label>
				<input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter your last name" value="${member.lastname}">
		    </div>
		    <div class="form-group">
				<label for="firstname">First name</label>
				<input type="text" class="form-control" id="firstname" name="firstname" placeholder="Enter your first name" value="${member.firstname}">
		    </div>
		    <div class="form-group">
				<label for="address">Address</label>
				<input type="text" class="form-control" id="address" name="address" placeholder="Enter your address" value="${member.address}">
		    </div>
		    <div class="form-group">
				<label for="zipcode">Zipcode</label>
				<input type="number" class="form-control" id="zipcode" name="zipcode" placeholder="Enter your zipcode" value="${member.zipcode}">
		    </div>
		    <div class="form-group">
				<label for="city">City</label>
				<input type="text" class="form-control" id="city" name="city" placeholder="Enter your city" value="${member.city}">
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>