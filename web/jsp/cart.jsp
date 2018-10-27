<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <script src="https://use.fontawesome.com/c560c025cf.js"></script>


    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/card.css">
    <script src="/static/js/jquery-3.3.1.min.js" defer></script>
    <script src="/static/js/bootstrap.bundle.min.js" defer></script>
    <script src="/static/js/bootstrap.min.js"    defer></script>
    <script src="/static/js/shop.js"    defer></script>


    <style>
      
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
                <a class="navbar-brand" href="/shop">Shop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

            </div>
        </nav>
    </div>

    <!-- /NAVBAR -->

    <div class="container"></div>
        <div class="card">

          <div class="card-body">

                <c:if test="${products!=null}">
                    <c:forEach var="product" items="${products}">

                        <div class="row" id="product_${product.id}">
                            <div class="col-xs-2 col-md-2">
                                <img class="img-responsive" src="http://placehold.it/120x80" alt="prewiew">
                            </div>
                            <div class="col-xs-4 col-md-6">
                                <h4 class="product-name"><strong>${product.name}</strong></h4>
                                <h4><small>${product.description}</small></h4>
                            </div>
                            <div class="col-xs-6 col-md-4 row">
                                <div class="col-xs-2 col-md-6 text-right" style="padding-top: 5px">
                                    <h6><strong>$ ${product.price}  <span class="text-muted"> x </span></strong></h6>
                                </div>
                                <div class="col-xs-2 col-md-4">
                                    <input type="number" id="product_${product.id}_number" class="form-control input-sm" value="${cart.productsCount.get(product.id)}" onchange="updateCart(${product.id},${cart.id})">
                                </div>
                                <div class="col-xs-2 col-md-2">
                                    <button type="button" class="btn btn-outline-danger btn-xs" onclick="removeFromCart(${product.id},${cart.id})">
                                        <i class="fa fa-trash" aria-hidden="true"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <hr>

                    </c:forEach>
                </c:if>



              <hr>
              <div class="pull-right">
                  <a href="#" class="btn btn-outline-secondary pull-right">Aktualizovať košík</a>
              </div>
          </div>
          <div class="card-footer">
              <a href="#" class="btn btn-success pull-right">Objednať</a>
              <div class="pull-right" style="margin: 5px">
                  Celková cena: <b>50.00€</b>
              </div>
          </div>
      </div>
      
  </body>
</html>
