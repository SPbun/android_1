package lsj239.a2014050239lsj;

import java.io.Serializable;

public class AddItemPoint implements Serializable{
    private int imgResourceID;
    private String week;
    private String day;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getImgResourceID() {
        return imgResourceID;
    }

    public void setImgResourceID(int imgResourceID) {
        this.imgResourceID = imgResourceID;
    }

    public AddItemPoint(int imgResourceID,String week,String day){
        this.imgResourceID=imgResourceID;
        this.week=week;
        this.day=day;
    }
}

