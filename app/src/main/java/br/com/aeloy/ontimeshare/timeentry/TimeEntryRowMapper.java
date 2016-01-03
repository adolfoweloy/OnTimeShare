package br.com.aeloy.ontimeshare.timeentry;

import android.database.Cursor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.aeloy.ontimeshare.db.rowmapper.RowMapper;
import br.com.aeloy.ontimeshare.db.TimeEntryContract;
import br.com.aeloy.ontimeshare.db.rowmapper.RowMapperException;

/**
 * Created by hastronauta on 1/3/16.
 */
public class TimeEntryRowMapper implements RowMapper<TimeEntry> {

    @Override
    public TimeEntry mapRow(Cursor cursor) {

        Long id = cursor.getLong(cursor.getColumnIndex(TimeEntryContract.TimeEntry._ID));
        String date = cursor.getString(cursor.getColumnIndex(TimeEntryContract.TimeEntry.COLUMN_NAME_DATE));
        int hours = cursor.getInt(cursor.getColumnIndex(TimeEntryContract.TimeEntry.COLUMN_NAME_HOURS));

        try {
            Date realDate = TimeEntry.getDateFromString(date);
            TimeEntry timeEntry = new TimeEntry(realDate, hours);
            timeEntry.setId(id);

            return timeEntry;
        } catch (ParseException e) {
            throw new RowMapperException(e);
        }

    }

}
