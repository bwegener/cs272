package edu.orangecoastcollege.cs272.model;

/**
 * Created by Brian Wegener
 * Last Edited by: Duong Tran
 * 
 * This class creates a player with an id, name, intellectStat, strengthStat, dexterityStat, fullHeatlh, currentHealth, and image for face
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class Player {
	private int mId;
	private String mName;
	private int mIntStat;
	private int mStrStat;
	private int mDexStat;
	private int mFullHealth;
	private int mCurrentHealth;
	private String mFace;

	/**
	 * Retrieve the ID of the mob or player object
	 * 
	 * @return
	 */
	public int getID() {
		return mId;
	}

	/**
	 * Retrieve the Name of the mob or player object
	 * 
	 * @return
	 */
	public String getName() {
		return mName;
	}

	/**
	 * Retrieve the Int stat from the mob or player object
	 * 
	 * @return
	 */
	public int getIntellect() {
		return mIntStat;
	}

	/**
	 * Retrieve the Str stat from the mob or player object
	 * 
	 * @return
	 */
	public int getStrength() {
		return mStrStat;
	}

	/**
	 * Retrieve the Dex stat from the mob or player object
	 * 
	 * @return
	 */
	public int getDexterity() {
		return mDexStat;
	}

	/**
	 * Get the health of the player or enemy
	 * 
	 * @return
	 */
	public int getHealth() {
		return mFullHealth;
	}

	/**
	 * Get the face image of the player
	 * 
	 * @return
	 */
	public String getFace() {
		return mFace;
	}

	/**
	 * Set the int stat of the mob or player object
	 * 
	 * @param intStat
	 */
	public void setName(String name) {
		mName = name;
	}

	/**
	 * Set the int stat of the mob or player object
	 * 
	 * @param intStat
	 */
	public void setIntellect(int intStat) {
		mIntStat = intStat;
	}

	/**
	 * Set the Str stat of the mob or player object
	 * 
	 * @param strStat
	 */
	public void setStrength(int strStat) {
		mStrStat = strStat;
		this.calculateHealth();
	}

	/**
	 * Set the Dex stat of the mob or player object
	 * 
	 * @param dexStat
	 */
	public void setDexterity(int dexStat) {
		mDexStat = dexStat;
		this.calculateHealth();
	}

	public void setFace(String newFace) {
		mFace = newFace;
	}

	public Player() {
		mId = 1;
		mName = "dummyName";
		mStrStat = 5;
		mDexStat = 5;
		mIntStat = 5;
		mFullHealth = 15;
		mFace = "Images/face1.jpeg";
	}

	/**
	 * Used for the for the player.
	 * 
	 * @param name
	 *            of the mob or player
	 * @param level
	 *            of the mob or player
	 * @param intStat
	 *            stats used for damage calculations on spells
	 * @param strStat
	 *            stats used for damage calculations on average or heavy
	 *            physical weapons
	 * @param dexStat
	 *            stats used for damage calculations on ranged or light weight
	 *            weapons
	 */
	public Player(int id, String name, int intStat, int strStat, int dexStat) {
		mId = id;
		mName = name;
		mIntStat = intStat;
		mStrStat = strStat;
		mDexStat = dexStat;
		mFullHealth = this.calculateHealth();
		mCurrentHealth = mFullHealth;
		mFace = "Images/face1.jpeg";
	}

	/**
	 * Used for the for the player.
	 * 
	 * @param name
	 *            of the mob or player
	 * @param level
	 *            of the mob or player
	 * @param intStat
	 *            stats used for damage calculations on spells
	 * @param strStat
	 *            stats used for damage calculations on average or heavy
	 *            physical weapons
	 * @param dexStat
	 *            stats used for damage calculations on ranged or light weight
	 *            weapons
	 */
	public Player(int id, String name, int intStat, int strStat, int dexStat, String face) {
		mId = id;
		mName = name;
		mIntStat = intStat;
		mStrStat = strStat;
		mDexStat = dexStat;
		mFullHealth = this.calculateHealth();
		mCurrentHealth = mFullHealth;
		mFace = face;
	}

	/**
	 * Fully Heal mob with one command
	 */
	public void fullHeal() {
		mCurrentHealth = mFullHealth;
	}

	/**
	 * Increase the mob int by one
	 * 
	 * @return
	 */
	public void intUp() {
		mIntStat += 1;
		this.calculateHealth();
	}

	/**
	 * Increase the mob dex by one
	 * 
	 * @return
	 */
	public void dexUp() {
		mDexStat += 1;
		this.calculateHealth();
	}

	/**
	 * Increase the mob str by one
	 * 
	 * @return
	 */
	public void strUp() {
		mStrStat += 1;
		this.calculateHealth();
	}

	/**
	 * Decrease the mob int by one
	 * 
	 * @return
	 */
	public void intDown() {
		mIntStat -= 1;
		this.calculateHealth();
	}

	/**
	 * Decrease the mob dex by one
	 * 
	 * @return
	 */
	public void dexDown() {
		mDexStat -= 1;
		this.calculateHealth();
	}

	/**
	 * Decrease the mob str by one
	 * 
	 * @return
	 */
	public void strDown() {
		mStrStat -= 1;
		this.calculateHealth();
	}

	/**
	 * Increase the player's health by a numerical ammount use a negative number
	 * to lower health
	 * 
	 * @param healthChange
	 * @return
	 */
	public int gainHealth(int healthChange) {
		mCurrentHealth += healthChange;
		return mCurrentHealth;
	}
	
	private int calculateHealth() {
		return mStrStat + mIntStat + mDexStat;
	}

	/**
	 * This prints the toString with a name, intellect, strength, dexterity stat, health, and appearance
	 */
	public String toString() {
		return "Name: " + mName + "\nInt: " + mIntStat + "\nStr: " + mStrStat + "\nDexStat: " + mDexStat + "\nHealth: "
				+ mCurrentHealth + "\nAppearance " + mFace;
	}

	/**
	 * This is the hash code
	 * It does something :)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCurrentHealth;
		result = prime * result + mDexStat;
		result = prime * result + mFullHealth;
		result = prime * result + mId;
		result = prime * result + mIntStat;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + mStrStat;
		return result;
	}

	/**
	 * This checks to see if two players are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (mCurrentHealth != other.mCurrentHealth)
			return false;
		if (mDexStat != other.mDexStat)
			return false;
		if (mFullHealth != other.mFullHealth)
			return false;
		if (mId != other.mId)
			return false;
		if (mIntStat != other.mIntStat)
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mStrStat != other.mStrStat)
			return false;
		return true;
	}
}