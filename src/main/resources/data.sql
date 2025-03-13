INSERT INTO item (name)
VALUES
    ('Margherita'),
    ('Pepperoni');
--     ('Special'),
--     ('Fungi');

INSERT INTO size (name)
VALUES
    ('Small'),
    ('Medium'),
    ('Large');

INSERT INTO price (price, item_id, size_id)
VALUES
    (3.99, 1, 1),
    (5.99, 1, 2),
    (7.99, 1, 3),
    (4.42, 2, 1),
    (6.52, 2, 2),
    (8.62, 2, 3);
--     (8.99, 3, 1),
--     (9.99, 3, 2),
--     (10.99, 3, 3),
--     (11.99, 4, 1),
--     (22.99, 4, 2),
--     (13.99, 4, 3);