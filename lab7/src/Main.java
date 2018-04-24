import java.io.*;

public class Main {

    public static void main(String[] args)
    {
        String pathfile = "C:\\Users\\Wojteg\\IdeaProjects\\lab7\\src\\plik.csv";
        String pathfile2 = "C:\\Users\\Wojteg\\IdeaProjects\\lab7\\src\\plik.ser";
        File dir = new File(pathfile);
        File dir2 = new File(pathfile2);
        dir.mkdirs();
        dir2.mkdirs();
        OutputStream out=null  ;
        InputStream in = null;
        OutputStream out2=null  ;
        InputStream in2 = null;

        ExtendedSystemCache esc = new ExtendedSystemCache();
        try {
            esc.exportCSV(pathfile);
            out = new FileOutputStream("plik.csv");
            in  = new FileInputStream("plik.csv") ;
            out2 = new FileOutputStream("plik.ser");
            in2 = new FileInputStream("plik.ser") ;
           // esc.exportCSV(out);
            //esc.exportCSV(dir);
            //esc.importCSV(pathfile);
            esc.importCSV(dir);
            //esc.importCSV(in);
            esc.serialize(pathfile2);
            esc.serialize(dir2);
            esc.serialize(out2);
            esc.deserialize(pathfile2);
            esc.deserialize(dir2);
            esc.deserialize(in2);
        }catch(IOException e)
        {
            System.out.println(e);
        }
    }

}
