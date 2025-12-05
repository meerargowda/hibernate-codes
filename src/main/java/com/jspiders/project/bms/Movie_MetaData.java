
package com.jspiders.project.bms;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_metadata")
public class Movie_MetaData extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "genere",nullable = false)
    private String genere;

    @Column(name = "formate",nullable = false)
    private String formate;

    @Column(name = "rating",nullable = false)
    private Integer rating;

    @Column(name = "releasedate")
    private String releasedate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }
}