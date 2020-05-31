<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Article List</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 60%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>
</head>
<body style="background-color: #FFFFE0;">

<div style="margin-top:50px; margin-left:200px; height:50px;"><h2>Article List</h2></div>
	<table style="margin-top: 0px;margin-left: 100px; ">
		<tr>
			<th>Sr No.</th>
			<th>Auther</th>
			<th>Description</th>
			<th>Created</th>
			<th>View Count</th>

		</tr>
		<c:forEach items="${empList}" var="emp" varStatus="loop">
			<tr>
			<td>${loop.index+1}</td>
				<td>${emp.autherName}</td>
				<td>
                					<a href="/edit?id=${emp.articleId}" >
                					<c:out value="${(emp.viewCount != null and emp.viewCount > 0) ? '*' : '' }" />${emp.description}</a>
                				</td>
				<td>${emp.created}</td>
				<td>${emp.viewCount}</td>


			</tr>
		</c:forEach>
	</table>
	<div><a href="/add">Add</a></div>
</body>
</html>