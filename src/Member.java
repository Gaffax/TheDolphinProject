public class Member{
	//fields
	private int Id;
	private String name;
	private String birthday;
	private String registrationDate;
	private String hasPaidDate;//Needs to be changed to sub class.
	boolean getType;

	public Member(int Id, String name, String birthday, String registrationDate,
			String hasPaidDate, boolean getType) {

		//  This code equalize the fields with the member parameters.
		//  And is necessary to get the information from the object used in the metod
		this.Id = Id;
		this.name = name;
		this.birthday = birthday;
		this.registrationDate = registrationDate;
		this.hasPaidDate = hasPaidDate;
		this.getType = getType;
	}
	
	//operators
	
	//Getters
	public int getMemberId() {
		return Id;
	}
	
	public String getName() {
		return name;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public String getHasPaidDate() {
		return hasPaidDate;
	}

	public Boolean getType() {
		return getType;
	}

	//Setters
	public void setHasPaidDate(String hasPaidDate) {
		this.hasPaidDate = hasPaidDate;
	}	
	
	
}	
