INSERT INTO SHOWS (id, movie_title, theatre_name, show_time, price_cents) VALUES
 (101, 'Inception', 'Golden Village', '2025-08-26T14:00:00', 1500),
 (102, 'Inception', 'Golden Village', '2025-08-26T18:00:00', 1500),
 (103, 'Inception', 'Cathay', '2025-08-26T15:30:00', 1400);

INSERT INTO SHOW_SEAT (id, show_id, seat_number, booked) VALUES
 (1,101,'A1', false),(2,101,'A2', false),(3,101,'A3', false),(4,101,'A4', false),
 (5,102,'A1', false),(6,102,'A2', false),(7,102,'A3', false),
 (8,103,'A1', false),(9,103,'A2', false);
