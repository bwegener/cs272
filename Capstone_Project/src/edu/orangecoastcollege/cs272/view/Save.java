package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.fxml.FXML;
/**
 * Duong Tran
 * May 20, 2017
 * @author Duong
 *
 */
public class Save {
	Controller controller = Controller.getInstance();

	@FXML
	public Object save1()
	{
		controller.savePlayer(1);
		return this;
	}
	
	@FXML
	public Object save2()
	{
		controller.savePlayer(2);
		return this;
	}
	
	@FXML
	public Object save3()
	{
		controller.savePlayer(3);
		return this;
	}
	
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.loadScene(ViewNavigator.prevTitle, ViewNavigator.prevScene);
		return this;
	}
}
