select cart_id from CART_PRODUCTS
where name = "milk" and cart_id in (select cart_id from CART_PRODUCTS where name = "yogurt")