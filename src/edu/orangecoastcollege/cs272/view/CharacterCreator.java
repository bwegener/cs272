package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CharacterCreator {


    private static Controller controller = Controller.getInstance();

    private int pool = 10;
    
    @FXML
    private Label pointsLabel;
    
	@FXML
	private TextField nameTF;
	
	@FXML
	private Button startButton;

	@FXML
	private Label nameErrorLabel;
	
	@FXML
	private Label tooMuchStrengthError;
	
	@FXML
	private Label notEnoughStrengthError;
	
	@FXML
	private Label tooMuchDexterityError;
	
	@FXML
	private Label notEnoughDexterityError;
	
	@FXML
	private Label tooMuchIntellectError;
	
	@FXML
	private Label notEnoughIntellectError;

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
		//controller.getCurr
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
		Player currentPlayer = controller.getCurrentPlayer();
		if (pool > 0 || currentPlayer.getStrength() < 10)
		{
			int strength = currentPlayer.getStrength();
			strength++;
			currentPlayer.setStrength(strength);
			pool--;
			pointsLabel.setText(String.valueOf(pool));
			return this;
		}
		else
		{
			tooMuchStrengthError.setVisible(true);
		}
			
		return null;
	}

	@FXML
	public Object minusStrength()
	{
		Player currentPlayer = controller.getCurrentPlayer();
		if (pool < 10 || currentPlayer.getStrength() > 0)
		{
			int strength = currentPlayer.getStrength();
			strength--;
			currentPlayer.setStrength(strength);
			pool++;
			pointsLabel.setText(String.valueOf(pool));
			return this;
		}
		else
		{
			notEnoughStrengthError.setVisible(true);
		}

		return null;
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
