package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

public class OptionsScene {

	@FXML
	public Object resume()
	{
		ViewNavigator.loadScene(ViewNavigator.prevTitle, ViewNavigator.prevScene);
		return this;
	}
	
	/*
	 * 
	 * HOW TO MAKE THESE WORK???
	 * 
	@FXML
	public Object save()
	{
		
	}
	
	@FXML
	public Object load()
	{
		
	}
	*/
	
	// Set all values to default (strength, dex, intellect = 5; name = blank);
	@FXML
	public Object title()
	{
		
		ViewNavigator.loadScene("Title", ViewNavigator.TITLE);
		return this;
	}
	
	@FXML
	public Object quit()
	{
		System.exit(0);
		return null;
	}

	
}
