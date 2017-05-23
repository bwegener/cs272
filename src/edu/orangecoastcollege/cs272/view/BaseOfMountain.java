package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

/**
 * Created by Brian Wegener
 * with some ammendments by Duong Tran and Khang Nguyen
 * 
 * This JavaFX scene is the second to last scene in the game
 * this moves the characters closer to the end
 * it is used to set up some comic relief
 * and potentially in the future have an enemy encounter
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class BaseOfMountain {

	/**
	 * This takes the player to the last scene in the game
	 * @return
	 */
	@FXML
	public Object go()
	{
		ViewNavigator.loadScene("The End", ViewNavigator.BASE_CAMP);
		return this;
	}
	
	/**
	 * This takes the player to the options scene
	 * @return
	 */
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.BASE_OF_MOUNTAIN;
		ViewNavigator.prevTitle = "The Summit";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	/**
	 * This takes the player to the stats scene
	 * @return
	 */
	@FXML
	public Object statsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.BASE_OF_MOUNTAIN;
		ViewNavigator.prevTitle = "Conversation with a Farmer";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}
	
}
