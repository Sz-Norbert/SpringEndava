-- Stored Procedure: Place Order with stock management
-- This is the main business logic for order placement
CREATE OR REPLACE PROCEDURE place_order(
    p_product_id BIGINT,
    p_quantity INTEGER,
    OUT p_order_id BIGINT,
    OUT p_message TEXT
)
LANGUAGE plpgsql AS $$
DECLARE
v_product_name VARCHAR;
    v_price NUMERIC;
    v_stock INTEGER;
    v_total_price NUMERIC;
BEGIN
    IF p_quantity <= 0 THEN
        RAISE EXCEPTION 'Quantity must be greater than 0';
END IF;

SELECT name, price, stock_quantity
INTO v_product_name, v_price, v_stock
FROM products
WHERE id = p_product_id
    FOR UPDATE;

IF v_product_name IS NULL THEN
        RAISE EXCEPTION 'Product with ID % not found', p_product_id;
END IF;

    IF v_stock < p_quantity THEN
        RAISE EXCEPTION 'Insufficient stock for product "%". Available: %, Requested: %',
            v_product_name, v_stock, p_quantity;
END IF;

    v_total_price := v_price * p_quantity;

INSERT INTO orders (product_id, quantity, total_price, status)
VALUES (p_product_id, p_quantity, v_total_price, 'COMPLETED')
    RETURNING id INTO p_order_id;

-- Update product stock
UPDATE products
SET stock_quantity = stock_quantity - p_quantity
WHERE id = p_product_id;

p_message := format(
        'Order placed successfully! Order ID: %s, Product: %s, Quantity: %s, Total: %s RON',
        p_order_id, v_product_name, p_quantity, v_total_price
    );

    RAISE NOTICE '%', p_message;

EXCEPTION
    WHEN OTHERS THEN
        RAISE;
END;
$$;