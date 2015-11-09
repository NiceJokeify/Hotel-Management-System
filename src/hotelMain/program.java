package hotelMain;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class program
{
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		//polymorphism
		//create object & print obj
		//Staff s1 = new RestaurantStaff();
		//System.out.println(s1.toString());
		PrintWriter writer;
		
		//start
		System.out.println("Enter s or c");
		
		Scanner console = new Scanner (System.in);
		char choice = console.next().charAt(0);
		
		switch(choice){
		case 's':
		case 'S':
			//code
			System.out.println("Enter a or r");
			console = new Scanner (System.in);
			char staffChoice = console.next().charAt(0);
			//start switch
			switch(staffChoice){
			case 'a':
			case 'A':
				//code
				System.out.println("Enter staff details: ");
				Staff s2 = new AccomodationStaff();
				System.out.println(s2.toString());
				//write to file
				writer = new PrintWriter("AccomodationStaff-" + s2.ID + ".txt", "UTF-8");
				writer.println(s2.toString());
				writer.close();
				break;
			case 'r':
			case 'R':
				//code
				Staff s3 = new RestaurantStaff();
				System.out.println(s3.toString());
				writer = new PrintWriter("RestaurantStaff" + s3.ID + ".txt", "UTF-8");
				writer.println(s3.toString());
				writer.close();
				break;
			} // end switch
			break;
		case 'c':
		case 'C':
			//code
			console = new Scanner (System.in);
			System.out.println("Name: ");
			String name = console.nextLine();
			System.out.println("Phone: ");
			int phone = Integer.parseInt(console.nextLine());
			System.out.println("Credit card: ");
			long creditcard = Long.parseLong(console.nextLine());
			Customer c1 = new Customer(name, phone, creditcard); // create customer
			
			System.out.println("How many days: ");
			int days = Integer.parseInt(console.nextLine());
			
			System.out.println("Room Type: (1) Standard, (2) Luxury");
			String roomTypeFromConsole = console.nextLine();
			String roomType = null;
			// if 
			if(!isInteger(roomTypeFromConsole)){
				while(!isInteger(roomTypeFromConsole)){
					System.out.println("Room Type: (1) Standard, (2) Luxury");
					roomTypeFromConsole = console.nextLine();
				}
			} 
			if(isInteger(roomTypeFromConsole)){
				int roomTypeN = Integer.parseInt(roomTypeFromConsole);
				if(roomTypeN==1){
					roomType = "Standard";
				} else if(roomTypeN==2){
					roomType = "Luxury";
				}
			}
			//
			
			
			System.out.println("Room Size: (1) Small, (2) Medium, (3) Suite");
			String roomSizeFromConsole = console.nextLine();
			String roomSize = null;
			if(!isInteger(roomSizeFromConsole)){
				while(!isInteger(roomSizeFromConsole)){
					System.out.println("Room Size: (1) Small, (2) Medium, (3) Suite");
					roomTypeFromConsole = console.nextLine();
				}
			} 
			if(isInteger(roomSizeFromConsole)){
				int roomSizeN = Integer.parseInt(roomSizeFromConsole);
				if(roomSizeN==1){
					roomSize = "Small";
				} else if(roomSizeN==2){
					roomSize = "Medium";
				} else if(roomSizeN==3){
					roomSize = "Suite";
				}
			}
			//
			
			System.out.println("Services: (1) Breakfast, (2) Half-Board, (3) All-inclusive");
			String servicesFromConsole = console.nextLine();
			String services = null;
			if(!isInteger(servicesFromConsole)){
				while(!isInteger(servicesFromConsole)){
					System.out.println("Services: (1) Breakfast, (2) Half-Board, (3) All-inclusive");
					servicesFromConsole = console.nextLine();
				}
			} 
			if(isInteger(servicesFromConsole)){
				int servicesN = Integer.parseInt(servicesFromConsole);
				if(servicesN==1){
					services = "Breakfast";
				} else if(servicesN==2){
					services = "Half-Board";
				} else if(servicesN==3){
					services = "All-inclusive";
				}
			}
			//
			
			
			Reservation r = new Reservation(days, roomType, roomSize, services, c1); // create reservation
			System.out.println(r.toString());
			writer = new PrintWriter("Customer-" + c1.getName() + ".txt", "UTF-8");
			writer.println(r.toString());
			writer.close();
			
			break;
		}
		
		//System.out.println(choice);
		//Staff s2 = new AccomodationStaff();
		//System.out.println(s2.toString());
		/*
		 * 
		 * PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
writer.println("The first line");
writer.println("The second line");
writer.close();*/
		
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}

}
