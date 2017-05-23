package edu.orangecoastcollege.cs272.view;

import java.io.File;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Created by Khang Nguyen
 * with some ammendments by Duong Tran and Brian Wegener
 * 
 * This JavaFX scene is the title screen and allows some music
 * to be played, however with the bugs it doesn't work out
 * like initially planned
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class Title {

    Controller controller = Controller.getInstance();
    
    @FXML
    private Label databaseErrorLabel;
   
    /**
     * This starts the game and loads music (thanks, Khang Nguyen)
     * sends the player to the character creator
     * @return
     */
	@FXML
	public Object start()
	{
		String musicFile = "Music/Cave.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString()); 
		MediaPlayer mediaPlayer = new MediaPlayer(sound); 
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
		controller.setCurrentPlayer(new Player());
		ViewNavigator.loadScene("Character Creator", ViewNavigator.CHARACTER_CREATOR);
		return this;
	}
	
	/**
	 * This sends the player to the load scene
	 * @return
	 */
	@FXML
	public Object Load()
	{
		ViewNavigator.prevScene = ViewNavigator.TITLE;
		ViewNavigator.loadScene("Load", ViewNavigator.LOAD);
		return this;
	}
	
	/**
	 * This quits the application
	 * @return
	 */
	@FXML
	public Object quit()
	{
		System.exit(0);
		return null;
	}
	
	/**
	 * This is something that I would like to finish in the future
	 * @return
	 */
	@FXML
	public Object databases()
	{
		databaseErrorLabel.setText("Database Screen Coming TBA");
		/*
		ViewNavigator.prevScene = ViewNavigator.TITLE;
		ViewNavigator.prevTitle = "Title";
		ViewNavigator.loadScene("Databases",  ViewNavigator.DATABASES);
		*/
		return null;
	}
	
}
