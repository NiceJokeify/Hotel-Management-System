package hotelMain;

import java.math.BigDecimal;
import java.util.Scanner;

public class AccomodationStaff extends Staff implements Tax
{
	//data variables
	final double PAYE_RATE = .12;
	final double PRSI_RATE = .08;
	int roomsCleaned;
	int stayRoom, depRoom;
	double stayRate = 4.20, depRate= 5.10;
	double wage;
	double paye;
	double prsi;
	double tax;
	double netPay;
	double bonus;
	double netAfterBonus;
	
	Scanner console = new Scanner (System.in);
	
	// constructor
	AccomodationStaff()
	{
		super();
		stayRoom = getStayRoom();
		depRoom = getDepRoom();
		wage = getWage(stayRoom, depRoom, stayRate, depRate);
		paye = getPAYE(wage, PAYE_RATE);
		prsi = getPrsi(wage, PRSI_RATE);
		tax = getTax(paye, prsi);
		netPay = getNetPay(wage, tax);
		bonus = getBonus(netPay);
		netAfterBonus = getWageAfterBonus(netPay, bonus);
	}
	
	//methods
	public int getStayRoom()
	{
		System.out.print("Stay Rooms Cleaned: ");
		stayRoom = console.nextInt();
		
		return stayRoom;
	}
	
	public int getDepRoom()
	{
		System.out.print("Departure Rooms Cleaned: ");
		depRoom = console.nextInt();
		
		return depRoom;
	}
	
	public double getWage(int stayRoom, int depRoom, double stayRate, double depRate)
	{
		roomsCleaned = stayRoom + depRoom;
		
		wage = (stayRoom * stayRate) + (depRoom * depRate);
		
		return wage;
	}
	
	public double getPAYE(double wage, double PAYE_RATE)
	{
		paye = wage * PAYE_RATE;
		
		return paye;
	}
	
	public double getPrsi(double wage, double PRSI_RATE)
	{
		prsi = wage * PRSI_RATE;
		
		return prsi;
	}
	
	private double getTax(double paye, double prsi)
	{
		tax = paye + prsi;
		
		return tax;
	}
	
	private double getNetPay(double wage, double tax)
	{
		netPay = wage - tax;
		
		return netPay;
	}
	
	//abstract
	public double getBonus(double netPay)
	{
		if (netPay > 200)
		{
			bonus = 25;
		}
		
		return bonus;
	}
	
	public double getWageAfterBonus(double netPay, double bonus)
	{
		netAfterBonus = netPay + bonus;
		
		return netAfterBonus;
	}
	
	//toString
	public String toString()
	{
		String str;
		
		str = super.toString();
		str += "Stay Rooms Cleaned: " + stayRoom + "\n";
		str += "Departure Rooms Cleaned: " + depRoom + "\n";
		str += "Rooms Cleaned: " + roomsCleaned + "\n";
		str += "Stay Room Rate/Dep Room Rate: �" + stayRate + "/�" + depRate + "\n";
		str += "Wage Paid:   �" + Math.round(wage*100.0)/100.0 + "\n";
		str += "PAYE (12%):  �" + Math.round(paye*100.0)/100.0 + "\n";
		str += "PRSI (8%):   �" + Math.round(prsi*100.0)/100.0 + "\n";
		str += "Tax Total:   �" + Math.round(tax*100.0)/100.0 + "\n";
		str += "Net Pay:     �" + Math.round(netPay*100.0)/100.0 + "\n";
		str += "Bonus if any: �" + Math.round(bonus*100.0)/100.0 + "\n";
		str += "Net Pay (After bonus): �" + Math.round(netAfterBonus*100.0)/100.0 + "\n";
		
		return str;
	}
	
	

}
