package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;

/**
 * Created by Duong Tran
 * with some ammendments by Khang Nguyen
 * 
 * This JavaFX scene is the load scene
 * I assume it loads the player I did not
 * create it and could not get it to work
 * 
 * @author Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class Load {
	Controller controller = Controller.getInstance();
	public Player currentPlayer;
	@FXML
	
	/**
	 * This allows the player to load the character from save 1
	 * @return
	 */
	public Object save1()
	{
		controller.loadUser(1);
		ViewNavigator.loadScene("It Begins", ViewNavigator.INTRO_FOREST);
		return this;
	}
	
	/**
	 * This allows the player to load the character from save 2
	 * @return
	 */
	@FXML
	public Object save2()
	{
		controller.loadUser(2);
		ViewNavigator.loadScene("It Begins", ViewNavigator.INTRO_FOREST);
		return this;
	}
	
	/**
	 * This allows the player to load the character from save 3
	 * @return
	 */
	@FXML
	public Object save3()
	{
		controller.loadUser(3);
		ViewNavigator.loadScene("It Begins", ViewNavigator.INTRO_FOREST);
		return this;
	}
	
	/**
	 * This sends the player back to the previous scene
	 * @return
	 */
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.loadScene("Options", ViewNavigator.prevScene);
		return this;
	}
	
}
