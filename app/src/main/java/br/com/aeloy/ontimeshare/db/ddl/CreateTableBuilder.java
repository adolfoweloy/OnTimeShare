package br.com.aeloy.ontimeshare.db.ddl;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hastronauta on 1/2/16.
 */
public class CreateTableBuilder {
    private CreateTable createTable;

    CreateTableBuilder(CreateTable createTable) {
        this.createTable = createTable;
    }

    public String build() {
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        sb.append(createTable.getTableName());
        sb.append(" (");

        List<String> columnDefinitions = new ArrayList<>();
        for (ColumnDefinition column : createTable.getColumns()) {
            columnDefinitions.add(column.createColumnDefinition());
        }

        sb.append(TextUtils.join(", ", columnDefinitions));

        sb.append(")");
        return sb.toString();
    }

    public CreateTable and() {
        return createTable;
    }


}
