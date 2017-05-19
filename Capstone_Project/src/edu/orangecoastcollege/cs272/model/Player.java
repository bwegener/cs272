package edu.orangecoastcollege.cs272.model;

/**
 * Tran Duong
 * CS272
 * May 3, 2017
 * The <code>Mob</code> 
 *
 * @author Duong
 *
 */
public class Player {
	private int mID;
	private String mName;
	private int mIntStat;
	private int mStrStat;
	private int mDexStat;
	private int mFullHealth;
	private int mCurrentHealth;

	/**
	 * Retrieve the ID of the mob or player object
	 * @return
	 */
	public int getID(){
		return mID;
	}
	/**
	 * Retrieve the Name of the mob or player object
	 * @return
	 */
	public String getName() {
		return mName;
	}
	/**
	 * Retrieve the Int stat from the mob or player object
	 * @return
	 */
	public int getIntStat() {
		return mIntStat;
	}
	/**
	 * Retrieve the Str stat from the mob or player object
	 * @return
	 */
	public int getStrStat() {
		return mStrStat;
	}
	/**
	 * Retrieve the Dex stat from the mob or player object
	 * @return
	 */
	public int getDexStat() {
		return mDexStat;
	}
	/**
	 * Get the health of the player or enemy
	 * @return
	 */
	public int getFullHealth() {
		
		return mFullHealth;
	}
	/**
	 * Set the int stat of the mob or player object
	 * @param intStat
	 */
	public void setIntStat(int intStat) {
		mIntStat = intStat;
	}
	/**
	 * Set the Str stat of the mob or player object
	 * @param strStat
	 */
	public void setStrStat(int strStat) {
		mStrStat = strStat;
		this.calculateHealth();
	}
	/**
	 * Set the Dex stat of the mob or player object
	 * @param dexStat
	 */
	public void setDexStat(int dexStat) {
		mDexStat = dexStat;
		this.calculateHealth();
	}
	
	/**
	 * Used for the for the player.
	 * @param name of the mob or player
	 * @param level of the mob or player
	 * @param intStat stats used for damage calculations on spells
	 * @param strStat stats used for damage calculations on average or heavy physical weapons
	 * @param dexStat stats used for damage calculations on ranged or light weight weapons
	 */
	public Player(int id, String name, int intStat, int strStat, int dexStat){
		mID = id;
		mName = name;
		mIntStat = intStat;
		mStrStat = strStat;
		mDexStat = dexStat;
		mFullHealth = this.calculateHealth();
		mCurrentHealth = mFullHealth;
	}
	/**
	 * Fully Heal mob with one command
	 */
	public void fullHeal(){
		mCurrentHealth = mFullHealth;
	}
	/**
	 * Increase the mob dex by one
	 * @return
	 */
	public void dexUp(){
		mDexStat += 1;
		this.calculateHealth();
	}
	/**
	 * Increase the mob str by one
	 * @return
	 */
	public void strUp(){
		mStrStat += 1;
		this.calculateHealth();
	}
	/**
	 * Increase the player's health by a numerical ammount
	 * use a negative number to lower health
	 * @param healthChange
	 * @return
	 */
	public int gainHealth(int healthChange){
		mCurrentHealth += healthChange;
		return mCurrentHealth;
	}
	private int calculateHealth(){
		return mStrStat + mIntStat + mDexStat;
		
	}
	public String toString() {
		return "Name: " + mName + "\nInt: " + mIntStat + "\nStr: " + mStrStat
				+ "\nDexStat: " + mDexStat + "\nHealth: " + mCurrentHealth;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCurrentHealth;
		result = prime * result + mDexStat;
		result = prime * result + mFullHealth;
		result = prime * result + mID;
		result = prime * result + mIntStat;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + mStrStat;
		return result;
	}
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
		if (mID != other.mID)
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
