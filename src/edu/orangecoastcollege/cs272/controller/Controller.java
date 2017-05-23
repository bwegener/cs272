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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Brian Wegener and Khang Nguyen
 * Ammended, Updated, and Fixed by Duong Tran
 * 
 * This controller connects the database and classes
 * to the view and pulls information from the databases/classes
 * and allows it to be used in the view package
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class Controller {

	private static Controller theOne;

	private static final String DB_NAME = "text_rpg.db";

	private static final String PLAYER_TABLE_NAME = "player";
	private static final String[] PLAYER_FIELD_NAMES = { "id", "name", "strength", "dexterity", "intellect", "face" };
	private static final String[] PLAYER_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "TEXT" };

	private static final String ENEMY_TABLE_NAME = "enemy";
	private static final String[] ENEMY_FIELD_NAMES = { "id", "name", "damage", "defense", "health"};
	private static final String[] ENEMY_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER"};
	private static final String ENEMY_DATA_FILE = "enemy.csv";

	private static final String EQUIPMENT_TABLE_NAME = "equipment";
	private static final String[] EQUIPMENT_FIELD_NAMES = { "id", "name", "damage", "defense","strength","dexterity","intellect"};
	private static final String[] EQUIPMENT_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER"};
	private static final String EQUIPMENT_DATA_FILE = "equipment.csv";

	private static final String QUEST_TABLE_NAME = "quest";
	private static final String[] QUEST_FIELD_NAMES = {"id", "name", "completionRequirement", "description"};
	private static final String[] QUEST_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT"};
	private static final String QUEST_DATA_FILE = "quest.csv";

	private static final String ATTACK_TABLE_NAME = "attack";
	private static final String[] ATTACK_FIELD_NAMES = {"id", "name", "strengthRequired", "dexterityRequired", "intellectRequired", "damage"};
	private static final String[] ATTACK_FIELD_TYPES = {"INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER"};
	private static final String ATTACK_DATA_FILE = "attack.csv";

	
	// PLAYER EQUIPMENT == RELATIONAL DATABASE
	private static final String PLAYER_EQUIPMENT = "player_equipment";
	private static final String[] PLAYER_EQUIPMENT_NAMES = {"user_id", "equipment_id"};
	private static final String[] PLAYER_EQUIPMENT_TYPES = {"INTEGER", "INTEGER"};
	// PLAYER ATTACKS == RELATIONAL DATABASE
	private static final String PLAYER_ATTACKS = "player_attacks";
	private static final String[] PLAYER_ATTACKS_NAMES = {"user_id", "ability_id"};
	private static final String[] PLAYER_ATTACKS_TYPES = {"INTEGER", "INTEGER"};


	private Player mCurrentPlayer;
	private Equipment mCurrentEquipment;
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


	/**
	 * Original by Brian
	 * Updated and Ammended by Duong and Khang
	 * This instance creates the observable array lists.
	 * It also instantiates the player database
	 * It pulls from the csv files to create the enemy, equipment, quest, and attack databases.
	 * @return theOne controller
	 */
	public static Controller getInstance()
	{
		if(theOne == null)
		{
			theOne = new Controller();
			theOne.mAllPlayersList = FXCollections.observableArrayList();
			theOne.mAllEnemiesList = FXCollections.observableArrayList();
			theOne.mAllEquipmentList = FXCollections.observableArrayList();
			theOne.mAllQuestsList = FXCollections.observableArrayList();
			theOne.mAllAttacksList = FXCollections.observableArrayList();
			
			
			try {
				theOne.mPlayerDB = new DBModel(DB_NAME, PLAYER_TABLE_NAME, PLAYER_FIELD_NAMES, PLAYER_FIELD_TYPES);
				ArrayList<ArrayList<String>> resultsList = theOne.mPlayerDB.getAllRecords();
				theOne.initializePlayerDBFromFile();
				for(ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String name = values.get(1);
					int strength = Integer.parseInt(values.get(2));
					int dexterity = Integer.parseInt(values.get(3));
					int intellect = Integer.parseInt(values.get(4));
					String face = values.get(5);
					theOne.mAllPlayersList.add(new Player(id, name, intellect, strength, dexterity, face));
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
					theOne.mAllEnemiesList.add(new Enemy(id, name, damage, defense, health));
				}

				theOne.mEquipmentDB = new DBModel(DB_NAME, EQUIPMENT_TABLE_NAME, EQUIPMENT_FIELD_NAMES, EQUIPMENT_FIELD_TYPES);

				theOne.initializeEquipmentDBFromFile();
				resultsList = theOne.mEquipmentDB.getAllRecords();
				for(ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String name = values.get(1);
					int damage = Integer.parseInt(values.get(2));
					int defense = Integer.parseInt(values.get(3));
					int strength = Integer.parseInt(values.get(4));
					int dexterity = Integer.parseInt(values.get(5));
					int intellect = Integer.parseInt(values.get(6));
					theOne.mAllEquipmentList.add(new Equipment(id, name, damage, defense,strength,dexterity,intellect));
				}

				theOne.mQuestDB = new DBModel(DB_NAME, QUEST_TABLE_NAME, QUEST_FIELD_NAMES, QUEST_FIELD_TYPES);

				theOne.initializeQuestDBFromFile();
				resultsList = theOne.mQuestDB.getAllRecords();
				for(ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String name = values.get(1);
					String completionRequirement = values.get(2);
					String description = values.get(3);
					theOne.mAllQuestsList.add(new Quest(id, name, completionRequirement, description));
				}

				theOne.mAttackDB = new DBModel(DB_NAME, ATTACK_TABLE_NAME, ATTACK_FIELD_NAMES, ATTACK_FIELD_TYPES);

				theOne.initializeAttackDBFromFile();
				resultsList = theOne.mAttackDB.getAllRecords();
				for(ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String name = values.get(1);
					int strengthRequired = Integer.parseInt(values.get(2));
					int dexterityRequired = Integer.parseInt(values.get(3));
					int intellectRequired = Integer.parseInt(values.get(4));
					int damage = Integer.parseInt(values.get(5));
					theOne.mAllAttacksList.add(new Attack(id, name, strengthRequired, dexterityRequired, intellectRequired, damage));
				}

				theOne.mPlayerEquipmentDB = new DBModel(DB_NAME,PLAYER_EQUIPMENT,PLAYER_EQUIPMENT_NAMES,PLAYER_EQUIPMENT_TYPES);
				theOne.mPlayerAttackDB = new DBModel(DB_NAME,PLAYER_ATTACKS,PLAYER_ATTACKS_NAMES,PLAYER_ATTACKS_TYPES);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		return theOne;
	}

	private int  initializeEnemyDBFromFile() throws SQLException {
		int recordsCreated = 0;

		if(theOne.mEnemyDB.getRecordCount() > 0) return 0;

		try {
			Scanner fileScanner = new Scanner(new File(ENEMY_DATA_FILE));
			fileScanner.nextLine();
			while(fileScanner.hasNextLine())
			{
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[ENEMY_FIELD_NAMES.length-1];

				// IS THIS JUST FOR STRINGS?
				values[0] = data[0].replaceAll("'", "''");
				values[1] = data[1];
				values[2] = data[2];
				values[3] = data[3];
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
	private int initializeEquipmentDBFromFile() throws SQLException {
		int recordsCreated = 0;

		if(theOne.mEquipmentDB.getRecordCount() > 0) return 0;

		try {
			Scanner fileScanner = new Scanner(new File(EQUIPMENT_DATA_FILE));
			fileScanner.nextLine();
			while(fileScanner.hasNextLine())
			{
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[EQUIPMENT_FIELD_NAMES.length-1];

				// IS THIS JUST FOR STRINGS?
				values[0] = data[0].replaceAll("'", "''");
				values[1] = data[1];
				values[2] = data[2];
				values[3] = data[3];
				values[4] = data[4];
				values[5] = data[5];
				theOne.mEquipmentDB.createRecord(Arrays.copyOfRange(EQUIPMENT_FIELD_NAMES, 1, EQUIPMENT_FIELD_NAMES.length), values);
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
	private int initializeQuestDBFromFile() throws SQLException {
		int recordsCreated = 0;

		if(theOne.mQuestDB.getRecordCount() > 0) return 0;

		try {
			Scanner fileScanner = new Scanner(new File(QUEST_DATA_FILE));
			fileScanner.nextLine();
			while(fileScanner.hasNextLine())
			{
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[QUEST_FIELD_NAMES.length-1];

				// IS THIS JUST FOR STRINGS?
				values[0] = data[0].replaceAll("'", "''"); // NEED FOR STRINGS
				values[1] = data[1];
				values[2] = data[2];
				theOne.mQuestDB.createRecord(Arrays.copyOfRange(QUEST_FIELD_NAMES, 1, QUEST_FIELD_NAMES.length), values);
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
	private int initializeAttackDBFromFile() throws SQLException {
		int recordsCreated = 0;

		if(theOne.mAttackDB.getRecordCount() > 0) return 0;

		try {
			Scanner fileScanner = new Scanner(new File(ATTACK_DATA_FILE));
			fileScanner.nextLine();
			while(fileScanner.hasNextLine())
			{
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[ATTACK_FIELD_NAMES.length-1];

				// IS THIS JUST FOR STRINGS?
				values[0] = data[0].replaceAll("'", "''"); // NEED FOR STRINGS
				values[1] = data[1];
				values[2] = data[2];
				values[3] = data[3];
				values[4] = data[4];
				theOne.mAttackDB.createRecord(Arrays.copyOfRange(ATTACK_FIELD_NAMES, 1, ATTACK_FIELD_NAMES.length), values);
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
	private int initializePlayerDBFromFile() throws SQLException {
		int recordsCreated = 0;
		if(theOne.mPlayerDB.getRecordCount() > 0) return 0;

		for(int i = 0; i < 3; i++)
		{
			String[] values = new String[PLAYER_FIELD_NAMES.length-1];
			Player dummyPlayer = new Player();
			// IS THIS JUST FOR STRINGS?
			values[0] = dummyPlayer.getName();
			values[1] = String.valueOf(dummyPlayer.getStrength());
			values[2] = String.valueOf(dummyPlayer.getDexterity());
			values[3] = String.valueOf(dummyPlayer.getIntellect());
			values[4] = dummyPlayer.getFace();
			theOne.mPlayerDB.createRecord(Arrays.copyOfRange(PLAYER_FIELD_NAMES, 1, PLAYER_FIELD_NAMES.length), values);
			recordsCreated++;
		}
		return recordsCreated;
	}
	
	
	/**
	 * This gets the current player from the program
	 * @return the current player
	 */
	public Player getCurrentPlayer()
	{
		return mCurrentPlayer;
	}

	/**
	 * Sets the current player
	 * @param currentPlayer
	 */
	public void setCurrentPlayer(Player currentPlayer)
	{
	    mCurrentPlayer = currentPlayer;
	}
	
	/**
	 * Gets the equipment from the csv
	 * @return the equipment
	 */
	public Equipment getCurrentEquipment()
	{
		return mCurrentEquipment;
	}

	/**
	 * Sets the current equipment
	 * @param currentEquipment
	 */
	public void setCurrentEquipment(Equipment currentEquipment)
	{
	    mCurrentEquipment = currentEquipment;
	}
	
	/**
	 * Creates the observableList of all the players
	 * @return the observableList of all players
	 */
	public ObservableList<Player> getAllPlayers()
	{
		return theOne.mAllPlayersList;
	}

	/**
	 * Creates the observableList of all the enemies
	 * @return the observableList of all enemies
	 */
	public ObservableList<Enemy> getAllEnemies()
	{
		return theOne.mAllEnemiesList;
	}

	/**
	 * Creates the observableList of all the equipment
	 * @return the observableList of all equipment
	 */
	public ObservableList<Equipment> getAllEquipment()
	{
		return theOne.mAllEquipmentList;
	}

	/**
	 * Creates the observableList of all the quests
	 * @return the observableList of all the quests
	 */
	public ObservableList<Quest> getAllQuests()
	{
		return theOne.mAllQuestsList;
	}

	/**
	 * Creates the observableList of all the attacks
	 * @return the observableList of all attacks
	 */
	public ObservableList<Attack> getAllAttacks()
	{
		return theOne.mAllAttacksList;
	}

	/**
	 * Duong Tran
	 * Get an item from the DB
	 */
	public Equipment getItem(String itemName){
		for(Equipment e :theOne.mAllEquipmentList){
			if(e.getName().equalsIgnoreCase(itemName)){
				return e;
			}
		}
		return null;
	}
	/**
	 * Duong Tran
	 * Get the list of equipments the player is carrying
	 */
	public ObservableList<Equipment> getEquipmentForPlayers(){
		ObservableList<Equipment> userEquipment = FXCollections.observableArrayList();
		if(mCurrentPlayer !=null){
			try{
				ArrayList<ArrayList<String>> resultList = theOne.mPlayerEquipmentDB.getRecord(String.valueOf(mCurrentPlayer.getID()));
				for (ArrayList<String> values: resultList){
					int equipId = Integer.parseInt(values.get(0));
					for(Equipment equip : theOne.mAllEquipmentList)
						if(equip.getId() == equipId)
							userEquipment.add(equip);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userEquipment;
		
	}
	/**
	 * Duong Tran
	 * Add the Equipment to the players inventory
	 */
	public boolean addEquipmentToInventory(Equipment selectedEquipment){
		ObservableList<Equipment> playerEquipment = theOne.getEquipmentForPlayers();
		if(playerEquipment.contains(selectedEquipment))
			return false;
		
		String[] values = {String.valueOf(mCurrentPlayer.getID()), String.valueOf(selectedEquipment.getId())};
		try{
			this.mPlayerEquipmentDB.createRecord(PLAYER_EQUIPMENT_NAMES, values);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * Duong Tran
	 * Get the list of Attacks the player is carrying
	 */
	public ObservableList<Attack> getAbilityForPlayers(){
		ObservableList<Attack> userAttack = FXCollections.observableArrayList();
		if(mCurrentPlayer !=null){
			try{
				ArrayList<ArrayList<String>> resultList = theOne.mPlayerAttackDB.getRecord(String.valueOf(mCurrentPlayer.getID()));
				for (ArrayList<String> values: resultList){
					int equipId = Integer.parseInt(values.get(0));
					for(Attack attack : theOne.mAllAttacksList)
						if(attack.getId() == equipId)
							userAttack.add(attack);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userAttack;
		
	}
	/**
	 * Duong Tran
	 * Add the Attack to the players inventory
	 */
	public boolean addAbilityToInventory(Attack selectedAbility){
		ObservableList<Attack> playerAttack = theOne.getAbilityForPlayers();
		if(playerAttack.contains(selectedAbility))
			return false;
		
		String[] values = {String.valueOf(mCurrentPlayer.getID()), String.valueOf(selectedAbility.getId())};
		try{
			this.mPlayerAttackDB.createRecord(PLAYER_ATTACKS_NAMES, values);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	 * Duong Tran
	 * Load the Game
	 */
	public String loadUser(int key){
		for(Player p : theOne.mAllPlayersList){
				if(p.getID() == key){
					//ArrayList<ArrayList<String>> rs = theOne.mPlayerDB.getRecord(String.valueOf(p.getID()));
					mCurrentPlayer = p;
					return "SUCCESS";
				}
			}
		return "Player not Found.";
	}
	/**
	 * Duong Tran
	 * Save Player
	 */
	public void savePlayer(int key){
		String[] values = new String[]{ mCurrentPlayer.getName(), 
											String.valueOf(mCurrentPlayer.getStrength()),
											String.valueOf(mCurrentPlayer.getDexterity()),
											String.valueOf(mCurrentPlayer.getIntellect()),
											mCurrentPlayer.getFace()};
		String[]fields = Arrays.copyOfRange(PLAYER_FIELD_NAMES, 1, PLAYER_FIELD_NAMES.length);
		try {
			theOne.mPlayerDB.updateRecord(String.valueOf(key), fields, values);
			theOne.mAllPlayersList.set((key - 1), mCurrentPlayer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
