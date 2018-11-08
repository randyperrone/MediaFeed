package com.sikka.randyperrone.mediafeed.Model;

public class Video {
    private String id;
    private String description;
    private String url;
    private String title;

    public Video(String id, String description, String url, String title) {
        this.id = id;
        this.description = description;
        this.url = url;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
