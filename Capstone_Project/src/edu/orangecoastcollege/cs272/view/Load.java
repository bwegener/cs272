package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

public class Load {

	@FXML
	public Object save1()
	{
		ViewNavigator.loadScene("Character Creator", ViewNavigator.CHARACTER_CREATOR);
		return this;
	}
	
	@FXML
	public Object save2()
	{
		ViewNavigator.loadScene("Character Creator", ViewNavigator.CHARACTER_CREATOR);
		return this;
	}
	
	@FXML
	public Object save3()
	{
		ViewNavigator.loadScene("Character Creator", ViewNavigator.CHARACTER_CREATOR);
		return this;
	}
	
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}
	
}
