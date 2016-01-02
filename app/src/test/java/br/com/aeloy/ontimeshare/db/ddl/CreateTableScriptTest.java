package br.com.aeloy.ontimeshare.db.ddl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import br.com.aeloy.ontimeshare.BuildConfig;
import br.com.aeloy.ontimeshare.db.ddl.constraint.Constraints;

import static br.com.aeloy.ontimeshare.db.ddl.constraint.Constraints.primaryKey;
import static br.com.aeloy.ontimeshare.db.ddl.constraint.Constraints.references;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class CreateTableScriptTest {

    @Test
    public void shouldCreateAValidDDLScriptForTableCreation() {
        String tableName = "time_entry";

        String generatedCreateTable = new CreateTable(tableName)
                .addColumn("id").withConstraints(primaryKey()).ofType("integer")
            .and()
                .addColumn("name").ofType("varchar(10)")
            .build();

        String createTable =
                "CREATE TABLE time_entry (id integer PRIMARY KEY, name varchar(10))";


        Assert.assertEquals(createTable, generatedCreateTable);
    }

    @Test
    public void shouldCreateScriptForCreateTableWithForeignKeyConstraint() {
        String timeEntryTable = "time_entry";
        String commentTable = "comment_table";

        String result = new CreateTable(timeEntryTable)
                .addColumn("id").withConstraints(primaryKey()).ofType("integer")
                .and()
                .addColumn("comment_id").withConstraints(references("id").fromTable(commentTable))
                .ofType("integer")
                .build();

        String expected =
                "CREATE TABLE time_entry (id integer PRIMARY KEY, comment_id integer REFERENCES comment_table(id))";

        Assert.assertEquals(expected, result);
    }
}

