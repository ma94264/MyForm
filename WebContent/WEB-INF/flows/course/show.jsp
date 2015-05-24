      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h2>Student</h2>
            <div class="table-responsive">
              <table class="table table-bordered table-hover table-striped tablesorter">
                <thead>
                  <tr>
                    <th>Username <i class="fa fa-sort"></i></th>
                    <th>Name <i class="fa fa-sort"></i></th>
                    <th>Course Type <i class="fa fa-sort"></i></th>
                    <th>Nationality <i class="fa fa-sort"></i></th>
                    <th>Group <i class="fa fa-sort"></i></th>
                  </tr>
                </thead>
                <tbody>
	                <c:forEach items="${studentList}" var="student">
	    				<tr>
	    					<td><c:out value="${student.username}"/></td>
	    					<td><c:out value="${student.name}"/></td>
	    					<td><c:out value="${student.course_type}"/></td>
	    					<td><c:out value="${student.nationality}"/></td>
	    					<td><c:out value="${student.groupID}"/></td>
	    				</tr>
					</c:forEach>
                </tbody>
              </table>
        
          </div>

      </div><!-- /#page-wrapper -->

