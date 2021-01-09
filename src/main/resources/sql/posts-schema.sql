DROP TABLE IF EXISTS posts;

CREATE TABLE posts
(
    post_id BIGSERIAL PRIMARY KEY,
    post_message TEXT NOT NULL
);