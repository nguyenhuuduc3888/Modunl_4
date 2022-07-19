package all.model;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    private int id;
    private String musicName;
    private String personName;
    private String rentMusic;
    private String link;

    public Player() {
    }

    public Player(int id, String musicName, String personName, String rentMusic, String link) {
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