package edu.orangecoastcollege.cs272.model;

/**
 * This class creates the attacks which are pulled
 * from the csv files and put into the database
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class Attack {
	private int mId;
	private String mName;
	private int mStrengthRequired;
	private int mDexterityRequired;
	private int mIntellectRequired;
	private int mDamage;
	
	/**
	 * This constructor creates the attack with an id, name, strengthRequired, dexterityRequired, intellectRequired, and damge
	 * @param id
	 * @param name
	 * @param strengthRequired
	 * @param dexterityRequired
	 * @param intellectRequired
	 * @param damage
	 */
	public Attack(int id, String name, int strengthRequired, int dexterityRequired, int intellectRequired, int damage)
	{
		super();
		mId = id;
		mName = name;
		mStrengthRequired = strengthRequired;
		mDexterityRequired = dexterityRequired;
		mIntellectRequired = intellectRequired;
		mDamage = damage;
	}

	/**
	 * This gets the ID of the attack
	 * @return the ID of the attack
	 */
	public int getId() {
		return mId;
	}

	/**
	 * This gets the name of the attack
	 * @return the name of the attack
	 */
	public String getName() {
		return mName;
	}

	/**
	 * This gets the strengthRequired for an attack
	 * @return the strengthRequired
	 */
	public int getStrengthRequired() {
		return mStrengthRequired;
	}

	/**
	 * This gets the dexterityRequired for an attack
	 * @return the dexterityRequired
	 */
	public int getDexterityRequired() {
		return mDexterityRequired;
	}

	/**
	 * This gets the intellectRequired for an attack
	 * @return the intellectRequired
	 */
	public int getIntellectRequired() {
		return mIntellectRequired;
	}

	/**
	 * This gets the damage output of an attack
	 * @return the damage of an attack
	 */
	public int getDamage() {
		return mDamage;
	}

	/**
	 * Sets the id for an attack
	 * @param id
	 */
	public void setId(int id) {
		mId = id;
	}

	/**
	 * Sets the name for an attack
	 * @param name
	 */
	public void setName(String name) {
		mName = name;
	}

	/**
	 * Sets the strengthRequired for an attack
	 * @param strengthRequired
	 */
	public void setStrengthRequired(int strengthRequired) {
		mStrengthRequired = strengthRequired;
	}

	/**
	 * Sets the dexterityRequired for an attack
	 * @param dexterityRequired
	 */
	public void setDexterityRequired(int dexterityRequired) {
		mDexterityRequired = dexterityRequired;
	}

	/**
	 * Sets the intellectRequired for an attack
	 * @param intellectRequired
	 */
	public void setIntellectRequired(int intellectRequired) {
		mIntellectRequired = intellectRequired;
	}

	/**
	 * Sets the damage of an attack
	 * @param damage
	 */
	public void setDamage(int damage) {
		mDamage = damage;
	}

	/**
	 * This is the hashCode it does something
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mDamage;
		result = prime * result + mDexterityRequired;
		result = prime * result + mId;
		result = prime * result + mIntellectRequired;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + mStrengthRequired;
		return result;
	}

	/**
	 * This checks if one attack is equal to another
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attack other = (Attack) obj;
		if (mDamage != other.mDamage)
			return false;
		if (mDexterityRequired != other.mDexterityRequired)
			return false;
		if (mId != other.mId)
			return false;
		if (mIntellectRequired != other.mIntellectRequired)
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mStrengthRequired != other.mStrengthRequired)
			return false;
		return true;
	}

	/**
	 * This toString prints out the id, name, strength, dexterity and intellect required for an attack, and the damage of an attack
	 */
	@Override
	public String toString() {
		return "Attack [mId=" + mId + ", mName=" + mName + ", mStrengthRequired=" + mStrengthRequired
				+ ", mDexterityRequired=" + mDexterityRequired + ", mIntellectRequired=" + mIntellectRequired
				+ ", mDamage=" + mDamage + "]";
	}

}