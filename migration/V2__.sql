
CREATE TABLE tickets_flights
(
    flight_id UUID NOT NULL,
    ticket_id UUID NOT NULL
);

ALTER TABLE tickets_flights
    ADD CONSTRAINT fk_ticfli_on_ticket FOREIGN KEY (ticket_id) REFERENCES tickets (ticket_id);

ALTER TABLE tickets_flights
    ADD CONSTRAINT fk_ticfli_on_flight FOREIGN KEY (flight_id) REFERENCES flights (flight_id);