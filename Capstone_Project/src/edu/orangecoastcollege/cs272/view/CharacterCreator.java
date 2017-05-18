package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CharacterCreator {

	@FXML
	private TextField nameTF = new TextField();
	
	@FXML
	private Label nameErrorLabel;
	

	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.CHARACTER_CREATOR;
		ViewNavigator.prevTitle = "Character Creator";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	
	/*
	 * IDEA: set start button to be invisible till name is entered.
	 */
	
	@FXML
	public Object start()
	{
		String name = nameTF.getText();
		if(name.isEmpty())
		{
			nameErrorLabel.setVisible(true);
		}

		if(!name.isEmpty())
		{
			ViewNavigator.loadScene("Forest", ViewNavigator.INTRO_FOREST);
			return this;
		}
		
		return null;

	}

}
