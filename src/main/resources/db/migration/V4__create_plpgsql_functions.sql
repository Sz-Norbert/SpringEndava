CREATE OR REPLACE FUNCTION get_total_revenue()
RETURNS NUMERIC AS $$
DECLARE
total_revenue NUMERIC;
BEGIN
SELECT COALESCE(SUM(total_price), 0) INTO total_revenue
FROM orders
WHERE status = 'COMPLETED';

RETURN total_revenue;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_product_stock(p_product_id BIGINT)
RETURNS INTEGER AS $$
DECLARE
stock INTEGER;
BEGIN
SELECT stock_quantity INTO stock
FROM products
WHERE id = p_product_id;

IF stock IS NULL THEN
        RAISE EXCEPTION 'Product with ID % not found', p_product_id;
END IF;

RETURN stock;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_low_stock_products()
RETURNS TABLE (
    product_id BIGINT,
    product_name VARCHAR,
    current_stock INTEGER,
    price NUMERIC
) AS $$
BEGIN
RETURN QUERY
SELECT id, name, stock_quantity, products.price
FROM products
WHERE stock_quantity < 10
ORDER BY stock_quantity ASC;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_products_by_price_range(
    p_min_price NUMERIC,
    p_max_price NUMERIC
)
RETURNS TABLE (
    product_id BIGINT,
    product_name VARCHAR,
    product_price NUMERIC,
    stock INTEGER
) AS $$
BEGIN
RETURN QUERY
SELECT id, name, price, stock_quantity
FROM products
WHERE price BETWEEN p_min_price AND p_max_price
ORDER BY price ASC;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_order_count_for_product(p_product_id BIGINT)
RETURNS INTEGER AS $$
DECLARE
order_count INTEGER;
BEGIN
SELECT COUNT(*) INTO order_count
FROM orders
WHERE product_id = p_product_id
  AND status = 'COMPLETED';

RETURN order_count;
END;
$$ LANGUAGE plpgsql;