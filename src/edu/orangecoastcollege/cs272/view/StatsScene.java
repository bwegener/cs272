package edu.orangecoastcollege.cs272.view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created By Khang
 * updated by Duong May 20, 2017
 * updated by Brian Wegener May 22, 2017
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 *
 **/
public class StatsScene implements Initializable {
	Controller controller = Controller.getInstance();
	private Player currentPlayer = controller.getCurrentPlayer();

	@FXML
	private Label nameLabel;
	@FXML
	private Label damageLabel;
	@FXML
	private Label defenseLabel;
	@FXML
	private Label strengthLabel;
	@FXML
	private Label dexterityLabel;
	@FXML
	private Label intellectLabel;
	@FXML
	private ImageView faceIV;
	@FXML
	private Button saveBTN;
	@FXML
	private Button loadBTN;

	/**
	 * This initializes the scene so that all of the relevant character information is already there
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (controller.getCurrentEquipment() != null) {
			damageLabel.setText(String.valueOf(controller.getCurrentEquipment().getDamage()));
			defenseLabel.setText(String.valueOf(controller.getCurrentEquipment().getDefense()));
		}
		nameLabel.setText(currentPlayer.getName());
		strengthLabel.setText(String.valueOf(currentPlayer.getStrength()));
		dexterityLabel.setText(String.valueOf(currentPlayer.getDexterity()));
		intellectLabel.setText(String.valueOf(currentPlayer.getIntellect()));
		faceIV.setImage(new Image((new File(currentPlayer.getFace()).toURI().toString())));
	}

	/**
	 * This sends the player to the equipment scene
	 * @return
	 */
	@FXML
	public Object equipment() {
		ViewNavigator.loadScene("Equipment", ViewNavigator.VIEW_INVENTORY);
		return this;
	}

	/**
	 * This sends the player back to the previous scene
	 * @return
	 */
	@FXML
	public Object resume() {
		ViewNavigator.loadScene(ViewNavigator.prevTitle, ViewNavigator.prevScene);
		return this;
	}

	/**
	 * This sends the player to the save scene
	 */
	@FXML
	public void save() {
		ViewNavigator.loadScene("Save Game", ViewNavigator.SAVE);
	}

	/**
	 * This sends the player to the load scene
	 */
	@FXML
	public void load() {
		ViewNavigator.loadScene("Load Game", ViewNavigator.LOAD);
	}
}
