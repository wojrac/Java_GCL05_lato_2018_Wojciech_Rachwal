/**
 * Created by wrachwal on 2018-03-06.
 */


import java.lang.Exception;
public class Main {
    public static void main(String[] args) {


        ConeCalculator stozek = new ConeCalculator();
        TetrahedronCalculator czworoscian = new TetrahedronCalculator();
        System.out.println("Pole podstawy stozka " + stozek.calculateBaseArea());
        System.out.println("Obwod podstawwy stozka " + stozek.calculateBasePerimeter());
        System.out.println("Pole podstawy czworoscianu " + czworoscian.calculateBaseArea());
        System.out.println("Obwod podstawy czworoscian u" + czworoscian.calculateBasePerimeter());
        ExtendedCalculator zmienna = new ExtendedConeCalculator();
        ExtendedCalculator zmienna2 = new ExtendedTetrahedronCalculator();
        try {
            zmienna.calculateArea();
            zmienna.calculateVolume();
            zmienna2.calculateVolume();
            zmienna2.calculateVolume();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}