package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

/**
 * Created by Brian Wegener
 * with some ammendments by Duong Tran and Khang Nguyen
 * 
 * This JavaFX scene is the last scene in the game when the characters
 * meet the person they are trying to find
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class BaseCamp {

	@FXML
	private Label intro;
	@FXML
	private Label maulding;
	@FXML
	private Button go;
	@FXML
	private Button end;
	@FXML
	private ImageView hoodedMan;
	@FXML
	private Shape rectangle;
	
	/**
	 * This moves the dialogue along and shows a new button
	 * @return
	 */
	@FXML 
	public Object go()
	{
		hoodedMan.setVisible(true);
		intro.setVisible(false);
		rectangle.setVisible(false);
		maulding.setVisible(true);
		go.setVisible(false);
		end.setVisible(true);
		return this;
	}
	
	/**
	 * This ends the game sending the player back to the title screen
	 * @return
	 */
	@FXML
	public Object end()
	{
        ViewNavigator.loadScene("A Knight's Quest", ViewNavigator.TITLE);
		return this;
	}
	
	/**
	 * This takes the player to the option scene
	 * @return
	 */
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.BASE_CAMP;
		ViewNavigator.prevTitle = "The End";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	/**
	 * This takes the player to the stat scene
	 * @return
	 */
	@FXML
	public Object statsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.BASE_CAMP;
		ViewNavigator.prevTitle = "The End";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}
	
	
}
