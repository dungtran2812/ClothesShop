 <%-- 
    Document   : checkout
    Created on : Oct 12, 2023, 4:14:02 PM
    Author     : truon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Page</title>
    </head>
    <body>
        <c:if test ="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>
        <h1>Checkout Page</h1>
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID" required=""/> <br>
            Name <input type="text" name="name" required=""/> <br>
            Phone <input type="tel" name="phone" required=""/> <br>
            Address <input type="text" name="address" required=""/> <br>
            <input type="submit" name="action" value="Purchase"/>
        </form>
    </body>
</html>
