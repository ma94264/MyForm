
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/datatable/jquery.dataTables.css" />">
<style type="text/css" class="init">
</style>
<script type="text/javascript" language="javascript"
	src="<c:url value="/resources/datatable/jquery.js" />"></script>
<script type="text/javascript" language="javascript"
	src="<c:url value="/resources/datatable/jquery.dataTables.editable.js" />"></script>
<script type="text/javascript" language="javascript"
	src="<c:url value="/resources/datatable/jquery.dataTables.js" />"></script>
<script type="text/javascript" language="javascript"
	src="<c:url value="/resources/datatable/jquery.jeditable.js" />"></script>
<script type="text/javascript" language="javascript" class="init">


$(document).ready(function() {
	$('#student').dataTable().makeEditable({sUpdateURL:"/SmartLab/studentHandler.neil"});
	
} );


	</script>
</head>

<div id="page-wrapper">

	<div class="row">
		<div class="col-lg-12">
			<h2>Student</h2>
			<div class="table-responsive">
				<table id="student"
					class="table table-bordered table-hover table-striped tablesorter">
					<thead>
						<tr>
							<th>Username</th>
							<th>Name</th>
							<th>Course Type</th>
							<th>Nationality</th>
							<th>Group</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${studentList}" var="student">
							<tr id=<c:out value="${student.username}" />>
								<td><c:out value="${student.username}" /></td>
								<td><c:out value="${student.name}" /></td>
								<td><c:out value="${student.course_type}" /></td>
								<td><c:out value="${student.nationality}" /></td>
								<td><c:out value="${student.groupID}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /#page-wrapper -->
