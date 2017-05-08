<%@ include file="common/header.jspf" %>
	<form:form id="mytextform" action="addtext" method="POST" commandName="textpad">
	<div class="container">
		<h3>
		       Add New Text
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
		(NOTE: In Description, please enter sentences ending with a '.' to calculate text complexity correctly.)
	</div>
	</form:form>
<%@ include file="common/footer.jspf" %>
