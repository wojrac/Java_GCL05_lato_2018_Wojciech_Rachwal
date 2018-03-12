



/**
 * Created by wrachwal on 2018-03-06.
 */
public class ExtendedTetrahedronCalculator  extends TetrahedronCalculator implements ExtendedCalculator {
    TetrahedronCalculator areavolume = new TetrahedronCalculator();
    public void calculateArea()throws Exception
    {
        System.out.println("Pole czworoscianu: "+ 4*areavolume.calculateBaseArea());
    }
    public void calculateVolume()throws Exception
    {
        System.out.println("Objetosc czworoscianu: " + (bok*1.41)/12);
    }

}
