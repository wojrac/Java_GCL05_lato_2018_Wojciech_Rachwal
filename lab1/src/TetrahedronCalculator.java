 /**
 * Created by wrachwal on 2018-03-06.
 */
import com.example.calculator.basic.Calculator;

import java.util.Scanner;
public class TetrahedronCalculator implements Calculator {
    Scanner odczyt = new Scanner(System.in);
    double bok;
    public double calculateBaseArea()
    {
        System.out.println("podaj dlugosc boku podstawy czworoscianu: ");
        bok = odczyt.nextDouble();
        return (bok*bok*1.73)/4;
    }
    public double calculateBasePerimeter()
    {
        System.out.println("podaj dlugosc boku podstawy czworoscianu: ");
        bok = odczyt.nextDouble();
        return bok*3;
    }
}
