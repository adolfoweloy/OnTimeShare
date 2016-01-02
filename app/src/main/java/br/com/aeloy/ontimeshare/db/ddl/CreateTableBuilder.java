package br.com.aeloy.ontimeshare.db.ddl;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import br.com.aeloy.ontimeshare.db.ddl.ColumnDefinition;
import br.com.aeloy.ontimeshare.db.ddl.CreateTable;

/**
 * Created by hastronauta on 1/2/16.
 */
class CreateTableBuilder {
    private CreateTable createTableScript;

    CreateTableBuilder(CreateTable createTableScript) {
        this.createTableScript = createTableScript;
    }

    public String build() {
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        sb.append(createTableScript.getTableName());
        sb.append(" (");

        List<String> columnDefinitions = new ArrayList<>();
        for (ColumnDefinition column : createTableScript.getColumns()) {
            columnDefinitions.add(column.createColumnDefinition());
        }

        sb.append(TextUtils.join(", ", columnDefinitions));

        sb.append(")");
        return sb.toString();
    }

    public CreateTable and() {
        return createTableScript;
    }


}
