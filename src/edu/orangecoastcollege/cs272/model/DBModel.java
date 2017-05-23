
package edu.orangecoastcollege.cs272.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This database which was created by Brian
 * but ammended by Khang and Duong
 * and fixed and updated by Duong
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class DBModel {
	
    private String mDBName;
    private String mTableName;
    private String[] mFieldNames;
    private String[] mFieldTypes;
    
    /**
     * This is the dbModel with a dbName, tableName, fieldNames, and fieldTypes
     * @param dbName
     * @param tableName
     * @param fieldNames
     * @param fieldTypes
     * @throws SQLException
     */
    public DBModel(String dbName, String tableName, String[] fieldNames, String[] fieldTypes) throws SQLException
    {
        super();
        mDBName = dbName;
        mTableName = tableName;
        mFieldNames = fieldNames;
        mFieldTypes = fieldTypes;
        if (mFieldNames == null || mFieldTypes == null || mFieldNames.length == 0
                || mFieldNames.length != mFieldTypes.length)
            throw new SQLException("Database field names and types must exist and have the same number of elements.");
        createTable();
    }
    
    private void createTable() throws SQLException
    {
        try (Connection connection = connectToDB(); Statement stmt = connection.createStatement();)
        {
            StringBuilder createSQL = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
            createSQL.append(mTableName).append("(");
            for (int i = 0; i < mFieldNames.length; i++)
                createSQL.append(mFieldNames[i]).append(" ").append(mFieldTypes[i])
                        .append((i < mFieldNames.length - 1) ? "," : ")");
            stmt.executeUpdate(createSQL.toString());
        }
    }
    
    /**
     * This gets all the records and closes the connection to the database when it's finished
     * @return
     * @throws SQLException
     */
    public ArrayList<ArrayList<String>> getAllRecords() throws SQLException
    {
        try (Connection connection = connectToDB();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + mTableName);)
        {
            ArrayList<ArrayList<String>> resultsList = new ArrayList<>();
            while(rs.next())
            {
                // Let's loop through each of the fields
                // Add each value to the ArrayList
                ArrayList<String> values = new ArrayList<>(mFieldNames.length);
                for(String fieldName : mFieldNames)
                {
                    values.add(rs.getString(fieldName));
                }
                // Now add the values to the 2D ArrayList
                resultsList.add(values);
            }
            return resultsList;
        }
    }
    
    /**
     * This gets a single record from the database
     * @param key
     * @return
     * @throws SQLException
     */
    public ArrayList<ArrayList<String>> getRecord(String key) throws SQLException
    {
        try (Connection connection = connectToDB();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + mTableName + " WHERE " + mFieldNames[0] + " = " + key);)
        {
            ArrayList<ArrayList<String>> resultsList = new ArrayList<>();
            while(rs.next())
            {
                // Let's loop through each of the fields
                // Add each value to the ArrayList
                ArrayList<String> values = new ArrayList<>(mFieldNames.length);
                for(String fieldName : mFieldNames)
                {
                    values.add(rs.getString(fieldName));
                }
                // Now add the values to the 2D ArrayList
                resultsList.add(values);
            }
            return resultsList;
        }
    }
    
    /**
     * This gets the record count
     * @return
     * @throws SQLException
     */
    public int getRecordCount() throws SQLException
    {
        return getAllRecords().size();
    }
    
    /**
     * This creates a record in the database
     * @param fields
     * @param values
     * @return
     * @throws SQLException
     */
    public int createRecord(String[] fields, String[] values) throws SQLException
    {
        try (Connection connection = connectToDB(); Statement stmt = connection.createStatement();)
        {
            if (fields == null || values == null || fields.length == 0 || fields.length != values.length) return -1;

            StringBuilder insertSQL = new StringBuilder("INSERT INTO ");
            insertSQL.append(mTableName).append("(");
            for (int i = 0; i < fields.length; i++)
                insertSQL.append(fields[i]).append((i < fields.length - 1) ? "," : ") VALUES(");
            for (int i = 0; i < values.length; i++)
                insertSQL.append(convertToSQLText(fields[i], values[i])).append((i < values.length - 1) ? "," : ")");

            stmt.executeUpdate(insertSQL.toString());
            return stmt.getGeneratedKeys().getInt(1);
        }
    }
    
    /**
     * This updates the record in the database
     * @param key
     * @param fields
     * @param values
     * @return
     * @throws SQLException
     */
    public boolean updateRecord(String key, String[] fields, String[] values) throws SQLException
    {
        try (Connection connection = connectToDB(); Statement stmt = connection.createStatement();)
        {
            if (fields == null || values == null || fields.length == 0 || fields.length != values.length) return false;
            
            StringBuilder updateSQL = new StringBuilder("UPDATE ");
            updateSQL.append(mTableName).append(" SET ");
            for (int i = 0; i < fields.length; i++)
                updateSQL.append(fields[i]).append(" = ").append(convertToSQLText(fields[i], values[i]))
                        .append((i < fields.length - 1) ? ", " : " ");

            updateSQL.append("WHERE ").append(mFieldNames[0]).append("=").append(key);
            stmt.executeUpdate(updateSQL.toString());
            return true;
        }
    }
    
    /**
     * This deletes all records in the database
     * @throws SQLException
     */
    public void deleteAllRecords() throws SQLException
    {
        try (Connection connection = connectToDB(); Statement stmt = connection.createStatement();)
        {
            stmt.executeUpdate("DELETE FROM " + mTableName);
        }
    }
    
    /**
     * This deletes a single record in the database
     * @param key
     * @throws SQLException
     */
    public void deleteRecord(String key) throws SQLException
    {
        try (Connection connection = connectToDB(); Statement stmt = connection.createStatement();)
        {
            stmt.executeUpdate("DELETE FROM " + mTableName + " WHERE " + mFieldNames[0] + " = " + key);
        }
    }
    
    private String convertToSQLText(String field, String value)
    {
        // Lookup the field in field names, if found, check to see if the type
        // is TEXT (if so, append ' ' around value)
        for (int i = 0; i < mFieldNames.length; i++)
        {
            if (mFieldNames[i].equals(field))
            {
                if (mFieldTypes[i].toUpperCase().startsWith("TEXT")) return "'" + value + "'";
                break;
            }
        }
        return value;
    }
    
    private Connection connectToDB() throws SQLException
    {
        // Load SQLite database classes
        try
        {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        // Establish a connection to the database and return that connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + mDBName);
        return connection;
    }
}