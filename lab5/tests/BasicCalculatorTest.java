import org.junit.*;

import java.lang.IllegalArgumentException;

import static org.junit.Assert.*;

public class BasicCalculatorTest {
    private BasicCalculator testbasiccalculator ;
    @Before
    public void setUp () throws Exception
    {
        testbasiccalculator = new BasicCalculator();
        System.out.println("@before");
    }
    @After
    public void tearDown() throws Exception {
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
    public void calculateSumtest() {
        double result1 = testbasiccalculator.calculateSum(100,200);
        double result2 = testbasiccalculator.calculateSum(100,-200);
        double result3 = testbasiccalculator.calculateSum(100,21.4);
        assertEquals("100+200=300",300,result1,0.00);
        assertEquals("100+ -200 = -100", -100,result2,0.00);
        assertEquals("100+ 21.4 = 121.4", 121.4,result3,0.00);
    }

    @Test
    public void calculateDifferencetest() {
        double result1 = testbasiccalculator.calculateDifference(300,200);
        double result2 = testbasiccalculator.calculateDifference(21.5,32.0);
        double result3 = testbasiccalculator.calculateDifference(0,0);
        assertEquals("300-200=100",100,result1,0.00);
        assertEquals("21,5-32 = -10.5",-10.5,result2,0.00);
        assertEquals("0-0=0",0,result3,0.00);
    }

    @Test
    public void calculateMultiplicationtest() {
        double result1 = testbasiccalculator.calculateMultiplication(300,0);
        double result2 = testbasiccalculator.calculateMultiplication(21.5,1);
        double result3 = testbasiccalculator.calculateMultiplication(23,43);
        assertEquals("300*0=0",0,result1,0.00);
        assertEquals("21,5*1 = 21.5",21.5,result2,0.00);
        assertEquals("23*43=989",989,result3,0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divofZeroShouldThrowIllegalArgumentException1() {



        testbasiccalculator.calculateDivision(32, 0);

    }
    public void divofZeroShouldThrowIllegalArgumentException2() {


        testbasiccalculator.calculateDivision(22, 0);

    }
    public void divofZeroShouldThrowIllegalArgumentException3() {

        testbasiccalculator.calculateDivision(100, 0);
    }

    @Test
    public void calculateDivisiontest() {
        double result1 = testbasiccalculator.calculateDivision(300, 20);
        double result2 = testbasiccalculator.calculateDivision(21.5, 2);
        double result3 = testbasiccalculator.calculateDivision(1, 3);
        assertEquals("300/20 = 15", 15, result1, 0.00);
        assertEquals("21,5/2 = 10.75", 10.75, result2, 0.00);
        assertEquals("1/3=0,33", 0.33, result3, 0.01);
    }
    @Test
    public void calculatePowtest() {
        double result1 = testbasiccalculator.calculatePow(2,10);
        double result2 = testbasiccalculator.calculatePow(3,0);
        double result3 = testbasiccalculator.calculatePow(5,2);
        assertEquals("2^10 = 1024", 1024, result1, 0.00);
        assertEquals("3^0 = 1", 1, result2, 0.00);
        assertEquals("5^2 = 25", 25, result3, 0.00);
    }
    @Test (expected = IllegalArgumentException.class)
    public void baseAndExponentZeroShouldThrowIllegalArgumentException() {

        testbasiccalculator.calculatePow(0, 0);
    }


    @Test
    public void calculateSqlrtest() {
        double result1 = testbasiccalculator.calculateSqlr(2);
        double result2 = testbasiccalculator.calculateSqlr(4);
        double result3 = testbasiccalculator.calculateSqlr(0);
        assertEquals("sqrt(2) = 1.41", 1.41, result1, 0.01);
        assertEquals("sqrt(4) = 2", 2, result2, 0.00);
        assertEquals("sqrt(0) = 0", 0, result3, 0.00);

    }
    @Test (expected = IllegalArgumentException.class)
    public void variablesWithMinusShouldThrowIllegalArgumentException1() {

        testbasiccalculator.calculateSqlr(-1);

    }
    @Test (expected = IllegalArgumentException.class)
    public void variablesWithMinusShouldThrowIllegalArgumentException2() {


        testbasiccalculator.calculateSqlr(-3);
    }
    @Test (expected = IllegalArgumentException.class)
    public void variablesWithMinusShouldThrowIllegalArgumentException3() {


        testbasiccalculator.calculateSqlr(-2);

    }
}