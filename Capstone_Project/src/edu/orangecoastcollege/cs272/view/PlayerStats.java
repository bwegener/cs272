package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

public class PlayerStats {

	@FXML
	public Object resume()
	{
		ViewNavigator.loadScene(ViewNavigator.prevTitle, ViewNavigator.prevScene);
		return this;
	}
	
}
