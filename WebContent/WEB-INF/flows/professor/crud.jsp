
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
	$('#professor').dataTable().makeEditable(
			{
				sUpdateURL:"/SmartLab/updateProfessor.neil",
				sDeleteURL: "/SmartLab/deleteProfessor.neil",
				sAddURL: "/SmartLab/addProfessor.neil",
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
			<h2>Professor</h2>

			<div class="table-responsive">
				<table id="professor"
					class="table">
					<thead>
						<tr>
							<th>Username</th>
							<th>Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${professorList}" var="professor">
							<tr id="<c:out value="${professor.username}" />">
								<td><c:out value="${professor.username}" /></td>
								<td><c:out value="${professor.name}" /></td>
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
 <form id="formAddNewRow" action="#" title="Add New Professor">
	<input type="text" name="username" id="username" class="required" rel="0" class="form-control" placeholder="Username" style="margin: 5px;"/><br />
	<input type="text" name="name" id="name" class="required" rel="1" class="form-control" placeholder="Name" style="margin: 5px;"/><br />
</form>
</div>
<!-- /#page-wrapper -->
