package br.com.aeloy.ontimeshare.db.ddl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import br.com.aeloy.ontimeshare.BuildConfig;

import static br.com.aeloy.ontimeshare.db.ddl.constraint.Constraints.primaryKey;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class CreateTableScriptTest {

    @Test
    public void testShouldCreateAValidDDLScriptForTableCreation() {
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

}

