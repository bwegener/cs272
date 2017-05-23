package edu.orangecoastcollege.cs272.view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Equipment;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/*
 * Created By Khang
 * updated by Duong May 20, 2017
 *
 */
public class StatsScene implements Initializable  {
	Controller controller = Controller.getInstance();
    private Player currentPlayer = controller.getCurrentPlayer();
    private Equipment currentEquipment = new Equipment();

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
    @FXML
 	private ListView<Equipment> allUserEquipmentLV;
    @FXML
    private ListView<Player> allPlayersLVB;
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		nameLabel.setText(currentPlayer.getName());
		damageLabel.setText(String.valueOf(currentEquipment.getDamage()));
		defenseLabel.setText(String.valueOf(currentEquipment.getDefense()));
		strengthLabel.setText(String.valueOf(currentPlayer.getStrength()));
		dexterityLabel.setText(String.valueOf(currentPlayer.getDexterity()));
		intellectLabel.setText(String.valueOf(currentPlayer.getIntellect()));
		faceIV.setImage(new Image((new File(currentPlayer.getFace()).toURI().toString())));
 		
		allUserEquipmentLV.setItems(controller.getAllEquipment());
		allPlayersLVB.setItems(controller.getAllPlayers());
	}
	@FXML
	public Object equipment()
	{
		ViewNavigator.loadScene("Equipment", ViewNavigator.VIEW_INVENTORY);
		return this;
	}	
	@FXML
	public Object resume()
	{
		ViewNavigator.loadScene(ViewNavigator.prevTitle, ViewNavigator.prevScene);
		return this;
	}	
	@FXML
	public void save()
	{
		ViewNavigator.loadScene("Save Game", ViewNavigator.SAVE);
	}
	@FXML
	public void load()
	{
		ViewNavigator.loadScene("Load Game", ViewNavigator.LOAD);
	}
}
