package concertpromoter;

/**
 *
 * @author Sam Tell
 */
public class MyConcert 
{
    /**
    * An epic concert.
    * @param args unused
    */
    public static void main(String[] args)
    {
        Concert_Promoter st = new Concert_Promoter();
        st.Concert_Promoter("Sam Tell", 10000, 200, 500);
        st.header();
        st.run();
    }  
}
