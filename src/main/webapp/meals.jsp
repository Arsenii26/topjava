<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>--%>
<html>
<head>
    <title>Meal list</title>
    <style>
        .normal {
            color: green;
        }

        .excess {
            color: red;
        }
    </style>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr/>
    <h2>Meals</h2>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
            <tr class="${meal.excess ? 'excess' : 'normal'}">
                <td>
                        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                        <%--${fn:replace(meal.dateTime, 'T', ' ')}--%>
                        ${fn:formatDateTime(meal.dateTime)}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
            </tr>
        </c:forEach>
    </table>

    <%--<c:if test="${pageContext.request.getAttribute(\"MealTo\") != null}">--%>
    <%--<table border=1>--%>
        <%--<tr align="center"><td>Название</td><td>Каллорий</td><td>Время</td></tr>--%>
            <%--<c:forEach items="${meals}" var="meal">--%>
            <%--<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>--%>
        <%--<tr bgcolor="${meal.excess ? "red" : "green"}"><td>${meal.description}</td><td>${meal.calories}</td><td>${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}</td></tr>--%>
        <%--</c:forEach>--%>
        <%--</c:if>--%>
</section>
</body>
</html>