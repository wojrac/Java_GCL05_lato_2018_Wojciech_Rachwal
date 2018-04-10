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
public class FieldCalculatorTestParametrized {

    private FieldCalculator testfieldcalculator ;
    private double r;

    public FieldCalculatorTestParametrized(double rInConstructor )
    {
        this.r = rInConstructor;

    }
    @Before
    public void setUp() throws Exception {
        testfieldcalculator = new FieldCalculator();
    }
    @Parameterized.Parameters
    public static Collection radius()
    {
        return Arrays.asList(new Object[][] {
                { 0},{-3},{-4}


        });
    }
    @Test(expected = IllegalArgumentException.class)
    public void calculateCircletestparametrized() {
        testfieldcalculator.calculateCircle(r);

    }
}