CREATE TABLE admin (  
    id SERIAL PRIMARY KEY NOT NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE listing (
    id SERIAL PRIMARY KEY NOT NULL,
    title TEXT,
    price INTEGER,
    perks TEXT,
    address TEXT,
    description TEXT,
    application_link TEXT,
    thumbnail TEXT,
    gallery TEXT[]
);