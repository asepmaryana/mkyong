<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Spring MVC Excel Pdf View</title>
</head>
<body>

<table>
    <tr>
        <th width="20px">No</th>
        <th width="50px">Name</th>
        <th width="100px">Provided By</th>
    </tr>
    <c:forEach var="c" items="${fruits}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.produceBy}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>