package iss.workshop.nav01.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Post {
    Integer id;
    String username;
    String post_date;
    String title;
    String description;
    String imgURL;

    public Post() {
    }

    public Post(Integer id, String username, String post_date, String title, String description, String imgURL) {
        this.id = id;
        this.username = username;
        this.post_date = post_date;
        this.title = title;
        this.description = description;
        this.imgURL = imgURL;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPost_date() {
        return post_date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
