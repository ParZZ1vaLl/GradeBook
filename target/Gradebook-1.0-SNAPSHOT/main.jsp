<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>main page</title>
    </head>
    <body>
        <c:if test="${empty user}">
            <form action="LoginServlet" method="POST">
                Логін:
                <input type="text" name="log">
                Пароль:
                <input type="password" name="pas">
                <input type="submit" value="Увійти">
            </form>
        </c:if>
        ${error}
        <c:if test="${!empty user}">
            Hi, ${user}
            <form action="LogoutServlet" method="POST">
                <input type="submit" value="Вийти">
            </form>
            
            <c:forEach var="gb" items="${userGradebooks}">
                <form action="OpenServlet" method="GET">
                    <input type="hidden" name="id" value="${gb.getId()}" />
                    <input type="submit" value="${gb.getName()}"/>
                </form>
            </c:forEach>
        
            
        
            <c:if test="${!empty gb}">
        
                <table border="1">
                    <tr>
                        <th>Date</th>
                        <c:forEach var="user" items="${gb.getUsers()}">
                            <th>${user}</th>
                        </c:forEach>
                    </tr>
                    <c:forEach var="cw" items="${classworks}">
                        <tr>
                            <td>
                                ${cw}
                            </td>
                            <c:forEach var="grade" items="${cw.getGrades()}">
                                <td>${grade.getValue().getGrade()}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                    <c:if test="${!empty saved}">
                        <form action="SaveServlet" method="POST">
                           <tr>
                                <td>
                                    ${saved}
                                </td>
                                <c:forEach var="user" items="${gb.getUsers()}">
                                    <td>
                                        <select name="${user.getId()}">
                                            <c:forEach var="grade" items="${grades}">
                                                <option value="${grade.getId()}">
                                                    ${grade.getGrade()}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </c:forEach>
                            </tr>
                </table>
                        <input type="submit" value="Save">
                        </form>    
                    </c:if>
                <c:if test="${gb.getTeacher() == user}">
                    <form action="AddServlet" method="POST">
                        <input type="submit" value="Add">
                    </form>
                </c:if>
            </c:if>
        </c:if>
            
    </body>
</html>
