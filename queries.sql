CREATE TABLE Admin (  
    id SERIAL PRIMARY KEY NOT NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE Listing (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    price INTEGER NOT NULL,
    perks TEXT,
    address TEXT NOT NULL,
    description TEXT,
    application_link TEXT,
    date TEXT NOT NULL,
    thumbnail TEXT NOT NULL,
    gallery TEXT[]
);