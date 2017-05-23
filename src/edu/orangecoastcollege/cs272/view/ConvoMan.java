package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

/**
 * Created by Brian Wegener
 * with some ammendments by Duong Tran and Khang Nguyen
 * 
 * This JavaFX scene is a simple scene where the player
 * would talk to a man in the village
 * however because of a running out of time most of the
 * dialogue and choice had to be scrapped
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class ConvoMan {
	
	/**
	 * This takes the player to the options scene
	 * @return
	 */
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.CONVO_MAN;
		ViewNavigator.prevTitle = "Conversation with a Gentleman";
		ViewNavigator.loadScene("Options", ViewNavigator.OPTIONS_SCENE);
		return this;
	}
	
	/**
	 * This takes the player to the stats scene
	 * @return
	 */
	@FXML
	public Object statsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.CONVO_MAN;
		ViewNavigator.prevTitle = "Conversation with a Gentleman";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}
	
	/**
	 * This sends the player to the base of the mountain
	 * @return
	 */
	@FXML
	public Object go()
	{
		ViewNavigator.loadScene("The Summit", ViewNavigator.BASE_OF_MOUNTAIN);
		return this;
	}

}
