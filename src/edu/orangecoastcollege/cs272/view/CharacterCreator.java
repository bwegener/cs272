package edu.orangecoastcollege.cs272.view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Originally created by Brian Wegener
 * with some ammendments Khang Nguyen
 * Duong Tran created all of the buttons,
 * connected them to the controller,
 * set up the errors, and made this scene work.
 * 
 * This JavaFX scene is character creator
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class CharacterCreator implements Initializable {
	
    Controller controller = Controller.getInstance();
	// Call CharacterCreater.currentPlayer used to add to database when saving
    public static Player currentPlayer;
    
    private int pool = 5;
    private int characterPosition = 0;
    private String[] characterArray = new String[]{"face1.jpeg","face2.png","face3.png"};
    
    @FXML
    private Label pointsLabel;
	@FXML
	private TextField nameTF;
	@FXML
	private Label nameErrorLabel;
	@FXML
	private Label poolErrorLabel;
	@FXML
	private Label insufficientStatLabel;
	@FXML
	private Slider strSlider;
	@FXML
	private Slider dexSlider;
	@FXML
	private Slider intSlider;
	@FXML
	private ImageView characterFace;

	/**
	 * This takes the player to the options scene
	 * @return
	 */
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.CHARACTER_CREATOR;
		ViewNavigator.prevTitle = "Character Creator";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	/**
	 * This instantiates the character while doing some checks to
	 * make sure the player entered all relevant information
	 * it puts up erros if the player didn't
	 * This also takes players to the introForest
	 * @return
	 */
	@FXML
	public Object start()
	{
		String name = nameTF.getText();
		//controller.getCurr
		if(name.isEmpty())
		{
			poolErrorLabel.setVisible(false);
			nameErrorLabel.setVisible(true);
		}
		else if(pool > 0)
		{
			nameErrorLabel.setVisible(false);
			poolErrorLabel.setVisible(true);
		}

		if(!name.isEmpty() && pool == 0)
		{
			currentPlayer.setName(name);
			controller.setCurrentPlayer(currentPlayer);
			ViewNavigator.loadScene("It Begins", ViewNavigator.INTRO_FOREST);
			return this;
		}
		return null;
	}
	
	/**
	 * This button increases the strength
	 * @return
	 */
	@FXML
	public Object plusStrength()
	{
		if (pool > 0 && currentPlayer.getStrength() < 10)
		{
			currentPlayer.strUp();
			strSlider.setValue(currentPlayer.getStrength());;
			pool--;
			pointsLabel.setText(String.valueOf(pool));
			return this;
		}
		else
		{
			if (currentPlayer.getStrength() == 10) {
			insufficientStatLabel.setText("Too Much Strength");
			}
			else if(pool == 0)
			{
				insufficientStatLabel.setText("Not Enough Points");
			}

		}

		return null;
	}

	/**
	 * This button decreases strength
	 * @return
	 */
	@FXML
	public Object minusStrength()
	{
		if (pool >= 0 && currentPlayer.getStrength() > 0)
		{
			currentPlayer.strDown();
			strSlider.setValue(currentPlayer.getStrength());;
			pool++;
			pointsLabel.setText(String.valueOf(pool));
			return this;
		}
		else if (currentPlayer.getStrength() == 0)
		{
			insufficientStatLabel.setText("Not Enough Strength");
		}
		
		return null;
	}

	/**
	 * This button increases dexterity
	 * @return
	 */
	@FXML
	public Object plusDexterity()
	{
		if (pool > 0 && currentPlayer.getDexterity() < 10)
		{
			currentPlayer.dexUp();
			dexSlider.setValue(currentPlayer.getDexterity());;
			pool--;
			pointsLabel.setText(String.valueOf(pool));
			return this;
		}
		else
		{
			if (currentPlayer.getDexterity() == 10) {
			insufficientStatLabel.setText("Too Much Dexterity");
			}
			else if(pool == 0)
			{
				insufficientStatLabel.setText("Not Enough Points");
			}

		}
			
		return null;
	}

	/**
	 * This button decreases dexterity
	 * @return
	 */
	@FXML
	public Object minusDexterity()
	{
		if (pool >= 0 && currentPlayer.getDexterity() > 0)
		{
			currentPlayer.dexDown();
			dexSlider.setValue(currentPlayer.getDexterity());;
			pool++;
			pointsLabel.setText(String.valueOf(pool));
			return this;
		}
		else if (currentPlayer.getDexterity() == 0)
		{
			insufficientStatLabel.setText("Not Enough Dexterity");
		}
		
		return null;
	}

	/**
	 * This button increases intellect
	 * @return
	 */
	@FXML
	public Object plusIntellect()
	{
		if (pool > 0 && currentPlayer.getIntellect() < 10)
		{
			currentPlayer.intUp();
			intSlider.setValue(currentPlayer.getIntellect());;
			pool--;
			pointsLabel.setText(String.valueOf(pool));
			return this;
		}
		else
		{
			if (currentPlayer.getIntellect() == 10){
			insufficientStatLabel.setText("Too Much Intellect");}
			else if(pool == 0)
			{
				insufficientStatLabel.setText("Not Enough Points");
			}

		}
			
		return null;
	}

	/**
	 * This button decreases intellect
	 * @return
	 */
	@FXML
	public Object minusIntellect()
	{
		if (pool >= 0 && currentPlayer.getIntellect() > 0)
		{
			currentPlayer.intDown();
			intSlider.setValue(currentPlayer.getIntellect());;
			pool++;
			pointsLabel.setText(String.valueOf(pool));
			return this;
		}
		else if (currentPlayer.getIntellect() == 0)
		{
			insufficientStatLabel.setText("Not Enough Intellect");
		}
		
		return null;
	}
	
	 // Created by Duong Tran
	/**
	 * This button changes the image
	 * @return
	 */
	@FXML
	public Object plusImage()
	{
		characterPosition +=1;
		if(characterPosition < characterArray.length)

			changeImage(characterArray[characterPosition]);
		else{
			characterPosition = 0;
			changeImage(characterArray[0]);
		}
		return this;
	}
	 // Created by Duong Tran
	/**
	 * This button changes the iamge
	 * @return
	 */
	@FXML
	public Object minusImage()
	{
		characterPosition -=1;
		if(characterPosition >= 0)
			changeImage(characterArray[characterPosition]);
		else{
			characterPosition = characterArray.length - 1;
			changeImage(characterArray[characterArray.length-1]);
		}
		return this;
	}
	// Created by Duong Tran
	/**
	 * This calls the changeImage method which is used in the plus/minus Image methods
	 * @param face
	 * @return
	 */
    private ImageView changeImage(String face){
    	Image character = new Image((new File("Images/" + face).toURI().toString()));
    	characterFace.setImage(character);
    	currentPlayer.setFace("Images/" + face);
        return characterFace;
    }

    /**
     * This initializes the scene so that it gets the current player
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		currentPlayer = controller.getCurrentPlayer();
		
	}

}
