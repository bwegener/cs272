package edu.orangecoastcollege.cs272.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.orangecoastcollege.cs272.model.Attack;
import edu.orangecoastcollege.cs272.model.DBModel;
import edu.orangecoastcollege.cs272.model.Enemy;
import edu.orangecoastcollege.cs272.model.Equipment;
import edu.orangecoastcollege.cs272.model.Player;
import edu.orangecoastcollege.cs272.model.Quest;
import javafx.collections.ObservableList;

public class Controller {
	
	private static Controller theOne;
	
	private static final String DB_NAME = "text_rpg.db";
	
	private static final String PLAYER_TABLE_NAME = "player";
	private static final String[] PLAYER_FIELD_NAMES = { "id", "name", "strength", "dexterity", "intellect", "health", "equipment" };
	private static final String[] PLAYER_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "TEXT" };
	
	private static final String ENEMY_TABLE_NAME = "enemy";
	private static final String[] ENEMY_FIELD_NAMES = { "id", "name", "damage", "defense", "health", "equipment"};
	private static final String[] ENEMY_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "TEXT"};
	
	private static final String ENEMY_DATA_FILE = "enemy.csv";
	
	private static final String EQUIPMENT_TABLE_NAME = "equipment";
	private static final String[] EQUIPMENT_FIELD_NAMES = { "id", "name", "damage", "defense"};
	private static final String[] EQUIPMENT_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER"};
	
	//private static final String EQUIPMENT_DATA_FILE = "equipment.csv";
	
	// PLAYER EQUIPMENT == RELATIONAL DATABASE
	
	private static final String QUEST_TABLE_NAME = "quest";
	private static final String[] QUEST_FIELD_NAMES = {"id", "name", "completionRequirement", "description"};
	private static final String[] QUEST_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT"};
	
	//private static final String QUEST_DATA_FILE = "quest.csv";
	
	private static final String ATTACK_TABLE_NAME = "attack";
	private static final String[] ATTACK_FIELD_NAMES = {"id", "name", "strengthRequired", "dexterityRequired", "intellectRequired", "damage"};
	private static final String[] ATTACK_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER"};
	
	//private static final String ATTACK_DATA_FILE = "attack.csv";
	
	// PLAYER ATTACKS == RELATIONAL DATABASE
	
	// SAVE FILE???
	
	private Player mCurrentPlayer;
	private Enemy mEnemy;
	private DBModel mPlayerDB;
	private DBModel mEnemyDB;
	private DBModel mEquipmentDB;
	private DBModel mPlayerEquipmentDB;
	private DBModel mQuestDB;
	private DBModel mAttackDB;
	private DBModel mPlayerAttackDB;
	
	private ObservableList<Player> mAllPlayersList;
	private ObservableList<Enemy> mAllEnemiesList;
	private ObservableList<Equipment> mAllEquipmentList;
	private ObservableList<Quest> mAllQuestsList;
	private ObservableList<Attack> mAllAttacksList;
	
	
	
	private Controller()
	{
		
	}
	
	/*
	 * Need to finish by adding the remaining tables
	 */
	
	public static Controller getInstance()
	{
		if(theOne == null)
		{
			theOne = new Controller();
			
			try {
				theOne.mPlayerDB = new DBModel(DB_NAME, PLAYER_TABLE_NAME, PLAYER_FIELD_NAMES, PLAYER_FIELD_TYPES);
				
				ArrayList<ArrayList<String>> resultsList = theOne.mPlayerDB.getAllRecords();
				for(ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String name = values.get(1);
					int strength = Integer.parseInt(values.get(2));
					int dexterity = Integer.parseInt(values.get(3));
					int intellect = Integer.parseInt(values.get(4));
					int health = Integer.parseInt(values.get(5));
					String equipment = values.get(6);
				}
				
				theOne.mEnemyDB = new DBModel(DB_NAME, ENEMY_TABLE_NAME, ENEMY_FIELD_NAMES, ENEMY_FIELD_TYPES);
				
				theOne.initializeEnemyDBFromFile();
				resultsList = theOne.mEnemyDB.getAllRecords();
				for(ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String name = values.get(1);
					int damage = Integer.parseInt(values.get(2));
					int defense = Integer.parseInt(values.get(3));
					int health = Integer.parseInt(values.get(4));
					String equipment = values.get(5);
					theOne.mAllEnemiesList.add(new Enemy(id, name, damage, defense, health, equipment));
				}
				
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return theOne;
	}

	private int initializeEnemyDBFromFile() throws SQLException {
		int recordsCreated = 0;
		
		if(theOne.mPlayerDB.getRecordCount() > 0) return 0;
		
		try {
			Scanner fileScanner = new Scanner(new File(ENEMY_DATA_FILE));
			fileScanner.nextLine();
			while(fileScanner.hasNextLine())
			{
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[ENEMY_FIELD_NAMES.length-1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
				theOne.mEnemyDB.createRecord(Arrays.copyOfRange(ENEMY_FIELD_NAMES, 1, ENEMY_FIELD_NAMES.length), values);
				recordsCreated++;
			}
			fileScanner.close();
		}
		catch(FileNotFoundException e)
		{
			return 0;
		}
		return recordsCreated;
		
	}
	
	public Player getCurrentPlayer()
	{
		return mCurrentPlayer;
	}
	
	public ObservableList<Player> getAllPlayers()
	{
		return theOne.mAllPlayersList;
	}
	
	public ObservableList<Enemy> getAllEnemies()
	{
		return theOne.mAllEnemiesList;
	}
	
	public ObservableList<Equipment> getAllEquipment()
	{
		return theOne.mAllEquipmentList;
	}
	
	public ObservableList<Quest> getAllQuests()
	{
		return theOne.mAllQuestsList;
	}
	
	public ObservableList<Attack> getAllAttacks()
	{
		return theOne.mAllAttacksList;
	}
	
	
}
