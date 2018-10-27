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

    <style>
        .card {
            display: inline-block;
            max-width: 32%;
        }
        body {
            margin-top: 72px;
            background-color: #f5f5f5;
        }

    </style>
</head>
<body>

    <!-- NAVBAR -->

    <div class="container fixed-top">
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="/cart">Your shopping cart</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

            </div>
        </nav>
    </div>

    <!-- /NAVBAR -->

    <div class="container">
        <div class="row">

            <!-- CONTENT -->

            <div class="card" id="product_${product.id}">
                <h5 class="card-header">
                    <a href="/products/${product.id}">Product N${product.id}</a>
                </h5>

                <div class="card-body">
                    <h5 class="card-title">${product.name}Product name</h5>
                    <p class="card-text">
                        product info
                          ${product.info}

                    </p>
                    <button onclick="addToCart(${product.id})" class="btn btn-primary">Add to cart</button>
                </div>
            </div>

            <!-- /CONTENT -->

        </div>
    </div>
</body>
</html>
