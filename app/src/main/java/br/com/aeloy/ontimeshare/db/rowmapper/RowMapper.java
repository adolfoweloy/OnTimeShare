package br.com.aeloy.ontimeshare.db.rowmapper;

import android.database.Cursor;

/**
 * Created by hastronauta on 1/3/16.
 */
public interface RowMapper<T> {

    T mapRow(Cursor cursor);

}
