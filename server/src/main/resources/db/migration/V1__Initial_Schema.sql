CREATE TABLE "user" (
    id UUID PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    locale VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
CREATE INDEX idx_user_email ON "user" (email);

CREATE TABLE group_entity (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE group_member (
    id UUID PRIMARY KEY,
    group_id UUID NOT NULL REFERENCES group_entity(id),
    user_id UUID NOT NULL REFERENCES "user"(id),
    role VARCHAR(50) NOT NULL,
    is_primary BOOLEAN DEFAULT FALSE,
    joined_at TIMESTAMP NOT NULL,
    UNIQUE(group_id, user_id)
);
CREATE INDEX idx_group_member_user ON group_member(user_id);
CREATE INDEX idx_group_member_group ON group_member(group_id);

CREATE TABLE group_invitation (
    id UUID PRIMARY KEY,
    group_id UUID NOT NULL REFERENCES group_entity(id),
    token VARCHAR(255) UNIQUE NOT NULL,
    role VARCHAR(50) NOT NULL,
    expires_at TIMESTAMP NOT NULL
);
