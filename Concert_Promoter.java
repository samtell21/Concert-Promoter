package concertpromoter;

/**
 * All the methods that a concert promoter could ever need;
 * Lets you sell tickets at two separate prices: one for the phone and one for the venue.
 * @author Sam Tell
 */
import javax.swing.JOptionPane;
public class Concert_Promoter
{   /**
    * Name of the band.
    */
    private String bandName 	= "Ben Aflec and the Flecktones";
    /**
    * Capacity of the venue.
    */
    private int capacity	= 1200;
    /** 
    * Tickets sold.
    */
    private int sold		= 0;
    /**
    * Tickets remaining; initial value is the capacity.
    */
    private int remaining	= capacity;
    /** 
    * Money made in ticket sales.
    */
    private double sales;
    /**
    * price of a ticket over the phone.
    */
    private double pricePhone 	= 50;
    /**
    * Price of a ticket at the venue.
    */
    private double priceVenue	= 100;
    /**
    * Price of a ticket that will be used in the sell method.
    */
    private double price;
    /**
    * Is it the day of the concert?.
    */
    private boolean dayOf       = false;


    /**
    * Constructor.
    * @param bN bandName
    * @param c capacity
    * @param pP pricePhone
    * @param pV priceVenue
    */
    public Concert_Promoter(String bN, int c, double pP, double pV)
    {
	bandName    = bN;   capacity 	= c;    remaining = capacity;
	pricePhone  = pP;   priceVenue 	= pV;
    }
    /**
    * Constructor.
    * @param bN bandName
    */
    public Concert_Promoter(String bN)
    {
	bandName    = bN;
    }
    /**
    * Constructor.
    * @param bN bandName
    * @param c capacity
    */
    public Concert_Promoter(String bN, int c)
    {
	bandName    = bN;   capacity 	= c;	remaining = capacity;
    }
    /**
    * Constructor.
    * @param pP pricePhone
    * @param pV priceVenue
    */
    public Concert_Promoter(double pP, double pV)
    {
        pricePhone  = pP;   priceVenue 	= pV;
    }

    /**
    * Sells tickets until there are none remaining at the appropriate price;
    * Adds money made to sales;
    * Increments sold and decrements remaining.
    * @param n Number of tickets that one is attempting to sell.
    * @return The number of tickets that were successfully sold.
    */
    public int sell(int n)
    {	
        if(dayOf == false)
            price = pricePhone;
	else
            price = priceVenue;
	int s = 0;
	for(int q = n; q>0 && remaining != 0; q--)
	{   
            sold++;
            remaining--;
            sales += price;
            s++;
	}
        return s;
    }

    /**
    * Switches dayOf from true to false or from false to true.
    */
    public void switchPrice()
    {	
        if(dayOf == false)
            dayOf = true;
	else
            dayOf = false;
    }

    /**
    * Method to access private variable sold.
    * @return sold
    */
    public int sold()
    {	return sold;			}
    /**
    * Method to access private variable remaining.
    * @return remaining
    */
    public int remaining()
    {	return remaining;		}
    /** 
    * Method to access private variable sales
    * @return sales
    */
    public double sales()
    {	return sales;			}
    /**
    * Method to access bandName
    * @return bandName
    */
    public String bandName()
    {	return bandName;		}
    /**
    * Method to access capacity
    * @return capacity
    */
    public int capacity()
    {	return capacity;		}
    /**
    * Method to access pricePhone
    * @return pricePhone
    */
    public double pricePhone()
    {	return pricePhone;		}
    /**
    * Method to access priceVenue
    * @return priceVenue
    */
    public double priceVenue()
    {	return priceVenue;		}

    /**
    * Gets dayOf from user; Gets number of tickets to be sold from user; Attempts to sell tickets at appropriate price;
    * Outputs successfully sold, total sold, remaining, and total sales in message box.
    */
    public void run()
    {	int cont = JOptionPane.YES_OPTION;
	while(cont == JOptionPane.YES_OPTION)
        {   
            if(dayOf == false)
            {	
                int d = JOptionPane.showConfirmDialog(null, "Is it the day of the concert?", null, JOptionPane.YES_NO_OPTION);
		if(d == JOptionPane.YES_OPTION)
		{   
                    switchPrice();
                    dayOf = true;	
                }
            }
            String ts = JOptionPane.showInputDialog("How many tickets ar being sold? (integer)");
		int t = Integer.parseInt(ts);
            int s = sell(t);
            cont = JOptionPane.showConfirmDialog(null,"Ticket sold: "+s+"\nTotal Sold: "+sold()
                                                +"\nRemaining: "+remaining()+"\nSales: "+formatMoney(sales())
                                                +"\n\nAgain?",null,JOptionPane.YES_NO_OPTION);
	}
    }

    /**
    * Formats money to begin with a dollar sign, group the whole digits into threes separated by commas, and with only two decimal places.
    * @param n Amount in dollars.
    * @return String of properly formated money.
    */
    public static String formatMoney(double n)
    {	
        String s = String.format("$%,.2f",n);
	return s;
    }
    
    /**
     * A message box which displays band name, capacity, phone price, and venue price.
     */
    public void header()
    {
        JOptionPane.showMessageDialog(null, "Band Name: " + this.bandName() + "\nVenue Capacity: " + this.capacity() 
					+ "\nPrice of ticket\n\t\tOver the Phone: " + formatMoney(this.pricePhone()) 
					+ "\n\t\tAt the Venue: " + formatMoney(this.priceVenue()));
    }
}