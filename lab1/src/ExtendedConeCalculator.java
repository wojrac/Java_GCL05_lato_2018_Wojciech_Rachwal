



/**
 * Created by wrachwal on 2018-03-06.
 */
public class ExtendedConeCalculator extends ConeCalculator implements ExtendedCalculator {
    ConeCalculator areavolume = new ConeCalculator();
    double tworzaca,wysokosc,wynik;
    public void calculateArea() throws Exception
    {
        System.out.println("Podaj tworzaca ");
        tworzaca = odczyt.nextDouble();
        wynik=areavolume.calculateBaseArea() +tworzaca*promien*3.14;
        System.out.println("Pole stozka: "+wynik);

    }
    public void calculateVolume() throws Exception
    {
        System.out.println("Podaj wysokosc ");
        wysokosc = odczyt.nextDouble();
        wynik=(areavolume.calculateBaseArea()*wysokosc)/3;
        System.out.println("Objetosc stozka: "+wynik);
    }
}