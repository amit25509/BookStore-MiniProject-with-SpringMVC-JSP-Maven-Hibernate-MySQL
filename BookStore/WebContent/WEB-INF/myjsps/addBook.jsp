<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="saveBook" method="post" modelAttribute="mybook">

<table class="table table-dark">
<tr>
<td>Book Name</td>
<td><form:input path="bname" /></td>
</tr>

<tr>
<td>Author</td>
<td><form:input path="author" /></td>
</tr>

<tr>
<td>Price</td>
<td><form:input path="price" /></td>
</tr>

<tr>
<td>Edition</td>
<td><form:input path="edition" /></td>
</tr>

<tr>
<td>Category</td>
<td><form:input path="category" /></td>
</tr>

<tr>
<td>Publication</td>
<td><form:input path="pub" /></td>
</tr>

<tr>
<td colspan="3"><input type="submit" value="Add Book"></td>
</tr>

</table>
</form:form>
</body>
</html>