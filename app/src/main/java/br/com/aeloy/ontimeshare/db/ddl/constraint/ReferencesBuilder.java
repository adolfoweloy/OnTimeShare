package br.com.aeloy.ontimeshare.db.ddl.constraint;

import android.text.TextUtils;

/**
 * Created by hastronauta on 1/2/16.
 */
public class ReferencesBuilder {
    private String columns;

    public ReferencesBuilder(String[] columns) {
        this.columns = TextUtils.join(", ", columns);
    }

    public References fromTable(String tableName) {
        References references = new References();
        references.setTableName(tableName);
        references.setColumns(columns);

        return references;
    }
}
