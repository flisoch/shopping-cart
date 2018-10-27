



function addToCart(productId, cartId) {
    $.ajax({
        url: `/cart/update/${cartId}`,
        type:"POST",
        data: {
            "product_id": productId,
            "cart_id" : cartId,
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
        url: `/cart/remove/${cartId}`,
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

function updateCart(productId, cartId) {

    let count = $(`#product_${productId}_number`).val();
    $.ajax({
        url: `/cart/update/${cartId}`,
        type:"POST",
        data: {
            "cart_id":cartId,
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