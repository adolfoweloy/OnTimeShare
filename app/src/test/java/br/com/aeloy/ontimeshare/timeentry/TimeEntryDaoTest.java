package br.com.aeloy.ontimeshare.timeentry;

import android.database.Cursor;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;

import java.util.Date;

import br.com.aeloy.ontimeshare.db.ScriptDB;
import br.com.aeloy.ontimeshare.db.TimeEntryContract;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by hastronauta on 1/3/16.
 * TODO - need to learn how to create a test using content providers
 */
@Ignore
public class TimeEntryDaoTest {

    private TimeEntryDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new TimeEntryDao(RuntimeEnvironment.application);
    }

    @Test
    public void testAddEntry() throws Exception {
        TimeEntry entry = new TimeEntry(new Date(), 5);
        dao.addEntry(entry);

        ScriptDB scriptDB = new ScriptDB(RuntimeEnvironment.application);
        Cursor cursor = scriptDB.getDb().query(TimeEntryContract.TimeEntry.TABLE_NAME,
                TimeEntryContract.TimeEntry.columns,
                null, null, null, null, null);

        assertThat(cursor.getCount(), is(greaterThan(0)));
    }

    @Test
    public void testGetByMonth() throws Exception {

    }
}