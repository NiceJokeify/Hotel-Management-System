package hotelMain;

import java.util.Scanner;

public class RestaurantStaff extends Staff implements Tax
{
	//data variables
	final double PAYE_RATE = .12;
	final double PRSI_RATE = .08;
	int hours;
	int rate;
	double bonus;
	double wage;
	double netAfterBonus;
	double paye;
	double prsi;
	double tax;
	double netPay;
	String typeOfStaff;
	
	Scanner console = new Scanner (System.in);
	
	// constructor
	RestaurantStaff()
	{
		super();
		typeOfStaff =  getTypeOfStaff();
		hours = getHours();
		wage = getWage(hours, rate);
		paye = getPAYE(wage, PAYE_RATE);
		prsi = getPrsi(wage, PRSI_RATE);
		tax = getTax(paye, prsi);
		netPay = getNetPay(wage, tax);
		bonus = getBonus(netPay);
		netAfterBonus = getWageAfterBonus(netPay, bonus);
	}
	
	//methods
	public int getHours()
	{
		System.out.print("Hours Worked: ");
		hours = console.nextInt();
		
		return hours;	
	}
	
	public String getTypeOfStaff()
	{
		char choice;
		
		System.out.print("Type of Staff: Manager[M] / Staff[S]: ");
		choice = console.next().charAt(0);
		
		switch(choice)
		{	
			case 'M':
			case 'm':
				typeOfStaff = "Management Staff";
				rate = 13;
				break;
			case 'S':
			case 's':
				typeOfStaff = "Waiting Staff";
				rate = 9;
				break;
		}
		
		return typeOfStaff;	
	}

	public double getWage(int hours, int rate)
	{
		wage = hours * rate;
		
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
		if (netPay > 275)
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
		str += "Type Of Staff: " + typeOfStaff + "\n";
		str += "Hours Worked: " + hours + "\n";
		str += "Rate of Pay: €" + rate + "\n";
		str += "Wage Paid:   €" + wage + "\n";
		str += "PAYE (12%):  €" + paye + "\n";
		str += "PRSI (8%):   €" + prsi + "\n";
		str += "Tax Total:   €" + tax + "\n";
		str += "Net Pay:     €" + netPay + "\n";
		str += "Bonus if any: €" + bonus + "\n";
		str += "Net Pay (After bonus): €" + netAfterBonus + "\n";
		
		return str;
	}
}
