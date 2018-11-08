package com.sikka.randyperrone.mediafeed.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Video implements Parcelable{
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

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    protected Video(Parcel in) {
        id = in.readString();
        description = in.readString();
        url = in.readString();
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(description);
        parcel.writeString(url);
        parcel.writeString(title);
    }
}
