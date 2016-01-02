package br.com.aeloy.ontimeshare.db;

import android.provider.BaseColumns;

/**
 * Created by hastronauta on 12/31/15.
 */
public class TimeEntryContract {

    public static abstract class TimeEntry implements BaseColumns {
        public static final String TABLE_NAME = "time_entry";
        public static final String COLUMN_NAME_TIME_ENTRY_ID = "time_entry_id";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_HOURS = "hours";
    }

    public static abstract class Comment implements BaseColumns {
        public static final String TABLE_NAME = "comment";
        public static final String COLUMN_NAME_COMMENT_ID = "comment_id";
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_TIME_ENTRY_ID = "time_entry_id";
    }

}
