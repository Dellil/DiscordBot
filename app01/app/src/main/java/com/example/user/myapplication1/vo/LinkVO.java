package com.example.user.myapplication1.vo;

import java.util.ArrayList;

public class LinkVO {
    private String time;
    private ArrayList<String> links;

    public LinkVO(){}
    public LinkVO(String time, ArrayList<String> links) {
        this.time = time;
        this.links = links;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<String> links) {
        this.links = links;
    }
}