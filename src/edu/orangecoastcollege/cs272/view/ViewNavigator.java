package edu.orangecoastcollege.cs272.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Brian Wegener
 * with some ammendments by Duong Tran and Khang Nguyen
 * 
 * This JavaFX class is where all of the different
 * scenes are called
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class ViewNavigator {
		
	// This is where I put the different scenes
	public static final String TITLE = "Title.fxml";
	public static final String DATABASES = "Databases.fxml";
	public static final String LOAD = "Load.fxml";
	public static final String SAVE = "Save.fxml";
	public static final String CHARACTER_CREATOR = "CharacterCreator.fxml";
	public static final String OPTIONS_SCENE = "OptionsScene.fxml";
	public static final String STATS_SCENE = "StatsScene.fxml";
	public static final String VIEW_INVENTORY = "ViewInventory.fxml";
	public static final String INTRO_FOREST = "IntroForest.fxml";
	public static final String FOREST_SCENE_2 = "ForestScene2.fxml";
	public static final String COMBAT_FOREST = "CombatForest.fxml";
	public static final String VILLAGE = "Village.fxml";
	public static final String CONVO_WOMAN = "ConvoWoman.fxml";
	public static final String CONVO_MAN = "ConvoMan.fxml";
	public static final String BASE_OF_MOUNTAIN = "BaseOfMountain.fxml";
	public static final String BASE_CAMP = "BaseCamp.fxml";
	
	public static Stage mainStage;
	public static String prevScene;
	public static String prevTitle;
	
	/**
	 * This sets the stage so that the application can call the different scenes
	 * @param stage
	 */
	public static void setStage(Stage stage)
	{
		mainStage = stage;
	}
	
	/**
	 * This loads a scene using the string and fxml files
	 * @param title
	 * @param sceneFXML
	 */
	public static void loadScene(String title, String sceneFXML)
	{
		try {
			mainStage.setTitle(title);
			Scene scene = new Scene(FXMLLoader.load(ViewNavigator.class.getResource(sceneFXML)));
			mainStage.setScene(scene);
			mainStage.show();
		}
		catch (IOException e)
		{
			System.err.println("Error loading: " + sceneFXML + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	
}
