<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container down">
		<table class="table table-striped">
			<caption> </caption>
			<thead>
				<tr>
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
			<a class="button" href="/add-note">Add a new note</a>
		</div>
	</div>

<%@ include file="common/footer.jspf" %>
