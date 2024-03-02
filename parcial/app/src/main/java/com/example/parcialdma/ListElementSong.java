package com.example.parcialdma;

public class ListElementSong {
    private String image;
    private String songTitle;
    private String album;
    private String artist;

    public ListElementSong(String image, String songTitle, String album, String artist) {
        this.image = image;
        this.songTitle = songTitle;
        this.album = album;
        this.artist = artist;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
