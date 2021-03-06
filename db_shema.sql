CREATE DATABASE movieland;
CREATE TABLE users
(
    user_id   INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    mail      VARCHAR(250) NOT NULL UNIQUE,
    password  VARCHAR(250) NOT NULL
);
CREATE TABLE genres
(
    genre_id   INT AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(250) NOT NULL UNIQUE
);
CREATE TABLE movies
(
    movie_id      INT AUTO_INCREMENT PRIMARY KEY,
    nameRussian   VARCHAR(250) NOT NULL,
    nameNative    VARCHAR(250),
    yearOfRelease INT,
    description   TEXT,
    rating        FLOAT,
    price         DECIMAL(5, 2)
);
CREATE TABLE movies_genres
(
    movies_genres INT AUTO_INCREMENT PRIMARY KEY,
    movie_id      INT,
    genre_id      INT,
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres (genre_id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE production_country
(
    country_id   INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(250) NOT NULL UNIQUE
);
CREATE TABLE movies_countries
(
    movies_countries INT AUTO_INCREMENT PRIMARY KEY,
    movie_id         INT,
    country_id       INT,
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (country_id) REFERENCES production_country (country_id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE posters
(
    posters_id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id   INT,
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON UPDATE CASCADE ON DELETE CASCADE,
    urlPoster  VARCHAR(400) NOT NULL
);
CREATE TABLE reviews
(
    review_id   INT AUTO_INCREMENT PRIMARY KEY,
    movie_id    INT(250),
    user_id     INT(250),
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON UPDATE CASCADE ON DELETE SET NULL,
    reviewMovie TEXT NOT NULL
);
DROP DATABASE movieland2;
CREATE DATABASE movieland2;