package com.hiring.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection =  "hirings")
public class Post
{
    String des;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "des='" + des + '\'' +
                ", profile='" + profile + '\'' +
                ", techs=" + Arrays.toString(techs) +
                ", exp=" + exp +
                '}';
    }

    String profile;
    String[] techs;
    int exp;
}
