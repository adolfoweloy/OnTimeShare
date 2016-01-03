package br.com.aeloy.ontimeshare.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.aeloy.ontimeshare.db.ddl.CreateTable;
import br.com.aeloy.ontimeshare.db.ddl.constraint.Constraints;

import static br.com.aeloy.ontimeshare.db.TimeEntryContract.*;

/**
 * Created by hastronauta on 1/1/16.
 */
public class ScriptDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "on_time_share.db";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase database;

    public ScriptDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public SQLiteDatabase getDb() {
        if (database == null) {
            database = getWritableDatabase();
        }

        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        List<String> tableDefinitions = new ArrayList<>(2);

        tableDefinitions.add(getTimeEntrySQLDefinition());
        tableDefinitions.add(getCommentSQLDefinition());

        for (String sql : tableDefinitions) {
            db.execSQL(sql);
        }
    }

    private String getTimeEntrySQLDefinition() {
        return new CreateTable(TimeEntry.TABLE_NAME)

            .addColumn(TimeEntry._ID)
            .withConstraints(Constraints.primaryKey())
            .ofType("integer")

            .and()
            .addColumn(TimeEntry.COLUMN_NAME_DATE)
            .ofType("date")

            .and()
            .addColumn(TimeEntry.COLUMN_NAME_HOURS)
            .ofType("TINYINT")

            .build();
    }

    private String getCommentSQLDefinition() {
        return new CreateTable(Comment.TABLE_NAME)
            .addColumn(Comment._ID)
            .withConstraints(Constraints.primaryKey())
            .ofType("integer")

            .and()
            .addColumn(Comment.COLUMN_NAME_TIME_ENTRY_ID)
            .ofType("integer")

            .and()
            .addColumn(Comment.COLUMN_NAME_CONTENT)
            .ofType("integer")

            .build();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String[] sql = {
                "DROP TABLE IF EXISTS " + Comment.TABLE_NAME,
                "DROP TABLE IF EXISTS " + TimeEntry.TABLE_NAME
        };

        for (String s : sql) {
            db.execSQL(s);
        }
    }
}
