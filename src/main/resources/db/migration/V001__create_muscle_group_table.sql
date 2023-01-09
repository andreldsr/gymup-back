create table if not exists muscle_group
(
    id         BIGSERIAL NOT NULL,
    identifier UUID,
    name       VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_muscle_group PRIMARY KEY (id)
);

create unique index if not exists muscle_group_identifier_index on muscle_group(identifier);