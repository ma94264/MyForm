
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/datatable/jquery.dataTables.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/datatable/jquery-ui.css" />">
	<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/datatable/jquery-ui-1.7.2.custom.css" />">
<style type="text/css" class="init">
</style>
	
<script src="<c:url value="/resources/datatable/jquery.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/datatable/jquery.dataTables.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/datatable/jquery.jeditable.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/datatable/jquery-ui.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/datatable/jquery.validate.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/datatable/jquery.dataTables.editable.js" />" type="text/javascript"></script>	
	
<script type="text/javascript" language="javascript" class="init">


$(document).ready(function() {
	$('#student').dataTable().makeEditable(
			{
				sUpdateURL:"/SmartLab/updateStudent.neil",
				sDeleteURL: "/SmartLab/deleteStudent.neil",
				sAddURL: "/SmartLab/addStudent.neil",
				sAddNewRowButtonId: "btnAddRow"
			});
	
} );

function refreshPage(){
	window.location.replace('${flowExecutionUrl}&_eventId=refresh');
}
	</script>
</head>

<div id="page-wrapper">

	<div class="row">
		<div class="col-lg-12">
			<h2>Student</h2>

			<div class="table-responsive">
				<table id="student"
					class="table">
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
							<tr id="<c:out value="${student.username}" />">
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
<!-- Place holder where add and delete buttons will be generated -->
<div class="add_delete_toolbar"><button id="btnDeleteRow" class="btn btn-primary btn-sm">Delete</button><button id="btnAddRow" class="btn btn-primary btn-sm">Add</button></div>
<!-- Custom form for adding new records -->
 <form id="formAddNewRow" action="#" title="Add New Student">
	<input type="text" name="username" id="username" class="required" rel="0" class="form-control" placeholder="Username" style="margin: 5px;"/><br />
	<input type="text" name="name" id="name" class="required" rel="1" class="form-control" placeholder="Name" style="margin: 5px;"/><br />
	<input type="text" name="course_type" id="course_type" class="required" rel="2" class="form-control" placeholder="Course Type" style="margin: 5px;"/><br />
	<input type="text" name="nationality" id="nationality" class="required" rel="3" class="form-control" placeholder="Nationality" style="margin: 5px;"/><br />
	<input type="text" name="groupID" id="groupID" class="required" rel="4" class="form-control" placeholder="Group" style="margin: 5px;"/>    
</form>
</div>
<!-- /#page-wrapper -->
