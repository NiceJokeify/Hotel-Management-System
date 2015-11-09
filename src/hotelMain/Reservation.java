package hotelMain;

import java.util.Random;

public class Reservation {
	
	int days = 0;
	String roomType;
	String roomSize;
	String services;
	int roomNumber;
	float price = 0;
	Customer customer;
	
	
	public Reservation(int days, String roomType, String roomSize, String services, Customer c){
		this.days = days;
		this.roomType = roomType;
		this.roomSize = roomSize;
		this.services = services;
		this.customer = c;
		Random rand = new Random();
	    int max = 400;
		int min = 100;
		int randomNum = rand.nextInt((max - min) + 1) + min;
		this.roomNumber = randomNum;
		calculatePrice();
	}

	private void calculatePrice() {
		// TODO Auto-generated method stub
		//room type price
		
		
		if(roomType.equals("Standard")){
			this.price += 150;
			this.price += this.days*50;
		} else if(roomType.equals("Luxury")) {
			this.price += 500;
			this.price += this.days*100;
		}
		
		//room size
		/*if(roomType.equals("Standard")){
			price += 150;
		} else if(roomType.equals("Luxury")) {
			price += 500;
		} else if(roomType.equals("Luxury")) {
			price += 500;
		}*/
	}
	
	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String toString() {
		return "Reservation: \n" + 
				"Name: " + customer.name + "\n" + 
				"Phone: " + customer.phoneNumber + "\n" + 
				"Credit Card: " + customer.creditCardNo+"\n" +
				"----------- \n" +
				"Days Reserved: " + days + "\n" +
				"Room Type: " + roomType + "\n" +
				"Room Size: " +  roomSize + "\n" +
				"Services: " + services + "\n" + 
				"Price: " + price;
	}

}
