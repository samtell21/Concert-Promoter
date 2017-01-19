package concertpromoter;
/**
 *
 * @author Sam
 */
import javax.swing.JOptionPane;
public class Custom_Concert 
{
    /**
     * Allows one to use Concert_Promoter with a custom band name, capacity,
 phone price, and venue price.
     * @param args unused
     */
    public static void main(String[] args)
    {
        Concert_Promoter cp = new Concert_Promoter();
        String bN   = JOptionPane.showInputDialog("Band Name")  ;
        String cs   = JOptionPane.showInputDialog("Capacity")   ;   int     c    = Integer.parseInt(cs)   ;
        String pPs  = JOptionPane.showInputDialog("Phone Price");   double  pP   = Double.parseDouble(pPs);
        String pVs  = JOptionPane.showInputDialog("Venue Price");   double  pV   = Double.parseDouble(pVs);
        cp.Concert_Promoter(bN, c, pP, pV);
        cp.header();
        cp.run();
    }
    
}
