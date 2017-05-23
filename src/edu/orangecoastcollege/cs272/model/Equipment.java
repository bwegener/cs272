package edu.orangecoastcollege.cs272.model;
/*
 * Created by Khang, and Brian
 * Merged and updated by Duong Tran
 * May 20, 2017
 */
public class Equipment {
	private int mId;
	private String mName;
	private int mDamage;
	private int mDefense;
	private int mStrength;
	private int mDexterity;
	private int mIntellect;

	/**
	 * This constructor creates equipment with an id, name, damage, defense, strength, dexterity, and intellect
	 * @param id
	 * @param name
	 * @param damage
	 * @param defense
	 * @param mStrength
	 * @param mDexterity
	 * @param mIntellect
	 */
	public Equipment(int id, String name, int damage, int defense, int mStrength, int mDexterity, int mIntellect) {

		super();
		mId = id;
		mName = name;
		mDamage = damage;
		mDefense = defense;
		this.mStrength = mStrength;
		this.mDexterity = mDexterity;
		this.mIntellect = mIntellect;
	}
	/**
	 * This default constructor creates a default piece of equipment
	 * @param id
	 * @param name
	 * @param damage
	 * @param defense
	 */
	public Equipment(int id, String name, int damage, int defense)
	{
		this(id, name, damage, defense, 0, 0, 0);
	}
	/**
	 * This second default constructor defaults everything to 0
	 */
	public Equipment(){
		this(0,"",0,0,0,0,0);
	}

	/**
	 * This gets the id of a piece of equipment
	 * @return
	 */
	public int getId() {
		return mId;
	}

	/**
	 * This gets the name of a piece of equipment
	 * @return
	 */
	public String getName() {
		return mName;
	}

	/**
	 * This gets the damage of a piece of equipment
	 * @return
	 */
	public int getDamage() {
		return mDamage;
	}

	/**
	 * This gets the defense of a piece of equipment
	 * @return
	 */
	public int getDefense() {
		return mDefense;
	}

	/**
	 * This sets the name of the piece of equipment
	 * @param name
	 */
	public void setName(String name) {
		mName = name;
	}

	/**
	 * This sets the damage of a piece of equipment
	 * @param damage
	 */
	public void setDamage(int damage) {
		mDamage = damage;
	}

	/**
	 * This sets the defense of a piece of equipment
	 * @param defense
	 */
	public void setDefense(int defense) {
		mDefense = defense;
	}
	
	/**
	 * This gets the strength of a piece of equipment
	 * @return the strength of a piece of equipment
	 */
	public int getStrength() {
		return mStrength;
	}
	/**
	 * This sets the strength of a piece of equipment
	 * @param mStrength
	 */
	public void setStrength(int mStrength) {
		this.mStrength = mStrength;
	}
	/**
	 * This gets the dexterity of a piece of equipment
	 * @return the dexterity of a piece of equipment
	 */
	public int getDexterity() {
		return mDexterity;
	}
	/**
	 * This sets the dexterity of a piece of equipment
	 * @param mDexterity
	 */
	public void setDexterity(int mDexterity) {
		this.mDexterity = mDexterity;
	}
	/**
	 * This gets the intellect of a piece of equipment
	 * @return the intellect of a piece of equipment
	 */
	public int getIntellect() {
		return mIntellect;
	}
	/**
	 * This sets the intellect of a piece of equipment
	 * @param mIntellect
	 */
	public void setIntellect(int mIntellect) {
		this.mIntellect = mIntellect;
	}
	
	/**
	 * This is the hash code
	 * It does something :)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mDamage;
		result = prime * result + mDefense;
		result = prime * result + mId;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + mIntellect;
		result = prime * result + mDexterity;
		result = prime * result + mStrength;
		return result;
	}

	/**
	 * This checks to see if two pieces of equipment are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment other = (Equipment) obj;
		if (mDamage != other.mDamage)
			return false;
		if (mDefense != other.mDefense)
			return false;
		if (mId != other.mId)
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mStrength != other.mStrength)
			return false;
		if (mDexterity != other.mDexterity)
			return false;
		if (mIntellect != other.mIntellect)
			return false;
		return true;
	}

	/**
	 * This prints a piece of equipment with a name, damage, defense, strength, dexterity, and intellect
	 */
	@Override
	public String toString() {
		return mName + ", Damage:" + mDamage + ", Defense:" + mDefense+ ", Strength:" + mStrength + ", Dexterity:" + mDexterity
				+ ", Intellect:" + mIntellect;
	}
	
}
