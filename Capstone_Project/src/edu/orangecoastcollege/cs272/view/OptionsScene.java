package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

public class OptionsScene {

	@FXML
	public Object resume()
	{
		ViewNavigator.loadScene(ViewNavigator.prevTitle, ViewNavigator.prevScene);
		return this;
	}
	
	
	// Set all values to default (strength, dex, intellect = 5; name = blank);
	@FXML
	public Object title()
	{
		
		ViewNavigator.loadScene("Title", ViewNavigator.TITLE);
		return this;
	}
	// Added by Duong Tran
	@FXML
	public Object Load()
	{
		
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
