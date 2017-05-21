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
	public Equipment(int id, String name, int damage, int defense)
	{
		this(id, name, damage, defense, 0, 0, 0);
	}
	public Equipment(){
		this(0,"",0,0,0,0,0);
	}

	public int getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}

	public int getDamage() {
		return mDamage;
	}

	public int getDefense() {
		return mDefense;
	}

	public void setName(String name) {
		mName = name;
	}

	public void setDamage(int damage) {
		mDamage = damage;
	}

	public void setDefense(int defense) {
		mDefense = defense;
	}
	

	public int getStrength() {
		return mStrength;
	}
	public void setStrength(int mStrength) {
		this.mStrength = mStrength;
	}
	public int getDexterity() {
		return mDexterity;
	}
	public void setDexterity(int mDexterity) {
		this.mDexterity = mDexterity;
	}
	public int getIntellect() {
		return mIntellect;
	}
	public void setIntellect(int mIntellect) {
		this.mIntellect = mIntellect;
	}
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

	@Override
	public String toString() {
		return "Equipment [mId=" + mId + ", Name=" + mName + ", Damage=" + mDamage + ", Defense=" + mDefense+ ", Strength=" + mStrength + ", Dexterity=" + mDexterity
				+ ", Intellect=" + mIntellect + "]";
	}
	
}
