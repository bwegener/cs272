package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class IntroForest {
	
    //private static Controller controller = Controller.getInstance();
    
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
