package com.company;

public class MyDate {

    public int year;
    public String month;
    public int day;


    public MyDate()
    {
    }

    public MyDate(int year, String month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }



    @Override
    public String toString() {
        return "{" + "month=" + month + ", day=" + day + '}';
    }

}
