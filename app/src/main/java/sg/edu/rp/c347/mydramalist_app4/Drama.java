package sg.edu.rp.c347.mydramalist_app4;

import java.io.Serializable;

public class Drama implements Serializable {

    private int id;
    private String dramaTitle;
    private String dramaDescription;
    private String dramaReleaseDate;

    public Drama(int id, String dramaTitle, String dramaDescription, String dramaReleaseDate) {
        this.id = id;
        this.dramaTitle = dramaTitle;
        this.dramaDescription = dramaDescription;
        this.dramaReleaseDate = dramaReleaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDramaTitle() {
        return dramaTitle;
    }

    public void setDramaTitle(String dramaTitle) {
        this.dramaTitle = dramaTitle;
    }

    public String getDramaDescription() {
        return dramaDescription;
    }

    public void setDramaDescription(String dramaDescription) {
        this.dramaDescription = dramaDescription;
    }

    public String getDramaReleaseDate() {
        return dramaReleaseDate;
    }

    public void setDramaReleaseDate(String dramaReleaseDate) {
        this.dramaReleaseDate = dramaReleaseDate;
    }

    @Override
    public String toString() {
        return dramaTitle;
    }
}
