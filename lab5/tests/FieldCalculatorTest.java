
import org.junit.*;


import static org.junit.Assert.*;

public class FieldCalculatorTest {
    private FieldCalculator testfieldcalculator ;
    @Before
    public void setUp()throws Exception
    {
        testfieldcalculator = new FieldCalculator();
        System.out.println("@before");
    }
    @After
    public void tearDown()throws Exception {
        System.out.println("@after");
    }
    @BeforeClass
    public static void setupClass()
    {
        System.out.println("@BeforeClass");
    }
    @AfterClass
    public static void teardownClass()
    {
        System.out.println("@AfterClass");
    }

    @Test
    public void calculateSquaretest() {
        double result1 = testfieldcalculator.calculateSquare(10);
        double result2 = testfieldcalculator.calculateSquare(20);
        double result3 = testfieldcalculator.calculateSquare(0.23);
        assertEquals("Field of a square with side = 10 is 100", 100, result1, 0.00);
        assertEquals("Field of a square with side = 20 is 400", 400, result2, 0.00);
        assertEquals("Field of a square with side = 0,23 is 0,0529", 0.0529, result3, 0.00);
    }


    @Test
    public void calculateCircletest() {
        double result1 = testfieldcalculator.calculateCircle(10);
        double result2 = testfieldcalculator.calculateCircle(20);
        double result3 = testfieldcalculator.calculateCircle(0.5);
        assertEquals("Field of a cicle with radius = 10 is 314", 314, result1, 0.00);
        assertEquals("Field of a circle with radius = 20 is 1256", 1256, result2, 0.00);
        assertEquals("Field of a circle with radius =  is 0,785", 0.785, result3, 0.00);
    }

    @Test
    public void calculateTriangletest() {
        double result1 = testfieldcalculator.calculateTriangle(10,5);
        double result2 = testfieldcalculator.calculateTriangle(2,3);
        double result3 = testfieldcalculator.calculateTriangle(3,4);
        assertEquals("Field of a triangle with base = 10 and height=5  is 25", 25, result1, 0.00);
        assertEquals("Field of a triangle with base = 2 and height = 3 is 3", 3, result2, 0.00);
        assertEquals("Field of a triangle with base = 3 and height=4 is 6", 6, result3, 0.00);
    }

    @Test
    public void calculateRectangletest() {
        double result1 = testfieldcalculator.calculateRectangle(10,33342);
        double result2 = testfieldcalculator.calculateRectangle(20,234);
        double result3 = testfieldcalculator.calculateRectangle(0.23,2);
        assertEquals("Field of a rectangle with side1 = 10 and side2 = 33342 is 333420", 333420, result1, 0.00);
        assertEquals("Field of a rectangle with side1 = 20  and side2 = 234 is 4680", 4680, result2, 0.00);
        assertEquals("Field of a rectangle with side1 = 0,23 and side2 = 2 is 0,46", 0.46, result3, 0.00);
    }
    @Test(expected = IllegalArgumentException.class)
    public void sideLowerOrEqualZeroShouldThrowIllegalArgumentException1()
    {
        testfieldcalculator.calculateSquare(-1);



    }
    @Test(expected = IllegalArgumentException.class)
    public void sideLowerOrEqualZeroShouldThrowIllegalArgumentException2()
    {
        testfieldcalculator.calculateSquare(0);



    }
    @Test(expected = IllegalArgumentException.class)
    public void sideLowerOrEqualZeroShouldThrowIllegalArgumentException3()
    {

        testfieldcalculator.calculateSquare(-12);


    }
    @Test(expected = IllegalArgumentException.class)
    public void baseorheighLowerOrEqualZeroShouldThrowIllegalArgumentException1()
    {
        testfieldcalculator.calculateTriangle(-1,2);

    }
    @Test(expected = IllegalArgumentException.class)
    public void baseorheighLowerOrEqualZeroShouldThrowIllegalArgumentException2()
    {

        testfieldcalculator.calculateTriangle(2,0);

    } @Test(expected = IllegalArgumentException.class)
    public void baseorheighLowerOrEqualZeroShouldThrowIllegalArgumentException3()
    {

        testfieldcalculator.calculateTriangle(3,-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void radiusLowerOrEqualZeroShouldThrowIllegalArgumentException1()
    {

        testfieldcalculator.calculateCircle(-0.22);
    }
    @Test(expected = IllegalArgumentException.class)
    public void radiusLowerOrEqualZeroShouldThrowIllegalArgumentException2()
    {

        testfieldcalculator.calculateCircle(-2);

    }
    @Test(expected = IllegalArgumentException.class)
    public void radiusLowerOrEqualZeroShouldThrowIllegalArgumentException3()
    {
        testfieldcalculator.calculateCircle(0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void side1orside2LowerOrEqualZeroShouldThrowIllegalArgumentException1()
    {

        testfieldcalculator.calculateRectangle(2,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void side1orside2LowerOrEqualZeroShouldThrowIllegalArgumentException2()
    {
        testfieldcalculator.calculateRectangle(0,0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void side1orside2LowerOrEqualZeroShouldThrowIllegalArgumentException3()
    {

        testfieldcalculator.calculateRectangle(-1,-2);

    }

}