package com.rk.movieland.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Movie {

    private int movieId;

    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private String description;
    private float rating;
    private BigDecimal price;
    private String picturePath;

    private List<Genre> genres;
    private List<Country> countries;
    private List<Review> reviews;

    public Movie() {
    }

    public Movie(int movieId, String nameRussian, String nameNative, int yearOfRelease, String description, float rating, BigDecimal price, String picturePath, List<Genre> genres, List<Country> countries, List<Review> reviews) {
        this.movieId = movieId;
        this.nameRussian = nameRussian;
        this.nameNative = nameNative;
        this.yearOfRelease = yearOfRelease;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.picturePath = picturePath;
        this.genres = genres;
        this.countries = countries;
        this.reviews = reviews;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getNameRussian() {
        return nameRussian;
    }

    public void setNameRussian(String nameRussian) {
        this.nameRussian = nameRussian;
    }

    public String getNameNative() {
        return nameNative;
    }

    public void setNameNative(String nameNative) {
        this.nameNative = nameNative;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", nameRussian='" + nameRussian + '\'' +
                ", nameNative='" + nameNative + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", picturePath='" + picturePath + '\'' +
                ", genres=" + genres +
                ", countries=" + countries +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return movieId == movie.movieId &&
                yearOfRelease == movie.yearOfRelease &&
                Float.compare(movie.rating, rating) == 0 &&
                Objects.equals(nameRussian, movie.nameRussian) &&
                Objects.equals(nameNative, movie.nameNative) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(price, movie.price) &&
                Objects.equals(picturePath, movie.picturePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, nameRussian, nameNative, yearOfRelease, description, rating, price, picturePath);
    }
}
