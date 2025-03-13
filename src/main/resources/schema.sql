DROP TABLE IF EXISTS price CASCADE;
DROP TABLE IF EXISTS size CASCADE;
DROP TABLE IF EXISTS item CASCADE;

CREATE TABLE item (
                      id IDENTITY PRIMARY KEY,
                      name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE size (
                      id IDENTITY PRIMARY KEY,
                      name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE price (
                       id IDENTITY PRIMARY KEY,
                       price DECIMAL(6,2) NOT NULL,
                       item_id BIGINT NOT NULL,
                       size_id BIGINT NOT NULL,
                       CONSTRAINT fk_price_item_id
                           FOREIGN KEY(item_id)
                               REFERENCES item(id)
                               ON DELETE CASCADE,
                       CONSTRAINT fk_price_size_id
                           FOREIGN KEY(size_id)
                               REFERENCES size(id)
                               ON DELETE CASCADE,
                       CONSTRAINT unique_item_size
                           UNIQUE(item_id, size_id)
);
