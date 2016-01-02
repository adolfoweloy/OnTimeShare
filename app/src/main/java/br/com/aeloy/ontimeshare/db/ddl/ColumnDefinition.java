package br.com.aeloy.ontimeshare.db.ddl;

import java.util.ArrayList;
import java.util.List;

import br.com.aeloy.ontimeshare.db.ddl.constraint.Constraint;

/**
 * Created by hastronauta on 1/2/16.
 */
public class ColumnDefinition {
    private CreateTableBuilder builder;
    private List<Constraint> constraints = new ArrayList<>();
    private String fieldName;
    private String fieldType;

    ColumnDefinition(CreateTableBuilder createTableBuilder, String fieldName) {
        this.builder = createTableBuilder;
        this.fieldName = fieldName;
    }

    public CreateTableBuilder ofType(String fieldType) {
        this.fieldType = fieldType;
        return builder;
    }

    public ColumnDefinition withConstraints(Constraint... constraints) {
        for (Constraint c : constraints) {
            this.constraints.add(c);
        }

        return this;
    }

    private String getFieldName() {
        return fieldName;
    }

    private String getFieldType() {
        return fieldType;
    }

    String createColumnDefinition() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFieldName());
        sb.append(" ");
        sb.append(getFieldType());

        for (Constraint constraint : constraints) {
            sb.append(constraint.build());
        }

        return sb.toString();
    }

}
