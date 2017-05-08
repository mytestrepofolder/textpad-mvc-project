<%@ include file="common/header.jspf" %>
	<form:form id="mytextform" commandName="textpad">
	<div class="container">
		<h2>
			My Texts
		</h2>
	    Readability Score : <c:out value="${complexity}" />
		<table class="table table-striped">
			<thead>
				<tr>	
					<th>Text Title</th>
					<th>Created Date</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="obj" items="${allData}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/textById?id=${obj.id}"><c:out value="${obj.textTilte}" /></a></td>
					<td><c:out value="${obj.creationDate}" /></td>
				</tr>
			</c:forEach>			
			<tr>
				<td colspan="2" class="success-msg"><c:out value="${msg}" /></td>
			</tr>
			</tbody>
		</table>
		<div>
			<a href="${pageContext.request.contextPath}/createNew" class="btn btn-info">Create New Text</a>	
		</div>
	</div>
	
	
	</form:form>
<%@ include file="common/footer.jspf" %>
