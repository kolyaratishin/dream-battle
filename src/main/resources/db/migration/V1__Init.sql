-- Користувачі
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    balance_drc BIGINT DEFAULT 0,
    role VARCHAR(20) DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT now()
);

-- Ідеї
CREATE TABLE ideas (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    image_url TEXT,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT now()
);

-- Батли
CREATE TABLE battles (
    id SERIAL PRIMARY KEY,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    winner_idea_id INT REFERENCES ideas(id),
    status VARCHAR(20) DEFAULT 'ACTIVE'
);

-- Голосування (інвестиції)
CREATE TABLE investments (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    idea_id INT REFERENCES ideas(id) ON DELETE CASCADE,
    battle_id INT REFERENCES battles(id) ON DELETE CASCADE,
    amount_drc BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT now()
);

-- Транзакції
CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    type VARCHAR(50) NOT NULL,
    amount BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT now()
);
