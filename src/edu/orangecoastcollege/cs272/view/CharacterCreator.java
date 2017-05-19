package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CharacterCreator {


    private static Controller controller = Controller.getInstance();

    private int pool = 5;
    
    Player currentPlayer = new Player();
    
    @FXML
    private Label strengthLabel;
    
    @FXML
    private Label dexterityLabel;
    
    @FXML
    private Label intellectLabel;
    
    @FXML
    private Label pointsLabel;
    
	@FXML
	private TextField nameTF;
	
	@FXML
	private Button startButton;

	@FXML
	private Label nameErrorLabel;
	
	@FXML
	private Label poolErrorLabel;
	
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
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.CHARACTER_CREATOR;
		ViewNavigator.prevTitle = "Character Creator";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}

	@FXML
	public Object start()
	{
		String name = nameTF.getText();
		if(name.isEmpty())
		{
			nameErrorLabel.setVisible(true);
		}
		
		if(pool > 0)
		{
			poolErrorLabel.setVisible(true);
		}

		if(!name.isEmpty())
		{
			currentPlayer.setName(name);
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
			strengthLabel.setText(String.valueOf(currentPlayer.getStrength()));
		}
		else
		{
			tooMuchStrengthError.setVisible(true);
			return null;
		}
			
		return this;
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
			strengthLabel.setText(String.valueOf(currentPlayer.getStrength()));
		}
		else
		{
			notEnoughStrengthError.setVisible(true);
			return null;
		}

		return this;
	}

	@FXML
	public Object plusDexterity()
	{
		Player currentPlayer = controller.getCurrentPlayer();
		if (pool > 0 || currentPlayer.getDexterity() < 10)
		{
			int dexterity = currentPlayer.getDexterity();
			dexterity++;
			currentPlayer.setDexterity(dexterity);
			pool--;
			pointsLabel.setText(String.valueOf(pool));
			dexterityLabel.setText(String.valueOf(currentPlayer.getDexterity()));
		}
		else
		{
			tooMuchDexterityError.setVisible(true);
			return null;
		}

		return this;
	}

	@FXML
	public Object minusDexterity()
	{
		Player currentPlayer = controller.getCurrentPlayer();
		if(pool < 10 || currentPlayer.getDexterity() > 0)
		{
			int dexterity = currentPlayer.getDexterity();
			dexterity--;
			currentPlayer.setDexterity(dexterity);
			pool++;
			pointsLabel.setText(String.valueOf(pool));
			dexterityLabel.setText(String.valueOf(currentPlayer.getDexterity()));
		}
		else
		{
			notEnoughDexterityError.setVisible(true);
			return null;
		}
		return this;
	}

	@FXML
	public Object plusIntellect()
	{
		Player currentPlayer = controller.getCurrentPlayer();
		if(pool > 0 || currentPlayer.getDexterity() < 10)
		{
			int intellect = currentPlayer.getIntellect();
			intellect++;
			currentPlayer.setIntellect(intellect);
			pool--;
			pointsLabel.setText(String.valueOf(pool));
			intellectLabel.setText(String.valueOf(currentPlayer.getIntellect()));
		}
		else
		{
			tooMuchIntellectError.setVisible(true);
			return null;
		}
		return this;
	}

	@FXML
	public Object minusIntellect()
	{
		Player currentPlayer = controller.getCurrentPlayer();
		if(pool < 10 || currentPlayer.getIntellect() > 0)
		{
			int intellect = currentPlayer.getIntellect();
			intellect--;
			currentPlayer.setIntellect(intellect);
			pool++;
			pointsLabel.setText(String.valueOf(pool));
			intellectLabel.setText(String.valueOf(currentPlayer.getIntellect()));
		}
		else
		{
			notEnoughIntellectError.setVisible(true);
			return null;
		}
		return this;
	}

	/*

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
	*/


}
