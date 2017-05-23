package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ForestScene2 {

	Controller controller = Controller.getInstance();

	@FXML
	private Label IntroText;

	@FXML
	private Label examineText;

	@FXML
	private Button go;

	@FXML
	private Button examineButton;

	@FXML
	private Button sneakButton;

	@FXML
	private Label lowDexLabel;

	@FXML
	public Object optionsScene() {
		ViewNavigator.prevScene = ViewNavigator.FOREST_SCENE_2;
		ViewNavigator.prevTitle = "The Path";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}

	@FXML
	public Object statsScene() {
		ViewNavigator.prevScene = ViewNavigator.FOREST_SCENE_2;
		ViewNavigator.prevTitle = "The Path";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}

	@FXML
	public Object examine() {
		IntroText.setVisible(false);
		examineText.setVisible(true);
		examineButton.setVisible(false);
		sneakButton.setVisible(true);
		return this;
	}

	@FXML
	public Object sneak() {
		if (controller.getCurrentPlayer().getDexterity() >= 8) {
			ViewNavigator.loadScene("A Village Approacheth", ViewNavigator.VILLAGE);
			return this;
		} else {
			lowDexLabel.setText("Not Enough Dexterity");
		}
		return null;

	}

	@FXML
	public Object go() {
		ViewNavigator.loadScene("Combat", ViewNavigator.COMBAT_FOREST);
		return this;
	}

}
