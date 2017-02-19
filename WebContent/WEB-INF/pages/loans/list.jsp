<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tags:default-page>
    <jsp:attribute name="title">
    	Polytech Lyon - List of all registered loans
    </jsp:attribute>
    
    <jsp:attribute name="page_title">
    	Registered loans
    </jsp:attribute>
    
    <jsp:attribute name="header_content">
    </jsp:attribute>
    
    <jsp:attribute name="body_content">
    	<table class="table table-striped">
			<thead>
				<tr>
					<th>Details</th>
					<th>Member</th>
					<th>Loan Artwork</th>
					<th>Loan Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach items="${loans}" var="loan">
					<tr>
						<td><a href="LoanController?action=overview&memberId=${loan.member.id}&loanArtworkId=${loan.loanArtwork.id}&loanDate=${loan.date}">Overview</a></td>
						<td>${loan.member.lastname} ${loan.member.firstname}</td>
						<td>${loan.loanArtwork.title}</td>
						<td>${loan.date}</td>
						<td>
							<a class="btn btn-warning" href="LoanController?action=updateForm&memberId=${loan.member.id}&loanArtworkId=${loan.loanArtwork.id}&loanDate=${loan.date}" role="button"><i class="glyphicon glyphicon-pencil"></i></a>
							<a class="btn btn-danger" href="LoanController?action=delete&memberId=${loan.member.id}&loanArtworkId=${loan.loanArtwork.id}&loanDate=${loan.date}" role="button"><i class="glyphicon glyphicon-remove"></i></a>
						</td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
    </jsp:attribute>
    
    <jsp:attribute name="footer_content">
    </jsp:attribute>
</tags:default-page>