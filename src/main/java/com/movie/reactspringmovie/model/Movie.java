package com.movie.reactspringmovie.model;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private String rating;

    @Column(name = "genre")
    private String genre;

    @Column(name = "image")
    private String imageUrl;

    @Column(name = "releaseDate")
    private String releaseDate;

    @Column(name = "overview", columnDefinition = "TEXT")
    private String overview;



    public Movie() {
    }

    public Movie(long id, String imageUrl, String overview, String releaseDate, String rating, String title, String genre) {
        this.id = id;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.title = title;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
