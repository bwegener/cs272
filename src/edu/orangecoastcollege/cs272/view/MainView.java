package edu.orangecoastcollege.cs272.view;

import java.io.File;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MainView extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
		String musicFile = "Music/WarDemo.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString()); 
		MediaPlayer mediaPlayer = new MediaPlayer(sound); 
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
        ViewNavigator.setStage(primaryStage);
        ViewNavigator.loadScene("Title", ViewNavigator.TITLE);
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
