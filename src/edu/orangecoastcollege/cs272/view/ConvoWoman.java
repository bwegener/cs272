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
 * This JavaFX scene was supposed to be a robust converation
 * between a woman in the village, however due to time constraints
 * most of the plans had to be scrapped
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class ConvoWoman {

	@FXML
	private Button examine;
	@FXML
	private Button no;
	@FXML
	private Button yes;
	@FXML
	private Button ok;
	@FXML
	private Button go;
	@FXML
	private ImageView jorts;
	@FXML
	private Label line1;
	@FXML
	private Label line2;
	@FXML
	private Label line3No;
	@FXML
	private Label line3Yes;
	@FXML
	private Label line4;
	@FXML
	private Shape rectangle;
	
	/**
	 * This method allows the second line of dialogue to be 
	 * displayed and changes the buttons
	 * @return
	 */
	@FXML
	public Object line2()
	{
		line1.setVisible(false);
		line2.setVisible(true);
		examine.setVisible(false);
		jorts.setVisible(true);
		rectangle.setVisible(true);
		no.setVisible(true);
		yes.setVisible(true);
		
		return this;
	}
	
	/**
	 * This method is called if the player answers "no"
	 * @return
	 */
	@FXML
	public Object line3No()
	{
		line2.setVisible(false);
		no.setVisible(false);
		yes.setVisible(false);
		jorts.setVisible(false);
		rectangle.setVisible(false);
		line3No.setVisible(true);
		ok.setVisible(true);
		return this;
	}
	
	/**
	 * This method is called if the player answers "yes"
	 * @return
	 */
	@FXML
	public Object line3Yes()
	{
		line2.setVisible(false);
		no.setVisible(false);
		yes.setVisible(false);
		jorts.setVisible(false);
		rectangle.setVisible(false);
		line3Yes.setVisible(true);
		ok.setVisible(true);
		return this;
	}
	
	/**
	 * This sends the player to the fourth line of dialogue
	 * @return
	 */
	@FXML
	public Object ok()
	{
		line3Yes.setVisible(false);
		line3No.setVisible(false);
		line4.setVisible(true);
		ok.setVisible(false);
		go.setVisible(true);
		return this;
	}
	
	/**
	 * This sends the player to the second to last scene of the game
	 * @return
	 */
	@FXML
	public Object go()
	{
		ViewNavigator.loadScene("The Summit", ViewNavigator.BASE_OF_MOUNTAIN);
		return this;
	}
	
	/**
	 * This takes the player to the options scene
	 * @return
	 */
	@FXML
	public Object optionsScene()
	{
		ViewNavigator.prevScene = ViewNavigator.CONVO_WOMAN;
		ViewNavigator.prevTitle = "Conversation with a Farmer";
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
		ViewNavigator.prevScene = ViewNavigator.CONVO_WOMAN;
		ViewNavigator.prevTitle = "Conversation with a Farmer";
		ViewNavigator.loadScene("Player Stats", ViewNavigator.STATS_SCENE);
		return this;
	}
}
