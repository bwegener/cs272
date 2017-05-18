package edu.orangecoastcollege.cs272.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewNavigator {
	
	
	// TO ADD MUSIC TO SCENES
	//  static final String COMBAT_FOREST_PATH = "mp3/MUSIC.mp3";
	//  static final String INTRO_FOREST_PATH = "mp3/MUSIC2.mp3"

	/*
      Media song = new Media(new File(MainView.COMBAT_FOREST_PATH).toURI().toString());
      MediaPlayer player = new MediaPlayer(song);
      player.setVolume(50);
      player.setAutoPlay(true);
      player.setOnEndOfMedia(new Runnable)
      {
          public void run() {
              player.seek(Duration.ZERO);
          }
      }
	*/
	
	// This is where I put the different scenes
	public static final String CHARACTER_CREATOR = "CharacterCreator.fxml";
	public static final String OPTIONS_SCENE = "OptionsScene.fxml";
	public static final String INTRO_FOREST = "IntroForest.fxml";
	public static final String FOREST_SCENE_2 = "ForestScene2.fxml";
	public static final String COMBAT_FOREST = "CombatForest.fxml";
	public static final String VILLAGE = "Village.fxml";
	
	public static Stage mainStage;
	public static String prevScene;
	public static String prevTitle;
	
	public static void setStage(Stage stage)
	{
		mainStage = stage;
	}
	
	
	public static void loadScene(String title, String sceneFXML)
	{
		try {
			mainStage.setTitle(title);
			Scene scene = new Scene(FXMLLoader.load(ViewNavigator.class.getResource(sceneFXML)));
			mainStage.setScene(scene);
			mainStage.show();
		}
		catch (IOException e)
		{
			System.err.println("Error loading: " + sceneFXML + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	
}
