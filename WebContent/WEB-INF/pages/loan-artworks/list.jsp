<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - List of all registered loan artworks
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Registered loan artworks
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
    	<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach items="${loanArtworks}" var="loanArtwork">
					<tr>
						<td><a href="LoanArtworkController?action=overview&id=${loanArtwork.id}">${loanArtwork.id}</a></td>
						<td>${loanArtwork.title}</td>
						<td>
							<a class="btn btn-warning" href="LoanArtworkController?action=updateForm&id=${loanArtwork.id}" role="button"><i class="glyphicon glyphicon-pencil"></i></a>
							<a class="btn btn-danger" href="LoanArtworkController?action=delete&id=${loanArtwork.id}" role="button"><i class="glyphicon glyphicon-remove"></i></a>
						</td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>