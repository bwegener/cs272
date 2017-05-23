package edu.orangecoastcollege.cs272.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;

public class CombatForest implements Initializable {
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
	private Label runText;
	@FXML
	private Label fightText;
	@FXML
	private Label talkText;
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	if(controller.getCurrentPlayer().getDexterity() >= 8){
    		sneakButton.setVisible(true);
    	}
    }
	
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.COMBAT_FOREST;
		ViewNavigator.prevTitle = "Combat";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	@FXML
	public Object statsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.COMBAT_FOREST;
		ViewNavigator.prevTitle = "Combat";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}
	
	@FXML
	public Object fight()
	{
		preBattleText.setVisible(false);
		fightText.setVisible(true);
		fightButton.setVisible(false);
		runButton.setVisible(false);
		talkButton.setVisible(false);
		okButton.setVisible(true);
		
		return this;	
	}
	
	@FXML
	public Object run()
	{
		preBattleText.setVisible(false);
		runText.setVisible(true);
		fightButton.setVisible(false);
		runButton.setVisible(false);
		talkButton.setVisible(false);
		goButton.setVisible(true);
		return this;
	}
	
	@FXML
	public Object talk()
	{
		preBattleText.setVisible(false);
		talkText.setVisible(true);
		runButton.setVisible(false);
		fightButton.setVisible(false);
		talkButton.setVisible(false);
		okButton.setVisible(true);
		return this;
	}
	
	@FXML
	public Object go()
	{
		ViewNavigator.loadScene("A Village Approacheth", ViewNavigator.VILLAGE);
		return this;	
		}
	
	@FXML
	public Object ok()
	{
		System.exit(0);
		return this;
	}
}
