INSERT INTO app_user (name, email, password) VALUES
('John Doe', 'johndoe@example.com', 'password1'),
('Jane Smith', 'janesmith@example.com', 'password2'),
('Alice Johnson', 'alicejohnson@example.com', 'password3'),
('Bob Brown', 'bobbrown@example.com', 'password4'),
('Charlie Davis', 'charliedavis@example.com', 'password5'),
('Emily Wilson', 'emilywilson@example.com', 'password6'),
('Frank Thomas', 'frankthomas@example.com', 'password7'),
('Grace Lee', 'gracelee@example.com', 'password8'),
('Hannah White', 'hannahwhite@example.com', 'password9'),
('Ian Harris', 'ianharris@example.com', 'password10'),
('Jack Martin', 'jackmartin@example.com', 'password11'),
('Karen Young', 'karenyoung@example.com', 'password12'),
('Larry King', 'larryking@example.com', 'password13'),
('Mia Scott', 'miascott@example.com', 'password14'),
('Nathan Lewis', 'nathanlewis@example.com', 'password15'),
('Olivia Clark', 'oliviaclark@example.com', 'password16'),
('Paul Walker', 'paulwalker@example.com', 'password17'),
('Quincy Turner', 'quincyturner@example.com', 'password18'),
('Rachel Adams', 'racheladams@example.com', 'password19'),
('Sam Baker', 'sambaker@example.com', 'password20'),
('Tina Green', 'tinagreen@example.com', 'password21');

INSERT INTO user_roles (user_id, roles) VALUES
(1, 'RIDER'),
(2, 'RIDER'),
(2, 'DRIVER'),
(3, 'RIDER'),
(3, 'DRIVER'),
(4, 'RIDER'),
(4, 'DRIVER'),
(5, 'RIDER'),
(5, 'DRIVER'),
(6, 'RIDER'),
(6, 'DRIVER'),
(7, 'RIDER'),
(7, 'DRIVER'),
(8, 'RIDER'),
(8, 'DRIVER'),
(9, 'RIDER'),
(9, 'DRIVER'),
(10, 'RIDER'),
(10, 'DRIVER'),
(11, 'RIDER'),
(11, 'DRIVER'),
(12, 'RIDER'),
(12, 'DRIVER'),
(13, 'RIDER'),
(13, 'DRIVER'),
(14, 'RIDER'),
(14, 'DRIVER'),
(15, 'RIDER'),
(15, 'DRIVER'),
(16, 'RIDER'),
(16, 'DRIVER'),
(17, 'RIDER'),
(17, 'DRIVER'),
(18, 'RIDER'),
(18, 'DRIVER'),
(19, 'RIDER'),
(19, 'DRIVER'),
(20, 'RIDER'),
(20, 'DRIVER'),
(21, 'RIDER'),
(21, 'DRIVER');

INSERT INTO rider(id,user_id,rating) VALUES
(1,1,4.9);

INSERT INTO driver (id, user_id, rating, available, current_location) VALUES
(2, 2, 4.7, true, ST_GeomFromText('POINT(77.1025 28.7041)', 4326)),  -- Central point, New Delhi
(3, 3, 4.5, true, ST_GeomFromText('POINT(77.1035 28.7045)', 4326)),  -- Slightly north-east
(4, 4, 4.6, false, ST_GeomFromText('POINT(77.1010 28.7050)', 4326)),  -- Slightly north-west
(5, 5, 4.8, true, ST_GeomFromText('POINT(77.1040 28.7035)', 4326)),  -- Slightly south-east
(6, 6, 4.3, true, ST_GeomFromText('POINT(77.1005 28.7030)', 4326)),  -- Slightly south-west
(7, 7, 4.9, false, ST_GeomFromText('POINT(77.1050 28.7060)', 4326)),  -- North-east, further out
(8, 8, 4.2, true, ST_GeomFromText('POINT(77.0995 28.7065)', 4326)),  -- North-west, further out
(9, 9, 4.4, true, ST_GeomFromText('POINT(77.1060 28.7020)', 4326)),  -- South-east, further out
(10, 10, 4.1, true, ST_GeomFromText('POINT(77.0985 28.7015)', 4326)),  -- South-west, further out
(11, 11, 4.7, false, ST_GeomFromText('POINT(77.1020 28.7070)', 4326)),  -- North
(12, 12, 4.5, true, ST_GeomFromText('POINT(77.1070 28.7030)', 4326)),  -- East
(13, 13, 4.6, true, ST_GeomFromText('POINT(77.1000 28.7000)', 4326)),  -- South
(14, 14, 4.8, false, ST_GeomFromText('POINT(77.0950 28.7055)', 4326)),  -- West
(15, 15, 4.3, true, ST_GeomFromText('POINT(77.1080 28.7060)', 4326)),  -- North-east, further out
(16, 16, 4.9, true, ST_GeomFromText('POINT(77.0975 28.7025)', 4326)),  -- South-west, further out
(17, 17, 4.2, false, ST_GeomFromText('POINT(77.1045 28.7075)', 4326)),  -- North
(18, 18, 4.4, true, ST_GeomFromText('POINT(77.0990 28.7010)', 4326)),  -- South
(19, 19, 4.1, true, ST_GeomFromText('POINT(77.1100 28.7100)', 4326)),  -- North-east, furthest out within 5 km
(20, 20, 4.7, true, ST_GeomFromText('POINT(77.0955 28.6980)', 4326)),  -- South-west, furthest out within 5 km
(21, 21, 4.5, true, ST_GeomFromText('POINT(77.1020 28.7045)', 4326));  -- Very close to the central point



