



import java.util.Scanner;
public class ConeCalculator implements Calculator {
    Scanner odczyt = new Scanner(System.in);
    double promien;
    public double calculateBaseArea()
    {

        System.out.println("podaj promien podstawy stozka: ");
        promien = odczyt.nextDouble();
        return 3.14*promien*promien;

    }
    public double calculateBasePerimeter()
    {

        System.out.println("podaj promien podstawy stozka: ");
        promien = odczyt.nextDouble();
        return 2*3.14*promien;
    }
}