<%-- 
    Document   : viewcart
    Created on : Oct 6, 2023, 10:58:48 AM
    Author     : truon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.shopping.Cart"%>
<%@page import="sample.shopping.Clothes"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
        <link rel="stylesheet" href="css/viewcartCss.css">
    </head>
    <body>
        <c:if test ="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>
        <h1>Your selected clothes</h1>
        <c:if test="${sessionScope.CART != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Edit</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var = "total" scope = "request" value="${0}"/>
                    <c:forEach var="cloth" varStatus="counter" items="${sessionScope.CART.getCart().values()}">
                    <form action="MainController" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                <input type="text" name="id" value="${cloth.getId()}" readonly=""/>
                            </td>
                            <td>${cloth.getName()}</td>
                            <td>${cloth.getPrice()}</td>
                            <td>
                                <input type="number" name="quantity" value="${cloth.getQuantity()}" min="1" required=""/>
                            </td>
                            <td>${cloth.getPrice()*cloth.getQuantity()}</td>
                            <td>
                                <input type="submit" name="action" value="Edit"/>
                            </td>
                            <td>
                                <input type="submit" name="action" value="Remove"/>
                            </td>
                        </tr>
                    </form>
                    <c:set var = "total" scope = "request" value="${total+cloth.getPrice()*cloth.getQuantity()}"/>
                </c:forEach>
            </tbody>
        </table>
        <h1>Total: ${total} $</h1>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Checkout"/>
        </form>
        
         
    </c:if>
        <h2><c:out value="${requestScope.CHECKOUT_MESSAGE}" /></h2>
        <h2><c:out value="${requestScope.QUANTITY_MESSAGE}" /></h2>
    <br><a href="MainController?action=Shopping_Page">Add More</a>
</body>
</html>
