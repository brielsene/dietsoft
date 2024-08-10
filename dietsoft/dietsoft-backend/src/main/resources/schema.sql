CREATE TABLE TB_USERS (
    id UUID DEFAULT random_uuid() PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    password_last_updated TIMESTAMP
);