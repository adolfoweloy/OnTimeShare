package br.com.aeloy.ontimeshare.db;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import br.com.aeloy.ontimeshare.BuildConfig;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static br.com.aeloy.ontimeshare.db.TimeEntryContract.*;

/**
 * Created by hastronauta on 1/2/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class ScriptDBTest {
    private ScriptDB myDb;

    @Before
    public void setUp() {
        Application applicationContext = RuntimeEnvironment.application;
        myDb = new ScriptDB(applicationContext);
    }

    @After
    public void tearDown() {
        myDb.close();
    }

    @Test
    public void shouldBeAbleToInsertDataIntoEntry() throws Exception {

        SQLiteDatabase database = myDb.getDb();
        database.execSQL("insert into time_entry (date, hours) values ('2015-01-01', 3)");

        Cursor cursor = database.query(
                TimeEntry.TABLE_NAME, TimeEntry.columns, null, null, null, null, null);

        int count = cursor.getCount();

        assertEquals(1, count);

        if (cursor.moveToNext()) {
            long timeEntryId = cursor.getLong(cursor.getColumnIndex(TimeEntry._ID));
            String date = cursor.getString(cursor.getColumnIndex(TimeEntry.COLUMN_NAME_DATE));
            int hours = cursor.getInt(cursor.getColumnIndex(TimeEntry.COLUMN_NAME_HOURS));

            assertThat(timeEntryId, is(greaterThan(0L)));
            assertEquals("2015-01-01", date);
            assertEquals(3, hours);
        }
    }
}