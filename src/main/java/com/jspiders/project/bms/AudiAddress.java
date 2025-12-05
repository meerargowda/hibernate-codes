package com.jspiders.project.bms;

import jakarta.persistence.*;

@Entity
@Table(name = "audi_address")
public class AudiAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street_name")
    private String streetname;

    @Column(name = "area")
    private String area;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private Integer pincode;

    @OneToOne(mappedBy = "audiAddress")
    private Auditorium auditorium;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}
