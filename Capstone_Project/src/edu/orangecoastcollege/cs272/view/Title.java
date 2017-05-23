package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;

public class Title {
	Controller controller = Controller.getInstance();
	@FXML
	public Object start()
	{
		controller.setCurrentPlayer(new Player());
		ViewNavigator.loadScene("Load", ViewNavigator.CHARACTER_CREATOR);
		return this;
	}
	@FXML
	public Object Load()
	{
		ViewNavigator.prevScene = ViewNavigator.TITLE;
		ViewNavigator.loadScene("Load", ViewNavigator.LOAD);
		return this;
	}
	@FXML
	public Object quit()
	{
		System.exit(0);
		return null;
	}
	
}
