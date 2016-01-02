package br.com.aeloy.ontimeshare.db.ddl.constraint;

/**
 * Created by hastronauta on 1/2/16.
 */
class References extends Constraint {

    private String tableName;
    private String columns;

    @Override
    public String createConstraintDefinition() {
        return "REFERENCES " + tableName + "(" + columns + ")";
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public String getColumns() {
        return columns;
    }
}

