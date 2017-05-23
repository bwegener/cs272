package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Equipment;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class IntroForest {
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
	private Button pickUpButton;
	
	
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.INTRO_FOREST;
		ViewNavigator.prevTitle = "Forest";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	@FXML
	public Object statsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.INTRO_FOREST;
		ViewNavigator.prevTitle = "Forest";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}
	
	@FXML
	public Object examine()
	{
		/*
		 * Learn how to set text to visible and
		 * then switch out text
		 * do the same with buttons
		 */
		
		IntroText.setVisible(false);
		examineText.setVisible(true);
		examineButton.setVisible(false);
		pickUpButton.setVisible(true);
		return this;

		// Collect Item -- Controller -- database
	}
	@FXML
	public Object pickUpStick(){
		if (controller.addEquipmentToInventory(item))
			System.out.println("SUCCESS");
		else
			System.out.println("Could not add game.");
		go();
		return this;
	}
	
	@FXML
	public Object go()
	{
		ViewNavigator.loadScene("The Path", ViewNavigator.FOREST_SCENE_2);
		return this;
	}
}
