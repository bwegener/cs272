package edu.orangecoastcollege.cs272.controller;

import edu.orangecoastcollege.cs272.model.Player;

public class Controller {
	
	private static Controller theOne;
	
	private Player mCurrentPlayer;
	
	
	private Controller()
	{
		
	}
	
	public static Controller getInstance()
	{
		if(theOne == null)
		{
			theOne = new Controller();
		}
		
		return theOne;
	}
	
	
}
