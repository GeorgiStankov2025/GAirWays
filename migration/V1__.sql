CREATE TABLE business_users_flights
(
    flight_id UUID NOT NULL,
    user_id   UUID NOT NULL
);

CREATE TABLE economy_users_flights
(
    flight_id UUID NOT NULL,
    user_id   UUID NOT NULL
);

CREATE TABLE flights
(
    flight_id      UUID NOT NULL,
    departure      VARCHAR(255),
    destination    VARCHAR(255),
    departure_time TIMESTAMP WITHOUT TIME ZONE,
    arrival_time   TIMESTAMP WITHOUT TIME ZONE,
    estimated_time INTEGER,
    price          DECIMAL,
    plane_id       UUID,
    CONSTRAINT pk_flights PRIMARY KEY (flight_id)
);

ALTER TABLE flights
    ADD CONSTRAINT FK_FLIGHTS_ON_PLANE FOREIGN KEY (plane_id) REFERENCES planes (plane_id);

ALTER TABLE business_users_flights
    ADD CONSTRAINT fk_bususefli_on_flight FOREIGN KEY (flight_id) REFERENCES flights (flight_id);

ALTER TABLE business_users_flights
    ADD CONSTRAINT fk_bususefli_on_user FOREIGN KEY (user_id) REFERENCES users (user_id);

ALTER TABLE economy_users_flights
    ADD CONSTRAINT fk_ecousefli_on_flight FOREIGN KEY (flight_id) REFERENCES flights (flight_id);

ALTER TABLE economy_users_flights
    ADD CONSTRAINT fk_ecousefli_on_user FOREIGN KEY (user_id) REFERENCES users (user_id);
CREATE TABLE planes
(
    plane_id          UUID NOT NULL,
    plane_model       VARCHAR(255),
    economy_capacity  INTEGER,
    business_capacity INTEGER,
    CONSTRAINT pk_planes PRIMARY KEY (plane_id)
);
CREATE TABLE users
(
    user_id       UUID NOT NULL,
    username      VARCHAR(255),
    password_hash VARCHAR(255),
    email         VARCHAR(255),
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    modified_at   TIMESTAMP WITHOUT TIME ZONE,
    user_role     SMALLINT,
    CONSTRAINT pk_users PRIMARY KEY (user_id)
);
CREATE TABLE tickets
(
    ticket_id UUID NOT NULL,
    flight_id UUID,
    user_id   UUID,
    CONSTRAINT pk_tickets PRIMARY KEY (ticket_id)
);

ALTER TABLE tickets
    ADD CONSTRAINT FK_TICKETS_ON_FLIGHT FOREIGN KEY (flight_id) REFERENCES flights (flight_id);

ALTER TABLE tickets
    ADD CONSTRAINT FK_TICKETS_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);
ALTER TABLE tickets
    ADD final_price DECIMAL;