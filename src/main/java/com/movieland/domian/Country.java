package com.movieland.domian;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;
    @Column(name = "country_name",nullable = false, unique = true)
    private String countryName;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
