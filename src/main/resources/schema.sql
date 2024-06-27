DROP TABLE IF EXISTS azerty, qwerty, cat, positions, messages, fish;

CREATE TABLE azerty (
    id INT,
    username TEXT,
    email TEXT,
    password TEXT,
    firstname TEXT,
    lastname TEXT
);

CREATE TABLE qwerty (
    id INT,
    username TEXT,
    email TEXT,
    password TEXT,
    firstname TEXT,
    lastname TEXT,
    social_account TEXT
);

CREATE TABLE fish (
    id INT,
    admin_id INT,
    question TEXT,
    answer TEXT
);

CREATE TABLE cat (
    id INT,
    follower_id INT,
    following_id INT
);

CREATE TABLE positions (
    id INT,
    latitude FLOAT,
    longitude FLOAT,
    recorded_at DATE,
    user_id INT
);

CREATE TABLE messages (
    id INT,
    message TEXT,
    author_id INT,
    recipient_id INT,
    send_at DATE
);