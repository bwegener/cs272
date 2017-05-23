package edu.orangecoastcollege.cs272.model;

/**
 * This class was created by Brian
 * updated by Khang
 * updated, ammended, and fixed by Duong
 * 
 * This is the enemy class with an enemy's id, name, damage, defense, and health
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class Enemy {

	private int mId;
	private String mName;
	private int mDamage;
	private int mDefense;
	private int mHealth;
	
	/**
	 * This constructor creates an enemy with an id, name, damage, defense, and health
	 * @param id
	 * @param name
	 * @param damage
	 * @param defense
	 * @param health
	 */
	public Enemy(int id, String name, int damage, int defense, int health)
	{
		super();
		mId = id;
		mName = name;
		mDamage = damage;
		mDefense = defense;
		mHealth = health;
	}

	/**
	 * This gets the id of the enemy
	 * @return the id of the enemy
	 */
	public int getId() {
		return mId;
	}

	/**
	 * This gets the name of the enemy
	 * @return the name of the enemy
	 */
	public String getName() {
		return mName;
	}

	/**
	 * This gets the damage of the enemy
	 * @return the damage of the enemy
	 */
	public int getDamage() {
		return mDamage;
	}

	/**
	 * This gets the defense of the enemy
	 * @return the defense of the enemy
	 */
	public int getDefense() {
		return mDefense;
	}

	/**
	 * This gets the health of the enemy
	 * @return the health of the enemy
	 */
	public int getHealth() {
		return mHealth;
	}

	/**
	 * Sets the name of the enemy
	 * @param name
	 */
	public void setName(String name) {	
		mName = name;
	}

	/**
	 * Sets the damage of the enemy
	 * @param damage
	 */
	public void setDamage(int damage) {
		mDamage = damage;
	}

	/**
	 * Sets the defense of the enemy
	 * @param defense
	 */
	public void setDefense(int defense) {
		mDefense = defense;
	}

	/**
	 * Sets the health of the enemy
	 * @param health
	 */
	public void setHealth(int health) {
		mHealth = health;
	}

	/**
	 * This is the hashcode
	 * It does something :)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mDamage;
		result = prime * result + mDefense;
		result = prime * result + mHealth;
		result = prime * result + mId;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		return result;
	}

	/**
	 * This checks to see if two enemies are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enemy other = (Enemy) obj;
		if (mDamage != other.mDamage)
			return false;
		if (mDefense != other.mDefense)
			return false;
		if (mHealth != other.mHealth)
			return false;
		if (mId != other.mId)
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		return true;
	}

	/**
	 * This is the toString it prints the enemy's id, name, damage, defense, and health
	 */
	@Override
	public String toString() {
		return "Enemy [mId=" + mId + ", mName=" + mName + ", mDamage=" + mDamage + ", mDefense=" + mDefense
				+ ", mHealth=" + mHealth + "]";
	}
	
}
