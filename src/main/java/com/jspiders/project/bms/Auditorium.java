package com.jspiders.project.bms;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "audi")
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "audi_name")
    private String name;

    @Column(name = "audi_seat_rows")
    private Integer seatrows;

    @Column(name = "audi_seat_columns")
    private Integer seatcolumns;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid",referencedColumnName = "id")
    private AudiAddress audiAddress;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "audi_id")
    private List<Shows> shows=new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "propertiseid",referencedColumnName = "id")
    private AuditoriumProperstise auditoriumProperstise;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatrows() {
        return seatrows;
    }

    public void setSeatrows(Integer seatrows) {
        this.seatrows = seatrows;
    }

    public Integer getSeatcolumns() {
        return seatcolumns;
    }

    public void setSeatcolumns(Integer seatcolumns) {
        this.seatcolumns = seatcolumns;
    }

    public AudiAddress getAudiAddress() {
        return audiAddress;
    }

    public void setAudiAddress(AudiAddress audiAddress) {
        this.audiAddress = audiAddress;
    }

    public List<Shows> getShows() {
        return shows;
    }

    public void setShows(List<Shows> shows) {
        this.shows = shows;
    }

    public AuditoriumProperstise getAuditoriumProperstise() {
        return auditoriumProperstise;
    }

    public void setAuditoriumProperstise(AuditoriumProperstise auditoriumProperstise) {
        this.auditoriumProperstise = auditoriumProperstise;
    }
}