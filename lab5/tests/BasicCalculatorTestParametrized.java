import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BasicCalculatorTestParametrized {
    private BasicCalculator testbasiccalculator ;
    private double x1,x2,expected;
    public BasicCalculatorTestParametrized(double x1InConstructor , double x2InConstructor , double expectedInConstructor)
    {
        this.x1 = x1InConstructor;
        this.x2 = x2InConstructor;
        this.expected = expectedInConstructor;
    }

    @Before
    public void setUp() throws Exception {
        testbasiccalculator = new BasicCalculator();
        System.out.println("@before");
    }
    @Parameterized.Parameters
    public static Collection numbersX1X2()
    {
        return Arrays.asList(new Object[][] {
        {2,3,5},
        {3,4,7},
        {4,-23,-19}

    });
    }

    @Test
    public void calculateSumtestparametrized() {
        double result1 = testbasiccalculator.calculateSum(x1,x2);
        assertEquals(expected,result1,0.00);
    }
}