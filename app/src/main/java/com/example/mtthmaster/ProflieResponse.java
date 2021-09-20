package com.example.mtthmaster;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProflieResponse {

    private String name;
    private String company;
    private String blog;
    private String location;
    private String bio;
    private int public_repos;
    private int public_gists;
    private int followers;
    private int following;
    private String avatar_url;

    public String getAvatar_url() { return avatar_url; }

    public void setAvatar_url(String avatar_url) { this.avatar_url = avatar_url; }

    // PorfileResponse의 생성자
    public ProflieResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getPublicRepos() {
        return public_repos;
    }

    public void setPublicRepos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getPublicGits() { return public_gists; }

    public void setPublicGits(int public_gists) {
        this.public_gists = public_gists;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

}
