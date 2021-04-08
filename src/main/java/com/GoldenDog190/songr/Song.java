package com.GoldenDog190.songr;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    public String songTitle;
    public int songLength;
    public int trackNumber;

    @ManyToOne
    Album album;

    public Song(String songTitle, int songLength, int trackNumber, Album album){
        this.songTitle = songTitle;
        this.songLength = songLength;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public Song(){};


    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public int getSongLength() {
        return songLength;
    }

    public void setSongLength(int songLength) {
        this.songLength = songLength;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }



}
