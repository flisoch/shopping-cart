


// let departure = $("#departure").val();
//todo:define which cart to add

function addToCart(productId, cartId) {
    cartId = 1;
    $.ajax({
        url: `/cart/${cartId}/new`,
        type:"POST",
        data: {
            "product_id": productId,

        },
        success: function (msg) {
            alert("successfully added to cart");
        },
        error: function (msg) {
            alert('error');
        }
    });
}

function removeFromCart(productId){
    let cartId = 1;
    // let product = $("#product_" + productId);
    $.ajax({
        url: `/cart/${cartId}/remove`,
        type:"POST",
        data: {
            "product_id": productId,
        },
        success: function (msg) {
            alert("successfully removed from cart");
        },
        error: function (msg) {
            alert('error');
        }
    });
}

function updateCart(productId) {
    let cartId = 1;
    // let product = $("#product_" + productId);
    let count = 1;
    $.ajax({
        url: `/cart/${cartId}/update`,
        type:"POST",
        data: {
            "product_id": productId,
            "product_count": count,
        },
        success: function (msg) {
            alert("cart successfully updated");
        },
        error: function (msg) {
            alert('error');
        }
    });
}