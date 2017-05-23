package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

/**
 * Created by Brian Wegener (with help from Michael Paulding)
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
public class OptionsScene {

	/**
	 * Sends the player back to whatever scene they came from
	 * @return
	 */
	@FXML
	public Object resume()
	{
		ViewNavigator.loadScene(ViewNavigator.prevTitle, ViewNavigator.prevScene);
		return this;
	}
	
	/**
	 * Sends the player back to the title screen
	 * @return
	 */
	@FXML
	public Object title()
	{
		ViewNavigator.loadScene("Title", ViewNavigator.TITLE);
		return this;
	}
	
	// Added by Duong Tran
	/**
	 * This sends the player to the load scene
	 * @return
	 */
	@FXML
	public Object Load()
	{
		
		ViewNavigator.loadScene("Load", ViewNavigator.LOAD);
		return this;
	}
	
	/**
	 * This quits the application
	 * @return
	 */
	@FXML
	public Object quit()
	{
		System.exit(0);
		return null;
	}

	
}
