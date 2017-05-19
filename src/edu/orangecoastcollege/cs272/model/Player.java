package edu.orangecoastcollege.cs272.model;

public class Player {
	private int mId;
	private String mName;
	private int mStrength;
	private int mDexterity;
	private int mIntellect;
	private int mHealth;

	public Player()
	{
	    mStrength = 5;
	    mDexterity = 5;
	    mIntellect = 5;
	    mHealth = 25;
	}

	public Player(int id, String name, int strength, int dexterity, int intellect, int health)
	{
		super();
		mId = id;
		mName = name;
		mStrength = strength;
		mDexterity = dexterity;
		mIntellect = intellect;
		mHealth = health;
	}

	public int getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}

	public int getStrength() {
		return mStrength;
	}

	public int getDexterity() {
		return mDexterity;
	}

	public int getIntellect() {
		return mIntellect;
	}

	public int getHealth()
	{
		return mHealth;
	}

	public void setName(String name) {
		mName = name;
	}

	public void setStrength(int strength) {
		mStrength = strength;
	}

	public void setDexterity(int dexterity) {
		mDexterity = dexterity;
	}

	public void setIntellect(int intellect) {
		mIntellect = intellect;
	}

	public void setHealth(int health) {
		mHealth = health;
	}

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + mDexterity;
        result = prime * result + mHealth;
        result = prime * result + mId;
        result = prime * result + mIntellect;
        result = prime * result + ((mName == null) ? 0 : mName.hashCode());
        result = prime * result + mStrength;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Player other = (Player) obj;
        if (mDexterity != other.mDexterity) return false;
        if (mHealth != other.mHealth) return false;
        if (mId != other.mId) return false;
        if (mIntellect != other.mIntellect) return false;
        if (mName == null)
        {
            if (other.mName != null) return false;
        }
        else if (!mName.equals(other.mName)) return false;
        if (mStrength != other.mStrength) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Player [mId=" + mId + ", mName=" + mName + ", mStrength=" + mStrength + ", mDexterity=" + mDexterity
                + ", mIntellect=" + mIntellect + ", mHealth=" + mHealth + "]";
    }

}
