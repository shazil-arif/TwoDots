/** 
*  @file TestPointT.java
*  @author Shazil Arif
*  @brief TestPointT is used to test the routines in PointT.java
*  @date April 6th 2020
*/
import org.junit.*;
import static org.junit.Assert.*;
public class TestPointT{
    private int row;
    private int col;
    private PointT p;

    @Before
    public void setUp(){
        //set up state variables
        row = 10;
        col = 20;
        p = new PointT(row,col);
    }
    @After
    public void tearDown(){
        //reset state variables
        row = 0;
        col = 0;
        p = null;
    }

    @Test
    public void testRow(){
        //test getter method for the row
        assertEquals(p.row(),row);
    }

    @Test
    public void testCol(){
        //test getter method for the column
        assertEquals(p.col(),col);
    }
}
