package guiSystem;

public class customer {
	private int custId;
	private String firstName;
	private String lastName;
	
	public customer(int custId, String firstName, String lastName) {
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
