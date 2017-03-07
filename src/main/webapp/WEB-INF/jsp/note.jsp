<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" commandName="note">
		<hidden path="id" />
		<fieldset class="form-group">
			<form:label path="title">Title</form:label>
			<form:input path="title" type="text" class="form-control"
				required="required" />
			<form:errors path="title" cssClass="text-warning" />
			<form:label path="body">Body</form:label>
			<form:input path="body" type="text" class="form-control"
				required="required" />
			<form:errors path="body" cssClass="text-warning" />
			<form:label path="label">Label</form:label>
			<form:input path="label" type="text" class="form-control"
				required="required" />
			<form:errors path="label" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>
