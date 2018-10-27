



function addToCart(productId, cartId) {

    var itemCount = $('#itemCount').html();
    itemCount ++;
    $('#itemCount').html(itemCount).css('display', 'block');

    $.ajax({
        url: `/cart/update/${cartId}`,
        type:"POST",
        data: {
            "product_id": productId,
            "cart_id" : cartId,
        },
        success: function (msg) {
            // alert("successfully added to cart");
        },
        error: function (msg) {
            alert('error');
        }
    });
}

function removeFromCart(productId,cartId){

    let product = $("#product_" + productId);
    $.ajax({
        url: `/cart/delete/${cartId}`,
        type:"POST",
        data: {
            "product_id": productId,
            "cart_id": cartId,
        },
        success: function (msg) {
            product.remove();
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
            // alert("cart successfully updated");
        },
        error: function (msg) {
            alert('error');
        }
    });
}