package br.com.aeloy.ontimeshare.db.ddl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateTable {

    private final String tableName;
    private List<ColumnDefinition> columns = new ArrayList<>();
    private CreateTableBuilder builder;

    public CreateTable(String tableName) {
        this.tableName = tableName;
        this.builder = new CreateTableBuilder(this);
    }

    public ColumnDefinition addColumn(String fieldName) {
        ColumnDefinition column = new ColumnDefinition(builder, fieldName);
        columns.add(column);
        return column;
    }

    public String getTableName() {
        return tableName;
    }

    public List<ColumnDefinition> getColumns() {
        return Collections.unmodifiableList(columns);
    }
}
