<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - List of all registered purchases
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Registered purchases
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
    	<table class="table table-striped">
			<thead>
				<tr>
					<th>Details</th>
					<th>Owner</th>
					<th>Sale Artwork</th>
					<th>Purchase Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach items="${purchases}" var="purchase">
					<tr>
						<td><a href="PurchaseController?action=overview&ownerId=${purchase.owner.id}&saleArtworkId=${purchase.saleArtwork.id}&purchaseStatusId=${purchase.status.id}">Overview</a></td>
						<td>${purchase.owner.lastname} ${purchase.owner.firstname}</td>
						<td>${purchase.saleArtwork.title}</td>
						<td>${purchase.status.label}</td>
						<td>
							<a class="btn btn-warning" href="PurchaseController?action=updateForm&ownerId=${purchase.owner.id}&saleArtworkId=${purchase.saleArtwork.id}&purchaseStatusId=${purchase.status.id}" role="button"><i class="glyphicon glyphicon-pencil"></i></a>
							<a class="btn btn-danger" href="PurchaseController?action=delete&ownerId=${purchase.owner.id}&saleArtworkId=${purchase.saleArtwork.id}&purchaseStatusId=${purchase.status.id}" role="button"><i class="glyphicon glyphicon-remove"></i></a>
						</td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>