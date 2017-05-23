package edu.orangecoastcollege.cs272.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Equipment;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by Brian Wegener
 * with some ammendments by Duong Tran and Khang Nguyen
 * 
 * This JavaFX scene is immediately after the character creator
 * it begins the game and gets the player used to how the game
 * will be played
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class IntroForest implements Initializable {
	
	Controller controller = Controller.getInstance();
    private Equipment item = controller.getItem("Stick");
    
	@FXML
	private Label examineText;
	
	@FXML
	private Label IntroText;
	
	@FXML
	private Button go;
	
	@FXML
	private Button examineButton;
	
	@FXML
	private Button pickUpStick;
	
	@FXML
	private Label nameLabel;
	
	/**
	 * This initializes the scene by calling the name that the player
	 * created in the character creator so that the opening
	 * text can be user specific
	 */
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		nameLabel.setText(controller.getCurrentPlayer().getName());
    }
	
	/**
	 * This takes the player to the options scene
	 * @return
	 */
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.INTRO_FOREST;
		ViewNavigator.prevTitle = "Forest";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	/**
	 * This takes the player to the stats scene
	 * @return
	 */
	@FXML
	public Object statsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.INTRO_FOREST;
		ViewNavigator.prevTitle = "Forest";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}
	
	/**
	 * This allows the player to examine the scene and then
	 * pick up a stick which can become a piece of equipment
	 * however we were unable to get the relational database 
	 * to display
	 * @return
	 */
	@FXML
	public Object examine()
	{
		/*
		 * Learn how to set text to visible and
		 * then switch out text
		 * do the same with buttons
		 */
		nameLabel.setVisible(false);
		IntroText.setVisible(false);
		examineText.setVisible(true);
		examineButton.setVisible(false);
		pickUpStick.setVisible(true);
		return this;

	}
	
	/**
	 * This adds the item to the player-equipment database
	 * @return
	 */
    @FXML
    public Object pickUpStick(){
        if (controller.addEquipmentToInventory(item))
            System.out.println("SUCCESS");
        else
            System.out.println("Could not add.");
        go();
        return this;
    }
	
	/**
	 * This sends the player to the next scene which also takes place in the forest
	 * @return
	 */
	@FXML
	public Object go()
	{
		ViewNavigator.loadScene("The Path", ViewNavigator.FOREST_SCENE_2);
		return this;
	}
}
