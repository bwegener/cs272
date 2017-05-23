package edu.orangecoastcollege.cs272.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class IntroForest implements Initializable {
	
	Controller controller = Controller.getInstance();
    private Player currentPlayer = controller.getCurrentPlayer();
    
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
	private Label nameLabel;
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		nameLabel.setText(currentPlayer.getName());
    }
	
	
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
		nameLabel.setVisible(false);
		IntroText.setVisible(false);
		examineText.setVisible(true);
		examineButton.setVisible(false);
		pickUpButton.setVisible(true);
		return this;

		// Collect Item -- Controller -- database
	}
	
	
	@FXML
	public Object go()
	{
		ViewNavigator.loadScene("The Path", ViewNavigator.FOREST_SCENE_2);
		return this;
	}
}
