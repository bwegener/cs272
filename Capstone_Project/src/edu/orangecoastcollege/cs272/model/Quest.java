package edu.orangecoastcollege.cs272.model;

public class Quest {
	private int mId;
	private String mName;
	private String mCompletionRequirement;
	private String mDescription;
	
	public Quest(int id, String name, String completionRequirement, String description)
	{
		super();
		mId = id;
		mName = name;
		mCompletionRequirement = completionRequirement;
		mDescription = description;
	}

	public int getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}

	public String getCompletionRequirement() {
		return mCompletionRequirement;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setName(String name) {
		mName = name;
	}

	public void setCompletionRequirement(String completionRequirement) {
		mCompletionRequirement = completionRequirement;
	}

	public void setDescription(String description) {
		mDescription = description;
	}

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

	@Override
	public String toString() {
		return "Quest [mId=" + mId + ", mName=" + mName + ", mCompletionRequirement=" + mCompletionRequirement
				+ ", mDescription=" + mDescription + "]";
	}
	
	
}
