package br.com.aeloy.ontimeshare.timeentry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hastronauta on 1/3/16.
 */
public class TimeEntry {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private Long id;

    private Date date;

    private int hours;

    public static Date getDateFromString(String date) throws ParseException {
        return sdf.parse(date);
    }

    public TimeEntry(Date date, int hours) {
        this.date = date;
        this.hours = hours;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getFormattedDate() {
        return sdf.format(date);
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }
}
