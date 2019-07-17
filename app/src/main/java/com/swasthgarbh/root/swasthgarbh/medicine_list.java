package com.swasthgarbh.root.swasthgarbh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class medicine_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_medicine_list);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Medicines");
    }

    private String medName, comments, frequency;
    public String startDate_date, startDate_month, startDate_year, endDate_date, endDate_month, endDate_year;
    Date startDate, endDate;
    private Boolean isSOS;
    private Integer medId;

    public medicine_list (Integer id, String medName, String startDate, String endDate, String freq, String comments, Boolean isSOS) throws ParseException {

        SimpleDateFormat dateFormatterServer = new SimpleDateFormat("yyyy-MM-dd");

        this.medName = medName;
        this.frequency = freq;
        this.comments = comments;
        this.startDate = dateFormatterServer.parse(startDate);
        this.endDate = dateFormatterServer.parse(endDate);
        this.startDate_date = get_date_date(startDate);
        this.startDate_month = get_date_month(startDate);
        this.startDate_year = get_date_year(startDate);
        this.endDate_date = get_date_date(endDate);
        this.endDate_month = get_date_month(endDate);
        this.endDate_year = get_date_year(endDate);
        this.isSOS = isSOS;
        this.medId = id;
        if(isSOS){
            this.frequency = "SOS";
        }
    }

    public Integer getMedId() {
        return medId;
    }

    public String getMedName(){ return medName; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public String getComments() { return comments; }
    public String getfreq() { return frequency; }

    public Boolean getSOS() {
        return isSOS;
    }

    public String getStartDate_date(){
        return startDate_date;
    }

    public String getStartDate_month(){
        return startDate_month;
    }

    public String getStartDate_year(){
        return startDate_year;
    }

    public String getEndDate_date(){
        return endDate_date;
    }

    public String getEndDate_month(){
        return endDate_month;
    }

    public String getEndDate_year(){
        return endDate_year;
    }

    private String get_date_year(String date) {
        return date.split("-")[0];
    }

    private String get_date_month(String date) {
        String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int mon_int = Integer.parseInt(date.split("-")[1]);
        return months[mon_int];
    }



    private String get_date_date(String date) {
        return date.split("-")[2].split("T")[0];
    }

}



