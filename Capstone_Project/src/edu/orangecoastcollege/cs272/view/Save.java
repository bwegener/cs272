package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
/**
 * Duong Tran
 * May 20, 2017
 * @author Duong
 *
 */
public class Save {
	private Controller controller = Controller.getInstance();
	private String name = CharacterCreator.currentPlayer.getName();
	private int strStat = CharacterCreator.currentPlayer.getStrength();
	private int dexStat = CharacterCreator.currentPlayer.getDexterity();
	private int intStat = CharacterCreator.currentPlayer.getIntellect();
	private String face = CharacterCreator.currentPlayer.getFace();

	@FXML
	public Object save1()
	{
		Player save1 = new Player(1, name, strStat, dexStat, intStat, face);
		return this;
	}
	
	@FXML
	public Object save2()
	{
		Player save2 = new Player(2, name, strStat, dexStat, intStat, face);
		return this;
	}
	
	@FXML
	public Object save3()
	{
		Player save3 = new Player(3, name, strStat, dexStat, intStat, face);
		return this;
	}
	
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}
}
