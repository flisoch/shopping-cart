<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: flisoch
  Date: 27.10.18
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.3.1.min.js" defer></script>
    <script src="/static/js/bootstrap.bundle.min.js" defer></script>
    <script src="/static/js/bootstrap.min.js"    defer></script>
    <script src="/static/js/shop.js"    defer></script>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        /*.card {
            display: inline-block;
            max-width: 32%;
        }*/
        body {
            margin-top: 72px;
            background-color: #f5f5f5;
        }

        #itemCount {
            position: absolute;
            top: 1px;
            left: 250px;
            width: 20px;
            height: 20px;
            border-radius: 50%;
            background: red;
            color: white;
            text-align: center;
        }

    </style>
</head>
<body>

    <!-- NAVBAR -->

    <div class="container fixed-top">
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
            <div class="container col-6">
                <a class="navbar-brand" href="/cart">Your shopping cart</a>

                <i class="fa fa-shopping-cart fa-2x col-9" aria-hidden="true" style="color:white"></i>
                <span id="itemCount">${count}</span>

            </div>

        </nav>
    </div>

    <!-- /NAVBAR -->

    <div class="container">
        <div class="row">

            <!-- CONTENT -->

            <c:forEach var="product" items="${products}">

                    <div class="card" id="product_${product.id}">
                        <h5 class="card-header">
                            <a href="/products/${product.id}">${product.id}</a>
                        </h5>

                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.description}</p>
                            <button onclick="addToCart(${product.id},${cart.id})"  class="btn btn-primary">Add to cart</button>
                        </div>
                    </div>

            </c:forEach>

            <!-- /CONTENT -->

        </div>
    </div>
</body>
</html>
