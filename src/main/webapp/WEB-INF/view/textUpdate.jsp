<%@ include file="common/header.jspf" %>
	<form:form id="mytextform" action="updateText" method="POST" commandName="textpad">
	<div class="container">
		<h3>
		       Update Text with Id: <c:out value="${textpad.id}" />
			   <form:hidden path="id" />
		</h3>

		<table class="table">
			<tbody>
				<tr>
					<td>Title.</td>	
					<td><form:input path="textTilte" />
					<form:errors path="textTilte" cssClass="error-msg" />
					</td>
				</tr>
				<tr>
					<td>Description</td>
					<td><form:textarea path="textDesc" rows="5" cols="70" />
					<form:errors path="textDesc" cssClass="error-msg" />
					</td>
				</tr>
			</tbody>
			<tr>
				<td>
						<button  type="submit" value="Save"  class="btn btn-info">Save</button>
						
				</td>	
				<td>
						<a href="${pageContext.request.contextPath}/textpadlist" class="btn btn-info"> Cancel</a>
				</td>
			</tr>
		</table>
		(In Description : Please end sentences  with a '.' to calculate text complexity accurately.)
	</div>
	</form:form>
<%@ include file="common/footer.jspf" %>
