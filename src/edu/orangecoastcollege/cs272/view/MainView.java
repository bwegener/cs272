package edu.orangecoastcollege.cs272.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ViewNavigator.setStage(primaryStage);
        ViewNavigator.loadScene("Character Creator", ViewNavigator.TITLE);
    }
    
    public static void main(String[] args)
    {
        launch(args);

    }
}
