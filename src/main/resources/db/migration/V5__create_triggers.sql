CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_products_updated_at
    BEFORE UPDATE ON products
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

CREATE OR REPLACE FUNCTION validate_stock_before_order()
RETURNS TRIGGER AS $$
DECLARE
v_stock INTEGER;
BEGIN
SELECT stock_quantity INTO v_stock
FROM products
WHERE id = NEW.product_id;

IF v_stock < NEW.quantity THEN
        RAISE EXCEPTION 'Insufficient stock for product ID %. Available: %, Requested: %',
            NEW.product_id, v_stock, NEW.quantity;
END IF;

RETURN NEW;
END;
$$ LANGUAGE plpgsql;

