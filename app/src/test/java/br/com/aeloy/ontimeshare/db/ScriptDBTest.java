package br.com.aeloy.ontimeshare.db;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import br.com.aeloy.ontimeshare.BuildConfig;

import static org.junit.Assert.assertEquals;

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
        database.execSQL("insert into time_entry (time_entry_id, date, hours) values (1, '2015-01-01', 3)");

        String[] columns = {
                TimeEntryContract.TimeEntry.COLUMN_NAME_HOURS
        };

        Cursor cursor = database.query(
                TimeEntryContract.TimeEntry.TABLE_NAME, columns, null, null, null, null, null);

        int count = cursor.getCount();

        assertEquals(1, count);
    }
}