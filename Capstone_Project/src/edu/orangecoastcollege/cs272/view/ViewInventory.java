package edu.orangecoastcollege.cs272.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
/**
 * Duong Tran
 * May 20, 2017
 * @author Duong
 *
 */
public class ViewInventory implements Initializable {
	@FXML
	private Label headgear;
	@FXML
	private Label bodygear;
	@FXML
	private Label leggear;
	@FXML
	private Label weapon;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	@FXML
	public Object equip(){
		return this;
	}
	@FXML
	public Object unequip(){
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
