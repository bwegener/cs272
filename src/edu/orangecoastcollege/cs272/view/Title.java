package edu.orangecoastcollege.cs272.view;

import java.io.File;


import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Player;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Title {

    Controller controller = Controller.getInstance();
   
	@FXML
	public Object start()
	{
		String musicFile = "Music/SummertimeDog.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString()); 
		MediaPlayer mediaPlayer = new MediaPlayer(sound); 
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();

		controller.setCurrentPlayer(new Player());
		ViewNavigator.loadScene("Load", ViewNavigator.CHARACTER_CREATOR);
		return this;
	}
	@FXML
	public Object Load()
	{
		ViewNavigator.prevScene = ViewNavigator.TITLE;
		ViewNavigator.loadScene("Load", ViewNavigator.LOAD);
		return this;
	}
	@FXML
	public Object quit()
	{
		System.exit(0);
		return null;
	}
	
	/*
	@FXML
	public Object databases()
	{
		ViewNavigator.prevScene = ViewNavigator.TITLE;
		ViewNavigator.prevTitle = "Title";
		ViewNavigator.loadScene("Databases",  ViewNavigator.DATABASES);
		return this;
	}
	*/
	
}
