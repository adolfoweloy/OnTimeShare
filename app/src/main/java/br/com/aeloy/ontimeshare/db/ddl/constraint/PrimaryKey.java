package br.com.aeloy.ontimeshare.db.ddl.constraint;

/**
 * Created by hastronauta on 1/2/16.
 */
class PrimaryKey extends Constraint {

    @Override
    public String createConstraintDefinition() {
        return "PRIMARY KEY";
    }

}
