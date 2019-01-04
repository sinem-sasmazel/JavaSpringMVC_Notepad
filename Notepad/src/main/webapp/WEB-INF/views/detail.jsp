<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" rel="stylesheet"/>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script crossorigin="anonymous" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-sm-6">
		<h1>User List</h1>
		<table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">name</th>
		      <th scope="col">detail</th>
		      <th scope="col">action</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <c:if test="${not empty data}"> 
		  <c:forEach items="${data}" var="item">
		    <tr>
		      <td>${item.name}</td>
		      <td>${item.detail}</td>
		      <td><a href='<s:url value="/deleteItem/${item.name}"></s:url>' class="btn btn-danger" role="button" aria-pressed="true">Delete</a></td>
		    </tr>
		    </c:forEach>
		  </c:if>			    
		    <c:if test="${data.size() == 0}"> 
		    <tr>
		    <th><p>Table is Empty!</p></th>
		    </tr>
		    </c:if>
 
		   
		  </tbody>
		</table>
		<a href='<s:url value="/"></s:url>' class="btn btn-success" role="button" aria-pressed="true">Back</a>
	</div>
</div>


</div>
</body>
</html>