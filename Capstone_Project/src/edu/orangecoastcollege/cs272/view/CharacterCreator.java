package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CharacterCreator {

	/*
	 * 
	 * WHY DOESN'T THIS WORK???
	 * 
	@FXML
	private int strength = 5;
	
	@FXML
	private int dexterity = 5;
	
	@FXML
	private int intellect = 5;
	
	@FXML
	private int points = 10;
	*/
	
	@FXML
	private TextField nameTF = new TextField();
	
	@FXML
	private Button startButton;
	
	@FXML
	private Label nameErrorLabel;
	
	@FXML
	private Button plusStrength;
	
	@FXML
	private Button minusStrength;
	
	@FXML
	private Button plusDexterity;
	
	@FXML
	private Button minusDexterity;
	
	@FXML
	private Button plusIntellect;
	
	@FXML
	private Button minusIntellect;
	
	@FXML
	private Button plusImage;
	
	@FXML
	private Button minusImage;
	

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
	
	@FXML
	public Object plusStrength()
	{
		
		return this;
	}
	
	@FXML
	public Object minusStrength()
	{
		
		return this;
	}
	
	@FXML
	public Object plusDexterity()
	{
		
		return this;
	}
	
	@FXML
	public Object minusDexterity()
	{
		
		return this;
	}
	
	@FXML
	public Object plusIntellect()
	{
		
		return this;
	}
	
	@FXML
	public Object minusIntellect()
	{
		
		return this;
	}
	
	@FXML
	public Object plusImage()
	{
		
		return this;
	}
	
	@FXML
	public Object minusImage()
	{
		
		return this;
	}
	

}
