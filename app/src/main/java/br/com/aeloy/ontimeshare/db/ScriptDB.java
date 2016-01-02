package br.com.aeloy.ontimeshare.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hastronauta on 1/1/16.
 */
public class ScriptDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "on_time_share.db";
    private static final int DB_VERSION = 1;

    public ScriptDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] sqls = {
            "create table " + TimeEntryContract.TimeEntry.TABLE_NAME + "",
            "create table " + TimeEntryContract.Comment.TABLE_NAME + ""
        };
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
