package edu.orangecoastcollege.cs272.model;

/**
 * This class was created by Brian Wegener
 * ammended by Khang Nguyen
 * updated and fixed by Duong Tran
 * 
 * This class creates a quest with an id, name, completionRequirement, and description
 * 
 * @author Brian Wegener, Duong Tran, Khang Nguyen
 * @version 1.0
 */
public class Quest {
	private int mId;
	private String mName;
	private String mCompletionRequirement;
	private String mDescription;
	
	/**
	 * This constructor allows for the instantiation of a quest with
	 * an id, name, completionRequirement, and description
	 * @param id
	 * @param name
	 * @param completionRequirement
	 * @param description
	 */
	public Quest(int id, String name, String completionRequirement, String description)
	{
		super();
		mId = id;
		mName = name;
		mCompletionRequirement = completionRequirement;
		mDescription = description;
	}

	/**
	 * Gets the id of the quest
	 * @return the quest id
	 */
	public int getId() {
		return mId;
	}

	/**
	 * Gets the name of the quest
	 * @return the name of the quest
	 */
	public String getName() {
		return mName;
	}

	/**
	 * Gets the completionRequirement for the quest
	 * @return the completionRequirement for the quest
	 */
	public String getCompletionRequirement() {
		return mCompletionRequirement;
	}

	/**
	 * This gets the description for the quest
	 * @return the description for the quest
	 */
	public String getDescription() {
		return mDescription;
	}

	/**
	 * This sets the name of the quest
	 * @param name
	 */
	public void setName(String name) {
		mName = name;
	}

	/**
	 * This sets the completionRequirement for the quest
	 * @param completionRequirement
	 */
	public void setCompletionRequirement(String completionRequirement) {
		mCompletionRequirement = completionRequirement;
	}

	/**
	 * Sets the description for the quest
	 * @param description
	 */
	public void setDescription(String description) {
		mDescription = description;
	}

	/**
	 * This is the hash code
	 * It does something :)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mCompletionRequirement == null) ? 0 : mCompletionRequirement.hashCode());
		result = prime * result + ((mDescription == null) ? 0 : mDescription.hashCode());
		result = prime * result + mId;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		return result;
	}

	/**
	 * This checks to see if two quest objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quest other = (Quest) obj;
		if (mCompletionRequirement == null) {
			if (other.mCompletionRequirement != null)
				return false;
		} else if (!mCompletionRequirement.equals(other.mCompletionRequirement))
			return false;
		if (mDescription == null) {
			if (other.mDescription != null)
				return false;
		} else if (!mDescription.equals(other.mDescription))
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
	 * This prints a toString with the quest id, name, completionRequirement, and description
	 */
	@Override
	public String toString() {
		return "Quest [mId=" + mId + ", mName=" + mName + ", mCompletionRequirement=" + mCompletionRequirement
				+ ", mDescription=" + mDescription + "]";
	}
	
	
}
