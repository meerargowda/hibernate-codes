package com.jspiders.project.bms;

import jakarta.persistence.*;

@Entity
@Table(name = "audipro")
public class AuditoriumProperstise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "screen_type")
    private String screen;

    @Column(name = "sound")
    private String sound;

    @OneToOne(mappedBy = "auditoriumProperstise")
    private Auditorium auditorium;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}
