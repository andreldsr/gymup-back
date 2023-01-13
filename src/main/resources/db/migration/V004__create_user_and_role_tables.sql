CREATE TABLE "user"
(
    id         BIGSERIAL NOT NULL,
    identifier UUID,
    name       VARCHAR(255),
    email      VARCHAR(255),
    password   TEXT,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE role
(
    id         BIGSERIAL NOT NULL,
    identifier UUID,
    name       VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    role_entity_id BIGINT NOT NULL,
    user_id       BIGINT NOT NULL
);

ALTER TABLE "user"
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_roluse_on_role_entity FOREIGN KEY (role_entity_id) REFERENCES role (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_roluse_on_user_entity FOREIGN KEY (user_id) REFERENCES "user" (id);

create unique index if not exists user_identifier_index on "user" (identifier);
create unique index if not exists role_identifier_index on role (identifier);