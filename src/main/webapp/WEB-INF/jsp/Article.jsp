<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMS - Employee Registration</title>
<style>
td, th {
  font-family: arial, sans-serif;
}
</style>
<script type="text/javascript">
	function validate() {
		if (document.forms["article"]["description"].value == "") {
			alert("Please enter description");
			document.forms["article"]["description"].focus();
			return false;
		}
	}

</script>
</head>
<body style="background-color: #FFFFE0;">
<div style="margin-top:50px; margin-left:250px; height:50px;"><h2>Employee <c:out value="${article.articleId != null ? 'Update' : 'Article' }" /></h2></div>
<form:form method="POST" modelAttribute="article" action="/home" name="article">
<table style="vertical-align: center; margin-left:20%;">
	
	<tr>
		<td><form:hidden path="viewCount"/></td>
	</tr>
	<tr>
		<td><form:hidden path="articleId"/></td>
	</tr>
    <tr>
        <td>Author Name :</td>
        <td><form:input path="autherName" id="autherName" /></td>
    </tr>
    <tr>
        <td>Description :</td>
        <td><form:textarea path="description" id="description"/></td>
    </tr>
    <tr>
            <td>Title :</td>
            <td><form:textarea path="title" id="title"/></td>
        </tr>

    <tr>
        <td colspan="2"><input type="submit" value="<c:out value="${article.articleId != null ? 'Update' : 'Add' }" />"
         onclick="return validate();">&nbsp;&nbsp; <a href="/list">Article List</a>&nbsp;

         </td>
    </tr>
</table>
</form:form>
<form method="POST"  action="/delete?id=${article.articleId}" method="post" name='delete-form'>
						<input type="submit" value="Delete" onclick="delete()" style="background:none;border:0px;cursor: pointer;"/>
					</form>
</body>
</html>