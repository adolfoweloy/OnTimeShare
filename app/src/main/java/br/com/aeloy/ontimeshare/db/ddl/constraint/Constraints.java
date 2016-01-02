package br.com.aeloy.ontimeshare.db.ddl.constraint;

/**
 * Created by hastronauta on 1/2/16.
 */
public class Constraints {
    public static PrimaryKey primaryKey() {
        return new PrimaryKey();
    }

    public static ReferencesBuilder references(String firstColumn, String... remainingColumns) {
        String[] columns = new String[1 + remainingColumns.length];
        int idx = 0;
        columns[idx++] = firstColumn;

        for (String remainingColumn : remainingColumns) {
            columns[idx++] = remainingColumn;
        }

        return new ReferencesBuilder(columns);
    }
}
