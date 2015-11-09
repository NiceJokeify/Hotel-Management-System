package hotelMain;

public interface Tax 
{
	public double getPAYE(double wage, double PAYE_RATE);
	
	public double getPrsi(double wage, double PRSI_RATE);
}
