
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
	$('#labsession').dataTable().makeEditable(
			{
				sUpdateURL:"/SmartLab/updateLabSession.neil",
				sDeleteURL: "/SmartLab/deleteLabSession.neil",
				sAddURL: "/SmartLab/addLabSession.neil",
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
			<h2>Lab Session</h2>

			<div class="table-responsive">
				<table id="labsession"
					class="table">
					<thead>
						<tr>
							<th>Professor Username</th>
							<th>Week Number (1,2,3)</th>
							<th>Course</th>
							<th>Group Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${labsessionList}" var="labsession">
							<tr id="<c:out value="${labsession.id}" />">
								<td><c:out value="${labsession.professor_username}" /></td>
								<td><c:out value="${labsession.week_number}" /></td>
								<td><c:out value="${labsession.lgo.course}" /></td>
								<td><c:out value="${labsession.lgo.group}" /></td>
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
	<input type="text" name="professor_username" id="professor_username" class="required" rel="0" class="form-control" placeholder="Professor Username" style="margin: 5px;"/><br />
	<input type="text" name="week_number" id="week_number" class="required" rel="1" class="form-control" placeholder="Week Number Ex.(1,2,3)" style="margin: 5px;"/><br />
	<input type="text" name="course" id="course" class="required" rel="2" class="form-control" placeholder="Course" style="margin: 5px;"/><br />
	<input type="text" name="group" id="group" class="required" rel="3" class="form-control" placeholder="Group Name" style="margin: 5px;"/><br />
</form>
</div>
<!-- /#page-wrapper -->
