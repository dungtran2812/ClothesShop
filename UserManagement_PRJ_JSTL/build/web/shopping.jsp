<%-- 
    Document   : shopping
    Created on : Oct 6, 2023, 10:48:49 AM
    Author     : truon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dang Dung's Shop</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/shoppingPageCss.css">
    </head>
    <body>
    <c:if test ="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>
        <div>The way to luxury</div>
        <form action="MainController" method="POST">
            <select name="cmbClothes">
                <option value="B169-Leather Belt-150">Leather Belt - 150$</option>
                <option value="D389-Halloween Dress-550">Halloween Dress - 550$</option>
                <option value="G291-Sun Glasses-120.5">Sun Glasses- - 120.5$</option>
                <option value="J930-Authumn jacket-550">Authumn jacket - 550$</option>
                <option value="S173-Polo Shirt-200">Polo Shirt - 200$</option>
                <option value="SJ183-Skinny Jeans-450">Skinny Jeans - 450$</option>
                <option value="SJ493-Short Jeans-400">Short Jeans - 400$</option>
                <option value="T031-T-shirt-250">T-shirt - 250$</option>
            </select>
            <select name="cmbQuantity">
                <option value="1">1 Item</option>
                <option value="2">2 Items</option>
                <option value="3">3 Items</option>
                <option value="4">4 Items</option>
                <option value="5">5 Items</option>
                <option value="10">10 Items</option>
            </select>
            <input type="submit" name="action" value="Add"/>
        </form>
        ${requestScope.MESSAGE}
        <br><a href="MainController?action=View_Page">View Cart</a>
        <div class = productList-container>
            <div class="product-container">
                <img src="images/leatherbeltimg.jpg" alt="Product 1">
                <p class="product-description">Leather Belt-150$</p>
            </div>
            <div class="product-container">
                <img src="images/halloweendress.jpg" alt="Product 2">
                <p class="product-description">Halloween dress-550$</p>
            </div>
            <div class="product-container">
                <img src="images/sunglasses.jpg" alt="Product 3">
                <p class="product-description">Sun Glasses- - 120.5$</p>
            </div>

        
        <div class="product-container">
            <img src="images/autumnjacket.jpg" alt="Product 4">
            <p class="product-description">Authumn jacket - 550$</p>
        </div>
        
        <div class="product-container">
            <img src="images/poloshirts.jpg" alt="Product 5">
            <p class="product-description">Polo Shirt - 200$</p>
        </div>
            <div class="product-container">
            <img src="images/skinnyjean.jpg" alt="Product 6">
            <p class="product-description">Skinny Jeans - 450$</p>
        </div>
            <div class="product-container">
            <img src="images/shortjean.jpg" alt="Product 7">
            <p class="product-description">Short Jeans - 400$</p>
        </div>
            <div class="product-container">
            <img src="images/Tshirt.jpg" alt="Product 8">
            <p class="product-description">T-shirt - 250$</p>
        </div>
    </div>
    </body>
</html>
