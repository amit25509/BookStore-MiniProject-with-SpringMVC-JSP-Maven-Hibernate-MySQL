<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>BookStore</title>
</head>
<body>
<h1 style="display: inline;">--Available Books--</h1> ${TEST }
<h2 style="display: inline; float: right;">From: ${FROM} To: ${TO}|| Total: ${TOTAL}</h2>
<table class="table table-striped container">
  <thead>
    <tr>
      <th scope="col">Book ID</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author Name</th>
      <th scope="col">Price</th>
      <th scope="col">Edition</th>
      <th scope="col">Category</th>
      <th scope="col">Publication</th>
      <th><form:form action="addBook" style="display: inline;">
      <input class="btn btn-info" type="submit" value="Add New Book">
      </form:form></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="book" items="${BOOKLIST }">
    <tr>
      <th scope="row">${book.bid}</th>
      <td>${book.bname }</td>
      <td>${book.author }</td>
      <td>${book.price }</td>
      <td>${book.edition }</td>
      <td>${book.category }</td>
      <td>${book.pub }</td>
      <td style="display: inline;">
      
      <form:form action="editBook" style="display: inline;">
      <input type="hidden" name="bookId" value="${book.bid }">
      <input class="btn btn-info" type="submit" value="Edit">
      </form:form>
      <form:form action="deleteBook" style="display: inline;">
      <input type="hidden" name="bookId" value="${book.bid }">
      <input class="btn btn-danger" type="submit" value="Delete" onclick="alert('Record Deleted Successfully')">
      </form:form>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
${showPrevious}
<!-- Pagination -->
<nav aria-label="...">
  <ul class="pagination" style="float: right; margin-right: 13%;">
  <c:if test="${showPrevious eq true }">
  <li class="page-item"><a class="page-link" href="previous">Previous</a></li>
  </c:if>
    <c:if test="${showPrevious eq false }">
  <li class="page-item disabled"><a class="page-link" href="previous">Previous</a></li>
  </c:if>
    
    <c:if test="${showNext eq true }">
    <li class="page-item"><a class="page-link" href="next">Next</a></li>
    </c:if>
    <c:if test="${showNext eq false }">
    <li class="page-item disabled"><a class="page-link" href="next">Next</a></li>
    </c:if>
  </ul>
</nav>

</body>
</html>