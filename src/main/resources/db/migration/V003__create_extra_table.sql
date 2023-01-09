CREATE TABLE IF NOT EXISTS extra
(
    id          BIGSERIAL NOT NULL,
    identifier  UUID,
    description TEXT,
    order_number     INTEGER   NOT NULL,
    type        VARCHAR(255),
    exercise_id BIGINT,
    CONSTRAINT pk_extra PRIMARY KEY (id)
);

ALTER TABLE extra
    ADD CONSTRAINT FK_EXTRA_ON_EXERCISE FOREIGN KEY (exercise_id) REFERENCES exercise (id);

create unique index if not exists extra_identifier_index on extra (identifier);