
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<head>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/datatable/jquery.dataTables.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/datatable/jquery-ui.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/datatable/jquery-ui-1.7.2.custom.css" />">
<style type="text/css" class="init">
</style>

<script src="<c:url value="/resources/datatable/jquery.min.js" />"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/datatable/jquery.dataTables.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/datatable/jquery.jeditable.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/datatable/jquery-ui.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/datatable/jquery.validate.js" />"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/datatable/jquery.dataTables.editable.js" />"
	type="text/javascript"></script>

<script type="text/javascript" language="javascript" class="init">


$(document).ready(function() {
	$('#labsession').dataTable().makeEditable(
			{
				sUpdateURL:"/SmartLab/updateAssessment.neil",
			});
	
} );

function refreshPage(){
	window.location.replace('${flowExecutionUrl}&_eventId=refresh');
}
function submitForm() {
    document.getElementById("myForm")._eventId_search.click();
}
	</script>
</head>

<div id="page-wrapper">

	<div class="row">
		<div class="col-lg-12">
			<h2>Assessment</h2>
			
			<sf:form modelAttribute="assessmentSearch" id="myForm">
				<sf:select path="course" onchange="javascript:submitForm();">
					<sf:option value="">Select Course</sf:option>
					<sf:option value="EE2073">EE2073</sf:option>
				</sf:select>
				<sf:select path="group" onchange="javascript:submitForm();">
					<sf:option value="">Select Group</sf:option>
					<sf:option value="PA01">PA01</sf:option>
				</sf:select>
				<sf:select path="week" onchange="javascript:submitForm();">
					<sf:option value="">Select Week</sf:option>
					<sf:option value="3">3</sf:option>
				</sf:select>
				<input type="submit" name="_eventId_search" value="Search" class="button blue small" hidden="true"/>
				<input type="hidden" name="_flowExecutionKey"
					value="${flowExecutionKey}" />
			</sf:form>
			<br />
			<div class="table-responsive">
				<table id="labsession" class="table">
					<thead>
						<tr>
							<th>Student Username</th>
							<th>Student Name</th>
							<th>Grade</th>
							<th>Remark</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${assessmentList}" var="assessment">
							<tr id="<c:out value="${assessment.id}" />">
								<td><c:out value="${assessment.student.name}" /></td>
								<td><c:out value="${assessment.grade}" /></td>
								<td><c:out value="${assessment.remark}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- /#page-wrapper -->
