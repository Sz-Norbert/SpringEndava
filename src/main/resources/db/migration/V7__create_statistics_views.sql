CREATE OR REPLACE VIEW product_sales_stats AS
SELECT
    p.id AS product_id,
    p.name AS product_name,
    p.price AS unit_price,
    p.stock_quantity AS current_stock,
    COALESCE(SUM(o.quantity), 0) AS total_sold,
    COALESCE(SUM(o.total_price), 0) AS total_revenue,
    COUNT(o.id) AS order_count
FROM products p
         LEFT JOIN orders o ON p.id = o.product_id AND o.status = 'COMPLETED'
GROUP BY p.id, p.name, p.price, p.stock_quantity
ORDER BY total_revenue DESC;

CREATE OR REPLACE VIEW recent_orders AS
SELECT
    o.id AS order_id,
    o.product_id,
    p.name AS product_name,
    o.quantity,
    o.total_price,
    o.status,
    o.created_at
FROM orders o
         JOIN products p ON o.product_id = p.id
ORDER BY o.created_at DESC
    LIMIT 50;

CREATE OR REPLACE VIEW products_in_stock AS
SELECT
    id,
    name,
    description,
    price,
    stock_quantity
FROM products
WHERE stock_quantity > 0
ORDER BY name;

CREATE OR REPLACE VIEW daily_revenue AS
SELECT
    DATE(created_at) AS order_date,
    COUNT(*) AS total_orders,
    SUM(total_price) AS daily_revenue,
    AVG(total_price) AS avg_order_value
FROM orders
WHERE status = 'COMPLETED'
GROUP BY DATE(created_at)
ORDER BY order_date DESC;
s.sql        # View-uri pentru statistici