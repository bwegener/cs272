package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;

public class Load {
	Controller controller = Controller.getInstance();
	public Player currentPlayer;
	@FXML
	public Object save1()
	{
		controller.loadUser(1);
		ViewNavigator.loadScene("Character Creator", ViewNavigator.FOREST_SCENE_2);
		return this;
	}
	
	@FXML
	public Object save2()
	{
		controller.loadUser(2);
		ViewNavigator.loadScene("Character Creator", ViewNavigator.FOREST_SCENE_2);
		return this;
	}
	
	@FXML
	public Object save3()
	{
		controller.loadUser(3);
		ViewNavigator.loadScene("Character Creator", ViewNavigator.FOREST_SCENE_2);
		return this;
	}
	
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.loadScene("Player Stats", ViewNavigator.prevScene);
		return this;
	}
	
}
