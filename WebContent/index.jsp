<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">Polytech Lyon - Features</jsp:attribute>
    
    <jsp:attribute name="page_title">Features</jsp:attribute>
    
    <jsp:attribute name="header_content"></jsp:attribute>
    
    <jsp:attribute name="body_content">
		<core:if test="${message != null}">
   			<div class="alert alert-success alert-dismissible" role="alert">
	  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  			<strong>${message}</strong>
			</div>
		</core:if>
    	
    	<ul>
			<li>
				<a href="MemberController?action=list">List all members</a>
			</li>
			<li>
				<a href="MemberController?action=addForm">Add member</a>
			</li>
			<li>
				<a href="OwnerController?action=list">List all owners</a>
			</li>
			<li>
				<a href="OwnerController?action=addForm">Add owner</a>
			</li>
			<li>
				<a href="LoanArtworkController?action=list">List all loan artworks</a>
			</li>
			<li>
				<a href="LoanArtworkController?action=addForm">Add loan artwork</a>
			</li>
			<li>
				<a href="SaleArtworkController?action=list">List all sale artworks</a>
			</li>
			<li>
				<a href="SaleArtworkController?action=addForm">Add sale artwork</a>
			</li>
			<li>
				<a href="ArtworkStateController?action=list">List all artwork states</a>
			</li>
			<li>
				<a href="ArtworkStateController?action=addForm">Add artwork state</a>
			</li>
			<li>
				<a href="PurchaseStatusController?action=list">List all purchase status</a>
			</li>
			<li>
				<a href="PurchaseStatusController?action=addForm">Add purchase status</a>
			</li>
		</ul>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content"></jsp:attribute>
</tags:default-page>