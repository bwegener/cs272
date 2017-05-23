package edu.orangecoastcollege.cs272.model;

public class Attack {
	private int mId;
	private String mName;
	private int mStrengthRequired;
	private int mDexterityRequired;
	private int mIntellectRequired;
	private int mDamage;
	
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

	public int getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}

	public int getStrengthRequired() {
		return mStrengthRequired;
	}

	public int getDexterityRequired() {
		return mDexterityRequired;
	}

	public int getIntellectRequired() {
		return mIntellectRequired;
	}

	public int getDamage() {
		return mDamage;
	}

	public void setId(int id) {
		mId = id;
	}

	public void setName(String name) {
		mName = name;
	}

	public void setStrengthRequired(int strengthRequired) {
		mStrengthRequired = strengthRequired;
	}

	public void setDexterityRequired(int dexterityRequired) {
		mDexterityRequired = dexterityRequired;
	}

	public void setIntellectRequired(int intellectRequired) {
		mIntellectRequired = intellectRequired;
	}

	public void setDamage(int damage) {
		mDamage = damage;
	}

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

	@Override
	public String toString() {
		return "Attack [mId=" + mId + ", mName=" + mName + ", mStrengthRequired=" + mStrengthRequired
				+ ", mDexterityRequired=" + mDexterityRequired + ", mIntellectRequired=" + mIntellectRequired
				+ ", mDamage=" + mDamage + "]";
	}

}