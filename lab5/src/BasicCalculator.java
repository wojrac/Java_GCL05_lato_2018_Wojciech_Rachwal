import java.lang.IllegalArgumentException;
import static java.lang.Math.*;
public class BasicCalculator {

    public double calculateSum(double addend1 , double addend2) throws IllegalArgumentException
    {
        return addend1 + addend2;
    }
    public double calculateDifference(double minuend, double subtrahend) throws IllegalArgumentException
    {
        return minuend - subtrahend;
    }
    public double calculateMultiplication(double variable1 , double variable2) throws IllegalArgumentException
    {
        return variable1*variable2;
    }
    public double calculateDivision(double divident , double divisor) throws IllegalArgumentException
    {
        if(divisor == 0)
        {
            throw new IllegalArgumentException("Dzielenie przez 0!!! ");
        }

        return divident/divisor;
    }
    public double calculatePow(double base, double exponent) throws IllegalArgumentException
    {
        if(base == 0 && exponent ==0)
        {
            throw new IllegalArgumentException("symbol nieoznaczony!!");
        }
        return Math.pow(base,exponent);

    }
    public double calculateSqlr(double variable) throws IllegalArgumentException
    {
        if(variable < 0)
        {
            throw new IllegalArgumentException("nie pierwiastkuje sie liczb ujemnych!");
        }
        return sqrt(variable);
    }

}
