package com.sikka.randyperrone.mediafeed.Model;

public class Post {
    private String link;
    private String id;
    private String url;

    public Post(String link, String id, String url) {
        this.link = link;
        this.id = id;
        this.url = url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
