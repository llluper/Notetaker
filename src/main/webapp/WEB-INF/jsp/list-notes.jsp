<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<table class="table table-striped">
			<caption>Your notes are</caption>
			<thead>
				<tr>
					<th>ID</th>
                    <th>Title</th>
					<th>Body</th>
					<th>Label</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
                <c:forEach items="${notes}" var="note">
                    <tr>
                        <td>${note.id}</td>
                        <td>${note.title}</td>
                        <td>${note.body}</td>
						<td>${note.label}</td>
                        <td><a type="button" class="btn btn-success"
                            href="/update-note?id=${note.id}">Update</a></td>
                        <td><a type="button" class="btn btn-warning"
                            href="/delete-note?id=${note.id}">Delete</a></td>
                    </tr>
                </c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-note">Add a Note</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>
