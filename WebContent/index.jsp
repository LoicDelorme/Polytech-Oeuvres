<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - Features
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Features
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
		<core:if test="${message != null}">
   			<div class="alert alert-success alert-dismissible" role="alert">
	  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  			<strong>${message}</strong>
			</div>
		</core:if>
    	
		<dl>
			<dt>Members</dt>
			<dd><a href="MemberController?action=list">List all members</a></dd>
			<dd><a href="MemberController?action=addForm">Add member</a></dd>
		</dl>
		
		<dl>
			<dt>Owners</dt>
			<dd><a href="OwnerController?action=list">List all owners</a></dd>
			<dd><a href="OwnerController?action=addForm">Add owner</a></dd>
		</dl>
		
		<dl>
			<dt>Loan Artworks</dt>
			<dd><a href="LoanArtworkController?action=list">List all loan artworks</a></dd>
			<dd><a href="LoanArtworkController?action=addForm">Add loan artwork</a></dd>
		</dl>
		
		<dl>
			<dt>Sale Artworks</dt>
			<dd><a href="SaleArtworkController?action=list">List all sale artworks</a></dd>
			<dd><a href="SaleArtworkController?action=addForm">Add sale artwork</a></dd>
		</dl>
		
		<dl>
			<dt>Artwork States</dt>
			<dd><a href="ArtworkStateController?action=list">List all artwork states</a></dd>
			<dd><a href="ArtworkStateController?action=addForm">Add artwork state</a></dd>
		</dl>
		
		<dl>
			<dt>Purchase Status</dt>
			<dd><a href="PurchaseStatusController?action=list">List all purchase status</a></dd>
			<dd><a href="PurchaseStatusController?action=addForm">Add purchase status</a></dd>
		</dl>
		
		<dl>
			<dt>Loans</dt>
			<dd><a href="LoanController?action=list">List all loans</a></dd>
			<dd><a href="LoanController?action=addForm">Add a new loan</a></dd>
		</dl>
		
		<dl>
			<dt>Purchases</dt>
			<dd><a href="PurchaseController?action=list">List all purchases</a></dd>
			<dd><a href="PurchaseController?action=addForm">Add a new purchase</a></dd>
		</dl>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>