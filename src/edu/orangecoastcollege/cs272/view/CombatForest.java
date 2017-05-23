package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by Brian Wegener
 * with some ammendments by Duong Tran and Khang Nguyen
 * 
 * This JavaFX scene is the first combat scene against
 * the wolf
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class CombatForest {
	Controller controller = Controller.getInstance();

	@FXML
	private Button sneakButton;
	@FXML
	private Button fightButton;
	@FXML
	private Button runButton;
	@FXML
	private Button goButton;
	@FXML
	private Button okButton;
	@FXML
	private Button talkButton;
	@FXML
	private Label preBattleText;
	@FXML
	private Label fightWinText;
	@FXML
	private Label talkWinText;
	@FXML
	private Label runText;
	@FXML
	private Label runFailText;
	@FXML
	private Label fightText;
	@FXML
	private Label talkText;

	/**
	 * This takes the player to the options scene
	 * @return
	 */
	@FXML
	public Object optionsScene() {
		ViewNavigator.prevScene = ViewNavigator.COMBAT_FOREST;
		ViewNavigator.prevTitle = "Combat";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	/**
	 * This takes the player to the stats scene
	 * @return
	 */
	@FXML
	public Object statsScene() {
		ViewNavigator.prevScene = ViewNavigator.COMBAT_FOREST;
		ViewNavigator.prevTitle = "Combat";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}

	/**
	 * This button allows the player to fight the wolf
	 * depending on the choices the player made in the stats menu
	 * the fight will either resolve successfully or by ending the game
	 * @return
	 */
	@FXML
	public Object fight() {
		if (controller.getCurrentPlayer().getStrength() >= 8) {
			preBattleText.setVisible(false);
			fightWinText.setVisible(true);
			fightButton.setVisible(false);
			runButton.setVisible(false);
			talkButton.setVisible(false);
			goButton.setVisible(true);
		}

		else {
			preBattleText.setVisible(false);
			fightText.setVisible(true);
			fightButton.setVisible(false);
			runButton.setVisible(false);
			talkButton.setVisible(false);
			okButton.setVisible(true);
		}
		return this;
	}

	/**
	 * This allows the player to run away from the wolf
	 * if the player's dexterity is high enough
	 * @return
	 */
	@FXML
	public Object run() {
		if (controller.getCurrentPlayer().getDexterity() < 7) {
			preBattleText.setVisible(false);
			runFailText.setVisible(true);
			fightButton.setVisible(false);
			runButton.setVisible(false);
			talkButton.setVisible(false);
			okButton.setVisible(true);
		} else {
			preBattleText.setVisible(false);
			runText.setVisible(true);
			fightButton.setVisible(false);
			runButton.setVisible(false);
			talkButton.setVisible(false);
			goButton.setVisible(true);
		}
		return this;
	}

	/**
	 * This allows the player to talk to the wolf
	 * depending on the amount of intellect the player chose
	 * it will either be successful or fail
	 * @return
	 */
	@FXML
	public Object talk() {
		if (controller.getCurrentPlayer().getIntellect() >= 8) {
			preBattleText.setVisible(false);
			talkWinText.setVisible(true);
			runButton.setVisible(false);
			fightButton.setVisible(false);
			talkButton.setVisible(false);

		} else {
			preBattleText.setVisible(false);
			talkText.setVisible(true);
			runButton.setVisible(false);
			fightButton.setVisible(false);
			talkButton.setVisible(false);
			okButton.setVisible(true);
		}
		return this;
	}

	/**
	 * This sends the player to the next scene
	 * @return
	 */
	@FXML
	public Object go() {
		ViewNavigator.loadScene("A Village Approacheth", ViewNavigator.VILLAGE);
		return this;
	}

	/**
	 * This sends the player back to the title screen
	 * @return
	 */
	@FXML
	public Object ok() {
		ViewNavigator.loadScene("A Knight's Quest", ViewNavigator.TITLE);
		return this;
	}
}
