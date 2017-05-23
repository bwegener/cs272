package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by Brian Wegener
 * with some ammendments by Duong Tran and Khang Nguyen
 * 
 * This JavaFX scene is early in the game and allows
 * the player to potentially skip a combat scene
 * depending on their stat choices
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
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

	/**
	 * This takes the player to the options scene
	 * @return
	 */
	@FXML
	public Object optionsScene() {
		ViewNavigator.prevScene = ViewNavigator.FOREST_SCENE_2;
		ViewNavigator.prevTitle = "The Path";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}

	/**
	 * This takes the player to the stats scene
	 * @return
	 */
	@FXML
	public Object statsScene() {
		ViewNavigator.prevScene = ViewNavigator.FOREST_SCENE_2;
		ViewNavigator.prevTitle = "The Path";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}

	/**
	 * This allows the player to find the enemy before going
	 * @return
	 */
	@FXML
	public Object examine() {
		IntroText.setVisible(false);
		examineText.setVisible(true);
		examineButton.setVisible(false);
		sneakButton.setVisible(true);
		return this;
	}

	/**
	 * Depending on the player's stats, this button allows the player
	 * to skip the following combat scene
	 * @return
	 */
	@FXML
	public Object sneak() {
		if (controller.getCurrentPlayer().getDexterity() < 8) {
			lowDexLabel.setText("Not Enough Dexterity");

		} else {
			ViewNavigator.loadScene("A Village Approacheth", ViewNavigator.VILLAGE);
			return this;
		}
		return null;

	}

	/**
	 * This sends the player to the combat scene if they couldn't sneak
	 * @return
	 */
	@FXML
	public Object go() {
		ViewNavigator.loadScene("Combat", ViewNavigator.COMBAT_FOREST);
		return this;
	}

}
