CREATE TABLE IF NOT EXISTS Exercise
(
    id          BIGSERIAL PRIMARY KEY,
    user_id     BIGINT       NOT NULL,
    description TEXT         NOT NULL,
    "type"      VARCHAR(255) NOT NULL,
    start_time  timestamp    NOT NULL,
    duration    INT          NOT NULL,
    calories    DOUBLE PRECISION
);