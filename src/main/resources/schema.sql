DROP TABLE IF EXISTS std_users, admin_users, followings, positions, messages, recover_questions;

CREATE TABLE std_users (
    id INT,
    username TEXT,
    email TEXT,
    password TEXT,
    firstname TEXT,
    lastname TEXT
);

CREATE TABLE admin_users (
    id INT,
    username TEXT,
    email TEXT,
    password TEXT,
    firstname TEXT,
    lastname TEXT,
    x_account TEXT
);

CREATE TABLE recover_questions (
    id INT,
    admin_id INT,
    question TEXT,
    answer TEXT
);

CREATE TABLE followings (
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