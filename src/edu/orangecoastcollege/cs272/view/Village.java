package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by Brian Wegener
 * with some ammendments by Duong Tran and Khang Nguyen
 * 
 * This JavaFX scene is when the player enters a village
 * and has the option to continue, talk to a man, or talk to a woman
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class Village {

	@FXML
	private Label villageText;

	@FXML
	private Label continueText;

	@FXML
	private Button checkButton;

	@FXML
	private Button goButton;

	@FXML
	private Button manButton;

	@FXML
	private Button girlButton;

	/**
	 * This takes the player to the options scene
	 * @return
	 */
	@FXML
	public Object optionsScene() {
		ViewNavigator.prevScene = ViewNavigator.VILLAGE;
		ViewNavigator.prevTitle = "A Village Approacheth";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}

	/**
	 * This takes the player to the stats scene
	 * @return
	 */
	@FXML
	public Object statsScene() {
		ViewNavigator.prevScene = ViewNavigator.VILLAGE;
		ViewNavigator.prevTitle = "A Village Approacheth";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}

	/**
	 * This takes the player to a scene where they were supposed to be able
	 * to have a conversation with a man from the village
	 * a lot had to be scrapped due to time constraints
	 * @return
	 */
	@FXML
	public Object man() {
		ViewNavigator.loadScene("Conversation with a Gentleman", ViewNavigator.CONVO_MAN);
		return this;
	}
	
	/**
	 * This takes the player to a scene where they were supposed to be able
	 * to have a conversation with a woman from the village
	 * while a few options are still there, a lot had to be pared down 
	 * due to time constraints
	 * @return
	 */
	@FXML
	public Object woman() {
		ViewNavigator.loadScene("Conversation with a Farmer", ViewNavigator.CONVO_WOMAN);
		return this;
	}

	/**
	 * This sends the player directly to the summit scene which is the second to last
	 * scene in the game
	 * @return
	 */
	@FXML
	public Object go() {
		ViewNavigator.loadScene("The Summit", ViewNavigator.BASE_OF_MOUNTAIN);
		return this;
	}

}
