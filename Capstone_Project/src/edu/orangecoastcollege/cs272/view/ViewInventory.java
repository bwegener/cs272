package edu.orangecoastcollege.cs272.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Equipment;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
/**
 * Duong Tran
 * May 20, 2017
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
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		allUserEquipmentLV.setItems(controller.getEquipmentForPlayers());
	}
	@FXML
	public Object equip(){
		Equipment testItem = allUserEquipmentLV.getSelectionModel().getSelectedItem();
		if(testItem != null){
			controller.setCurrentEquipment(testItem);
			String equipName = testItem.getName();
			weapon.setText(equipName);
		}
		return this;
	}
	@FXML
	public Object unequip(){
		controller.setCurrentEquipment(null);
		weapon.setText("none");
		return this;
	}
	@FXML
	public Object stats()
	{
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}	
	@FXML
	public Object resume()
	{
		ViewNavigator.loadScene(ViewNavigator.prevTitle, ViewNavigator.prevScene);
		return this;
	}	
}
