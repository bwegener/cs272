package edu.orangecoastcollege.cs272.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.orangecoastcollege.cs272.model.DBModel;

public class TestDBModel {

	private static final String DB_NAME = "cs272_test.db";
	private static final String TABLE_NAME = "player";
	private static final String[] FIELD_NAMES = {"id", "name", "strength", "dexterity", "intellect", "health", "equipment"};
	private static final String[] FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "TEXT"};

	private static DBModel db;

	private String[] values;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		db = new DBModel(DB_NAME, TABLE_NAME, FIELD_NAMES, FIELD_TYPES);
	}

	@Before
	public void setUp() throws Exception {
		values = new String[] {"1", "Brian", "8", "7", "10", "25", "sword"};
	}

	@After
	public void tearDown() throws Exception {
		db.deleteAllRecords();
	}

    @Test
    public void testGetAllRecords()
    {
        try
        {
            db.getAllRecords();
        }
        catch (SQLException e)
        {
            fail("Getting all records on empty database should not generate SQLException");
        }
    }

    @Test
    public void testGetRecord()
    {
        try
        {
            db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length));
            assertTrue("Before deletion, count should be positive", db.getRecordCount() > 0);
            db.getRecord(FIELD_NAMES[1]);
        }
        catch (SQLException e)
        {
            fail("Getting record on empty database should not generate SQLException");
        }
    }

    @Test
    public void testGetRecordCount()
    {
        try
        {
        	db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length));
        	assertEquals("Testing to see if record count is 1 after creating a record.", 1, db.getRecordCount());
        	db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length));
        	assertEquals("Testing to see if record count is 2 after creating a record.", 2, db.getRecordCount());
        	db.deleteRecord("1");
        	assertEquals("Testing to see if record count is 1 after deleting a record.", 1, db.getRecordCount());
        	db.deleteRecord("2");
        	assertEquals("Testing to see if record count is 0 after deleting a record.", 0, db.getRecordCount());
        }
        catch(SQLException e)
        {
            fail("Getting record count should not generate SQLException");
        }
    }

    @Test
    public void testCreateRecord()
    {
        try
        {
            assertEquals("Testing creation of player with id provided", 1, db.createRecord(FIELD_NAMES, values));
            assertEquals("Testing the count of records", 1, db.getRecordCount());
        }
        catch (SQLException e)
        {
            fail("Creation of records should not generate SQLException");
        }

        try
        {
            db.createRecord(FIELD_NAMES, values);
            fail("Creating a record with a duplicate id should generate a SQLException.");
        }
        catch (SQLException e)
        {
            // Expected
        }
    }

    @Test
    public void testUpdateRecord()
    {
        try
        {
            db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length));
            assertTrue("Update should be successful", db.updateRecord("1", Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length)));
            assertFalse("Update should be successful", db.updateRecord("1", FIELD_NAMES, Arrays.copyOfRange(values, 1, values.length)));
            assertTrue("Update of id that does not exist should return true", db.updateRecord("10", Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length)));
        }
        catch (SQLException e)
        {
            fail("Update of records should not generate SQLException");
        }

    }

    @Test
    public void testDeleteAllRecords()
    {
        try
        {
            db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length));
            assertTrue("Before deletion, count should be positive", db.getRecordCount() > 0);
            db.deleteAllRecords();
            assertEquals("Count after deletion should be 0.", 0, db.getRecordCount());
        }
        catch (SQLException e)
        {
            fail("Deletion should not generate an SQLException.");
        }
    }

    @Test
    public void testDeleteRecord()
    {
        try
        {
            db.createRecord(Arrays.copyOfRange(FIELD_NAMES,  1,  FIELD_NAMES.length), Arrays.copyOfRange(values,  1, values.length));
            assertTrue("Before deletion, count should be positive", db.getRecordCount() > 0);
            db.deleteRecord("1");
            assertEquals("Count after deletion should be 0.", 0, db.getRecordCount());
            }
        catch (SQLException e)
        {
            fail("Deletion should not generate an SQLException.");
        }
    }

}
