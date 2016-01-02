package br.com.aeloy.ontimeshare.db.ddl.constraint;

/**
 * Created by hastronauta on 1/2/16.
 */
public abstract class Constraint {
    public String build() {
        return " " + createConstraintDefinition();
    }

    public abstract String createConstraintDefinition();
}
