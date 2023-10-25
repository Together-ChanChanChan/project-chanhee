package llocr.mp3;

public class Music {
    private String title;
    private String singer;

    public Music(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }
}
