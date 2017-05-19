package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

public class Title {
	
	@FXML
	public Object start()
	{
		ViewNavigator.loadScene("Character Creator", ViewNavigator.CHARACTER_CREATOR);
		return this;
	}
	
	@FXML
	public Object quit()
	{
		System.exit(0);
		return null;
	}
	
}
