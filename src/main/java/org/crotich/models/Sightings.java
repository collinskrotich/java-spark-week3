package org.crotich.models;

import java.time.Instant;

public class Sightings {
    private int id;
    private int animal_id;
    private String location;
    private String timestamp;
    private String ranger_name;
    private boolean deleted=false;

    public Sightings(int animal_id, String location, String ranger_name) {
        this.animal_id = animal_id;
        this.location = location;
        this.ranger_name = ranger_name;
        this.timestamp = Instant.now().toString();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangerName() {
        return ranger_name;
    }

    public void setRangerName(String rangerName) {
        ranger_name = rangerName;
    }


}
