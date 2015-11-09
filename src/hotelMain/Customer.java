package hotelMain;

public class Customer
{
	//data variables
	String name;
	int phoneNumber;
	long creditCardNo;
	
	public Customer(String name, int pn, long cc){
		this.name = name;
		this.phoneNumber = pn;
		this.creditCardNo = cc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(int creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public String toString() {
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber
				+ ", creditCardNo=" + creditCardNo + "]";
	}
	
	
	
	
}
