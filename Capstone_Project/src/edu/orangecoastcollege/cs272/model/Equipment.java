package edu.orangecoastcollege.cs272.model;

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
		return true;
	}

	@Override
	public String toString() {
		return "Equipment [mId=" + mId + ", mName=" + mName + ", mDamage=" + mDamage + ", mDefense=" + mDefense + "]";
	}
	
}
