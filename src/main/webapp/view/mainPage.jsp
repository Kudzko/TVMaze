<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%--<link rel="stylesheet" type="text/css" href="template_page.css">--%>
    <style type="text/css" id="gwd-text-style">
        <%@include file = "/view/slyle/style.css"%>
    </style>
    <title>test</title>
</head>
<body class="htmlNoPages">
<header>

</header>

<main>
    <div class="container">
        <form action="search" method="post">
            <button id="button_1" class="gwd-button-6g3n" type="submit"
                    name="command" value="search_command">Search
            </button>
            <input type="text" id="text_1" class="gwd-input-1xty" name="search">

            <output name="result"/>
        </form>
        <h1>Search results:</h1>
        <c:forEach var="item" items="${result}">
            <p class="gwd-p-1qcz">Score: ${item.title}</p>
            <p class="gwd-p-1tm9">Name: ${item.name}</p>
            <p class="gwd-p-pvn9">Url: <a
                    href="${item.castInformation}"> ${item.castInformation}</a>
            </p>
            <p class="gwd-p-1ro9">Birthday: ${item.birthDay}</p>
            <p class="gwd-p-10l5">Id: ${item.id}</p>
            <br/>
        </c:forEach>
    </div>
</main>
<footer>

</footer>
</body>
</html>
