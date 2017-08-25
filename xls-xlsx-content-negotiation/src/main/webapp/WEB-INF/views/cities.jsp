<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List of Cities</title>
</head>
<body>
<h2>List of Cities</h2>
<table>
    <tr>
        <th>Kode</th>
        <th>Nama</th>
        <th>Provinsi</th>
    </tr>
    <c:forEach var="c" items="${cities}">
        <tr>
            <td>${c.kode}</td>
            <td>${c.nama}</td>
            <td>${c.provinsi}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>