
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
	$('#course').dataTable().makeEditable(
			{
				sUpdateURL:"/SmartLab/updateCourse.neil",
				sDeleteURL: "/SmartLab/deleteCourse.neil",
				sAddURL: "/SmartLab/addCourse.neil",
				sAddNewRowButtonId: "btnAddRow",
				sDeleteRowButtonId: "btnDeleteRow"
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
			<h2>Course</h2>

			<div class="table-responsive">
				<table id="course"
					class="table">
					<thead>
						<tr>
							<th>Course</th>
							<th>Program</th>
							<th>Class Type</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${courseList}" var="course">
							<tr id="<c:out value="${course.course}" />">
								<td><c:out value="${course.course}" /></td>
								<td><c:out value="${course.program}" /></td>
								<td><c:out value="${course.class_type}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<!-- Place holder where add and delete buttons will be generated -->
<button id="btnDeleteRow" class="btn btn-primary btn-sm">Delete</button><button id="btnAddRow" class="btn btn-primary btn-sm">Add</button>
<!-- Custom form for adding new records -->
 <form id="formAddNewRow" action="#" title="Add New Course">
	<input type="text" name="course" id="course" class="required" rel="0" class="form-control" placeholder="Course" style="margin: 5px;"/><br />
	<input type="text" name="program" id="program" class="required" rel="1" class="form-control" placeholder="Program" style="margin: 5px;"/><br />
	<input type="text" name="class_type" id="class_type" class="required" rel="2" class="form-control" placeholder="Class Type" style="margin: 5px;"/><br />
</form>
</div>
<!-- /#page-wrapper -->
