package hotelMain;

import java.util.Scanner;

public abstract class Staff 
{
	//Data Variables
	String name;
	int ID;
	
	Scanner console = new Scanner (System.in);
	
	//constructor
	Staff()
	{
		name = getName();
		ID = getID();
	}
	
	//methods
	public String getName()
	{
		System.out.print("Name: ");
		name = console.nextLine();
		
		return name;	
	}
	
	public int getID()
	{
		System.out.print("ID: ");
		ID = console.nextInt();
		
		return ID;
	}
	
	//abstract method
	public abstract double getBonus(double netPay);
	
	//toString
	public String toString()
	{
		String str;
		
		str = "\nName: " + name + "\n";
		str += "ID: " + ID + "\n";
		
		return str;
	}
}
