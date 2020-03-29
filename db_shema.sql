CREATE TABLE users
(
    user_id   INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    mail      VARCHAR(250) UNIQUE,
    password  VARCHAR(250) NOT NULL
);

CREATE TABLE genres
(
    genre_id   INT AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(250) NOT NULL UNIQUE
);

CREATE TABLE movies
(
    movie_id         INT AUTO_INCREMENT PRIMARY KEY,
    rusName          VARCHAR(250) NOT NULL UNIQUE,
    enName           VARCHAR(250) NOT NULL,
    yearOfIssue      INT,
    briefDescription TEXT,
    rating           FLOAT,
    price            DECIMAL(5, 2)
);
#TODO: check attributes in linked tables("ON DELETE NO ACTION etc.")
CREATE TABLE movies_geners
(
    movie_id INT NOT NULL,
    genre_id INT NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE NO ACTION,
    FOREIGN KEY (genre_id) REFERENCES genres (genre_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE production_country
(
    country_id   INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(250) NOT NULL UNIQUE
);

CREATE TABLE movies_countries
(
    movie_id   INT NOT NULL,
    country_id INT NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE NO ACTION,
    FOREIGN KEY (country_id) REFERENCES production_country (country_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE posters
(
    movie_id  INT,
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE NO ACTION,
    urlPoster VARCHAR(250) UNIQUE NOT NULL
);

CREATE TABLE reviews
(
    review_id   INT AUTO_INCREMENT PRIMARY KEY,
    movie_id    INT(250),
    user_id     INT(250),
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE NO ACTION,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE NO ACTION,
    reviewMovie TEXT not null
);

