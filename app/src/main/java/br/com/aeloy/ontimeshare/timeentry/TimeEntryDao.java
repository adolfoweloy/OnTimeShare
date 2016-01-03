package br.com.aeloy.ontimeshare.timeentry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.aeloy.ontimeshare.db.ScriptDB;
import br.com.aeloy.ontimeshare.db.TimeEntryContract;
import br.com.aeloy.ontimeshare.db.rowmapper.RowMapper;

/**
 * Created by hastronauta on 1/3/16.
 */
public class TimeEntryDao extends ScriptDB {

    public TimeEntryDao(Context context) {
        super(context);
    }

    public void addEntry(TimeEntry entry) {
        ContentValues values = new ContentValues();
        values.put(TimeEntryContract.TimeEntry.COLUMN_NAME_DATE, entry.getFormattedDate());
        values.put(TimeEntryContract.TimeEntry.COLUMN_NAME_HOURS, entry.getHours());

        getDb().insert(TimeEntryContract.TimeEntry.TABLE_NAME, null, values);
    }

    public List<TimeEntry> getByMonth(Month month, RowMapper<TimeEntry> mapper) {
        List<TimeEntry> entries = new ArrayList<>();

        Cursor cursor = getDb().query(
                TimeEntryContract.TimeEntry.TABLE_NAME,
                TimeEntryContract.TimeEntry.columns,
                "strftime('%m', date) = ?",
                new String[]{ month.numeric() }, null, null, "date");

        while (cursor.moveToNext()) {
            TimeEntry timeEntry = mapper.mapRow(cursor);
            entries.add(timeEntry);
        }

        return entries;
    }
}
