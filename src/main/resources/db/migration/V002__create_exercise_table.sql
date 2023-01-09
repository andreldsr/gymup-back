CREATE TABLE IF NOT EXISTS exercise
(
    id          BIGSERIAL NOT NULL,
    identifier  UUID,
    name        VARCHAR(255),
    description TEXT,
    group_id    BIGINT,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_exercise PRIMARY KEY (id)
);

ALTER TABLE exercise
    ADD CONSTRAINT FK_EXERCISE_ON_GROUP FOREIGN KEY (group_id) REFERENCES muscle_group (id);

create unique index if not exists exercise_identifier_index on exercise(identifier);