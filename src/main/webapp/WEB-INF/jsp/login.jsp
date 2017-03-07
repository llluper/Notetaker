<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div c:if="${param.error}" class="alert alert-error">
                    Invalid username and password.
                </div>
                <div c:if="${param.logout}" class="alert alert-success">
                    You have been logged out.
                </div>
	<form:form name="f" action="/login" method="post">
		<p>Name : <input type="text" name="username" id="username"/></p>
		<p>Password : <input type="password" name="password" id="password"/></p>
		<input type="submit" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>
