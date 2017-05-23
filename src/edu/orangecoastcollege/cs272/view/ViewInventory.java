package edu.orangecoastcollege.cs272.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Equipment;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;

/**
 * Duong Tran May 20, 2017
 * 
 * @author Duong
 *
 */
public class ViewInventory implements Initializable {
	private static Controller controller = Controller.getInstance();
	@FXML
	private Label headgear;
	@FXML
	private Label bodygear;
	@FXML
	private Label leggear;
	@FXML
	private Label weapon;
	@FXML
	private ListView<Equipment> allUserEquipmentLV;

	/**
	 * This initializes the scene with the relational database player-equipment
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		allUserEquipmentLV.setItems(controller.getEquipmentForPlayers());
	}

	/**
	 * This allows the player to equip the items that they click on
	 * @return
	 */
	@FXML
	public Object equip() {
		Equipment testItem = allUserEquipmentLV.getSelectionModel().getSelectedItem();
		if (testItem != null) {
			controller.setCurrentEquipment(testItem);
			String equipName = testItem.getName();
			weapon.setText(equipName);
		}
		return this;
	}

	/**
	 * This allows the player to unequip any items
	 * @return
	 */
	@FXML
	public Object unequip() {
		controller.setCurrentEquipment(null);
		weapon.setText("none");
		return this;
	}

	/**
	 * This sends the player back to the stats scene
	 * @return
	 */
	@FXML
	public Object stats() {
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
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
}
