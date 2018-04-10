import java.lang.IllegalArgumentException;
public class FieldCalculator {

    public double  calculateSquare(double side) throws IllegalArgumentException
    {
        if(side <=0)
        {
            throw new IllegalArgumentException("Bok musi byc wiekszy od zera!!");
        }
        return side*side;
    }
    public double calculateCircle(double radius) throws IllegalArgumentException
    {
        if(radius <=0)
        {
            throw new IllegalArgumentException("Promien musi byc wiekszy od zera!!");
        }
        return 3.14 * radius*radius;
    }
    public double calculateTriangle(double base, double height) throws IllegalArgumentException
    {
        if(base <=0)
        {
            throw new IllegalArgumentException("podstawa trojkata musi byc wieksza od 0!!");
        }
        if(height<= 0)
        {
            throw new IllegalArgumentException("wysokosc trojkata musi byc wieksza od 0!!");
        }
        return 0.5*base*height;
    }
    public double calculateRectangle(double side1,double side2) throws IllegalArgumentException
    {
        if(side1 <=0 || side2<=0)
        {
            throw new IllegalArgumentException("Bok musi byc wiekszy od zera!!");
        }
        return side1*side2;
    }

}
