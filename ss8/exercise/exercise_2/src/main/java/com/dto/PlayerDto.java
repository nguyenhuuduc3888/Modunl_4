package com.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PlayerDto {
    private int id;

    @NotEmpty(message = "Khong duoc de trong")
    private String musicName;
    @NotEmpty(message = "Khong duoc de trong")
    private String personName;
    @NotEmpty(message = "Khong duoc de trong")
    private String rentMusic;
    @NotBlank(message = "Khong duoc de trong")
    private String link;

    public PlayerDto() {
    }

    public PlayerDto(int id, String musicName, String personName, String rentMusic, String link) {
        this.id = id;
        this.musicName = musicName;
        this.personName = personName;
        this.rentMusic = rentMusic;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getRentMusic() {
        return rentMusic;
    }

    public void setRentMusic(String rentMusic) {
        this.rentMusic = rentMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
