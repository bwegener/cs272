package edu.orangecoastcollege.cs272.model;

public class Enemy {

	private int mId;
	private String mName;
	private int mDamage;
	private int mDefense;
	private int mHealth;
	private String mEquipment;
	
	public Enemy(int id, String name, int damage, int defense, int health, String equipment)
	{
		super();
		mId = id;
		mName = name;
		mDamage = damage;
		mDefense = defense;
		mHealth = health;
		mEquipment = equipment;
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

	public int getHealth() {
		return mHealth;
	}

	public String getEquipment() {
		return mEquipment;
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

	public void setHealth(int health) {
		mHealth = health;
	}

	public void setEquipment(String equipment) {
		mEquipment = equipment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mDamage;
		result = prime * result + mDefense;
		result = prime * result + ((mEquipment == null) ? 0 : mEquipment.hashCode());
		result = prime * result + mHealth;
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
		Enemy other = (Enemy) obj;
		if (mDamage != other.mDamage)
			return false;
		if (mDefense != other.mDefense)
			return false;
		if (mEquipment == null) {
			if (other.mEquipment != null)
				return false;
		} else if (!mEquipment.equals(other.mEquipment))
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

	@Override
	public String toString() {
		return "Enemy [mId=" + mId + ", mName=" + mName + ", mDamage=" + mDamage + ", mDefense=" + mDefense
				+ ", mHealth=" + mHealth + ", mEquipment=" + mEquipment + "]";
	}
	
}
