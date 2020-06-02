package sg.edu.rp.c347.mydramalist_app4;

public class Drama {

    private String dramaTitle;
    private String dramaDescription;
    private String dramaReleaseDate;

    public Drama(String dramaTitle, String dramaDescription, String dramaReleaseDate) {
        this.dramaTitle = dramaTitle;
        this.dramaDescription = dramaDescription;
        this.dramaReleaseDate = dramaReleaseDate;
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
}
