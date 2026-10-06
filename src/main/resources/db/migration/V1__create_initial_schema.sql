CREATE TABLE applications (
                              id BIGSERIAL PRIMARY KEY,
                              name VARCHAR(255) NOT NULL
);

CREATE TABLE items (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       status VARCHAR(20) NOT NULL,
                       application_id BIGINT NOT NULL,
                       CONSTRAINT fk_item_application
                           FOREIGN KEY (application_id)
                               REFERENCES applications(id)
);