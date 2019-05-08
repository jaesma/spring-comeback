<%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 5/8/2019
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.jaesma.util.AttributeNames" %>
<html>
<head>
    <title>Add Items</title>
</head>
<body>
    <div align="center">
        <form:form method="POST">
            <modelAttribute>${AttributeNames.TODO_ITEM}</modelAttribute>

        </form:form>
    </div>
</body>
</html>
