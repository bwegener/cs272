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
		ViewNavigator.prevScene = ViewNavigator.LOAD;
		ViewNavigator.prevTitle = "Load Save";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
}
