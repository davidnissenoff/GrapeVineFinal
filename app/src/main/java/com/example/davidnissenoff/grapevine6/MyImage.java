package com.example.davidnissenoff.grapevine6;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyImage {
    private String title, description, path;
    private long datetimeLong;
    private SimpleDateFormat df = new SimpleDateFormat("MMMM d, yy  h:mm");

    public MyImage(String title, String description, String path,
                   long datetimeLong) {
        this.title = title;
        this.description = description;
        this.path = path;
        this.datetimeLong = datetimeLong;
    }

    public MyImage() {
    }


    public String getTitle() { return title; }


    public Calendar getDatetime() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(datetimeLong);
        return cal;
    }


    public void setDatetime(long datetimeLong) {
        this.datetimeLong = datetimeLong;
    }


    public void setDatetime(Calendar datetime) {
        this.datetimeLong = datetime.getTimeInMillis();
    }


    public String getDescription() { return description; }


    public void setTitle(String title) { this.title = title; }


    public long getDatetimeLong() { return datetimeLong; }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setPath(String path) { this.path = path; }


    public String getPath() { return path; }

    @Override public String toString() {
        return  "Date and time taken: " + df.format(getDatetime().getTime());

    }
}
