
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	$('#labgroup').dataTable().makeEditable(
			{
				sUpdateURL:"/SmartLab/updateLabGroup.neil",
				sDeleteURL: "/SmartLab/deleteLabGroup.neil",
				sAddURL: "/SmartLab/addLabGroup.neil",
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
			<h2>Lab Group</h2>

			<div class="table-responsive">
				<table id="labgroup"
					class="table">
					<thead>
						<tr>
							<th>Course</th>
							<th>Group</th>
							<th>Venue</th>
							<th>Session Start</th>
							<th>Session End</th>
							<th>Week Start</th>
							<th>Week End</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${labgroupList}" var="labgroup">
							<tr id="<c:out value="${labgroup.id}" />">
								<td><c:out value="${labgroup.course}" /></td>
								<td><c:out value="${labgroup.group}" /></td>
								<td><c:out value="${labgroup.venue}" /></td>
								<td><fmt:formatDate type="time" pattern="HH:mm:ss" value="${labgroup.session_start}" /></td>
								<td><fmt:formatDate type="time" pattern="HH:mm:ss" value="${labgroup.session_end}" /></td>
								<td><c:out value="${labgroup.week_start}" /></td>
								<td><c:out value="${labgroup.week_end}" /></td>
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
 <form id="formAddNewRow" action="#" title="Add New Lab Group">
	<input type="text" name="course" id="course" class="required" rel="0" class="form-control" placeholder="Course" style="margin: 5px;"/><br />
	<input type="text" name="group" id="group" class="required" rel="1" class="form-control" placeholder="Group" style="margin: 5px;"/><br />
	<input type="text" name="venue" id="venue" class="required" rel="2" class="form-control" placeholder="Venue" style="margin: 5px;"/><br />
	<input type="text" name="session_start" id="session_start" class="required" rel="3" class="form-control" placeholder="Session Start" style="margin: 5px;"/><br />
	<input type="text" name="session_end" id="session_end" class="required" rel="4" class="form-control" placeholder="Session End" style="margin: 5px;"/><br />
	<input type="text" name="week_start" id="week_start" class="required" rel="5" class="form-control" placeholder="Week Start" style="margin: 5px;"/><br />
	<input type="text" name="week_end" id="week_end" class="required" rel="6" class="form-control" placeholder="Week End" style="margin: 5px;"/><br />
</form>
</div>
<!-- /#page-wrapper -->
