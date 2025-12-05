
package com.jspiders.project.bms;

import jakarta.persistence.*;



@Entity
@Table(name = "movie")
public class Movie extends BaseEntity{

    @Id//PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Use AI
    private Long id;

    @Column(name = "title",nullable = false,length = 100)
    private String title;

    @Column(name = "language",nullable = false,length = 75)
    private String language;

    @Column(name = "duration",nullable = false)
    private Integer duration;

    @Column(name = "certification",nullable = false,length = 5)
    private String certification;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private MovieStatus status;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "metaid") //fk
//    private Movie_MetaData movieMetaData;
//
//    public Movie_MetaData getMovieMetaData() {
//        return movieMetaData;
//    }
//
//    public void setMovieMetaData(Movie_MetaData movieMetaData) {
//        this.movieMetaData = movieMetaData;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public MovieStatus getStatus() {
        return status;
    }

    public void setStatus(MovieStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", duration=" + duration +
                ", certification='" + certification + '\'' +
                ", status=" + status +
                '}';
    }

}
