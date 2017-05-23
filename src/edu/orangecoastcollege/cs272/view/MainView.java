package edu.orangecoastcollege.cs272.view;


import javafx.application.Application;

import javafx.stage.Stage;

/**
 * Created by Brian Wegener
 * with some ammendments by Duong Tran and Khang Nguyen
 * 
 * This JavaFX scene is used to set up the entire application
 * it contacts the view navigator to get everything to run
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class MainView extends Application
{
	/**
	 * This starts the application
	 */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
    	/*
		String musicFile = "Music/Cave.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString()); 
		MediaPlayer mediaPlayer = new MediaPlayer(sound); 
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
		*/
        ViewNavigator.setStage(primaryStage);
        ViewNavigator.loadScene("A Knight's Quest", ViewNavigator.TITLE);
    }
    
    /**
     * Launches the application
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
