package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

public class Title {

	@FXML
	public Object start()
	{
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
