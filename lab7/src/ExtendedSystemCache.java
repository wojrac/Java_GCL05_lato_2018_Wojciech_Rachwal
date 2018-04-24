import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ExtendedSystemCache extends SystemCache implements Serializable{

        double[] array = {1,2,3,4,5};
        double[] array1 = {2,4};
        double [] array2 = {3,4};
        double[] array4 = {434,231};
        Parameter parameter = new Parameter(array);
        SystemCache mapwithfile = new SystemCache();
        private Scanner x;
        private final char DEFAULT_SEPARATOR = ',';


    public void exportCSV(String path) throws IOException
    {
        mapwithfile.put(array,10);
        mapwithfile.put(array1,20);
        mapwithfile.put(array2,30);
        mapwithfile.put(array4,40);
        String s;
        try{
            PrintWriter printwriter = new PrintWriter(path);

            for (HashMap.Entry<Parameter, Double> entry : mapwithfile.cache.entrySet()) {

                double[] key = entry.getKey().getValues();
                double value = entry.getValue();
                for(int i =0  ; i<key.length ; i++)
                    printwriter.print(key[i]+" ");
                printwriter.print(DEFAULT_SEPARATOR);
                printwriter.print(value);
                printwriter.println(DEFAULT_SEPARATOR);
                printwriter.flush();


            }
            printwriter.close();
        }
        catch (IOException e)
        {
            System.out.println(e +"error");
        }
    }
    public void exportCSV(File file) throws IOException
    {

        mapwithfile.put(array ,100 );
        mapwithfile.put(array1,200);
        mapwithfile.put(array2,300);
        mapwithfile.put(array4,400);
        String s ;

        try {
            PrintWriter writer = new PrintWriter(file);
            for (HashMap.Entry<Parameter, Double> entry : mapwithfile.cache.entrySet()) {
                double[] key = entry.getKey().getValues();

                double value = entry.getValue();
                for(int i = 0 ; i<key.length; i++){
                    writer.print(key[i]+" ");

                }
                writer.print(DEFAULT_SEPARATOR);
                writer.print(value);
                writer.println(DEFAULT_SEPARATOR);
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println(e +"error");
        }
    }
    void exportCSV( OutputStream stream ) throws IOException
    {
        mapwithfile.put(array,1000);
        mapwithfile.put(array1,2000);
        mapwithfile.put(array2,3000);
        mapwithfile.put(array4,4000);
        String s ;

        stream = new FileOutputStream("C:\\Users\\Wojteg\\IdeaProjects\\lab7\\src\\plik.csv");
        PrintWriter pw = new PrintWriter(stream);
        try {

            for (HashMap.Entry<Parameter, Double> entry : mapwithfile.cache.entrySet()) {
                double[] key = entry.getKey().getValues();
                double value = entry.getValue();
                for(int i =0  ; i<key.length ; i++)
                    pw.print(key[i]+" ");
                pw.print(DEFAULT_SEPARATOR);
                pw.print(value);
                pw.println(DEFAULT_SEPARATOR);
                pw.flush();

            }

            stream.close();
        }
        catch (IOException e)
        {
            System.out.println(e +"error");
        }
    }
   /* void importCSV( String path ) throws IOException
    {
            File file = new File(path);
            String[] data = {"" , "" ,"" , " ", "" , "", "","" ,""};
            String [] datakey = {"" , "" , "" , "" , ""};
            String [] datavalues  = {"" , "" , "" , "" ,""};
            double[] datavaluesdb = {0,0,0,0,0} ;
            double[] keyok = {0,0,0,0,0,0};

        try {
            x = new Scanner(file);
            x.useDelimiter("[,]");
            int i = 0 , j=0;
            while(x.hasNext())
            {

                if(i%2 == 0)
                {
                    datakey[j] = x.next();


                }
                else
                {
                    datavalues[j] = x.next();
                    datavaluesdb[j] = Double.parseDouble(datavalues[j]);
                    j++;

                }
                    i++;
            }

            for(int k = 0 ;k<i ; k++) {
                //mapwithfile.put(datakey[k], datavaluesdb[k]);
            }

            x.close();
        }catch (IOException e)
        {
            System.out.println(e);
        }
    }*/
    void importCSV( String path ) throws IOException {
        String cvsSplitBy = ",";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] splited = line.split(cvsSplitBy);
            String key = splited[0];
            String value = splited[1];
            String[] split_numbers = key.split(" ");
            double[] numbers = new double[split_numbers.length];
            for (int i = 0; i < split_numbers.length; i++) {
                //System.out.println(split_numbers[i]);
                numbers[i] = Double.parseDouble(split_numbers[i]);
                //System.out.println(numbers[i]);

            }
            //Parameter tmp = new Parameter(numbers);

            mapwithfile.put(numbers, Double.parseDouble(value));

        }
        for (HashMap.Entry<Parameter, Double> entry : mapwithfile.cache.entrySet()) {
            double[] key1 = entry.getKey().getValues();
            double value1  = entry.getValue();
            for(int i =0  ; i<key1.length ; i++)
                System.out.print(key1[i]+" ");
            System.out.println(","+value1);
        }
    }
    void importCSV( File file ) throws IOException {
        String cvsSplitBy = ",";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] splited = line.split(cvsSplitBy);
            String key = splited[0];
            String value = splited[1];
            String[] split_numbers = key.split(" ");
            double[] numbers = new double[split_numbers.length];
            for (int i = 0; i < split_numbers.length; i++) {
                //System.out.println(split_numbers[i]);
                numbers[i] = Double.parseDouble(split_numbers[i]);
                //System.out.println(numbers[i]);

            }
            //Parameter tmp = new Parameter(numbers);

            mapwithfile.put(numbers, Double.parseDouble(value));

        }
        for (HashMap.Entry<Parameter, Double> entry : mapwithfile.cache.entrySet()) {
            double[] key1 = entry.getKey().getValues();
            double value1  = entry.getValue();
            for(int i =0  ; i<key1.length ; i++)
                System.out.print(key1[i]+" ");
            System.out.println(","+value1);
        }
    }
    void importCSV( InputStream stream ) throws IOException {
        String cvsSplitBy = ",";
        stream  = new FileInputStream("C:\\Users\\Wojteg\\IdeaProjects\\lab7\\src\\plik.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] splited = line.split(cvsSplitBy);
            String key = splited[0];
            String value = splited[1];
            String[] split_numbers = key.split(" ");
            double[] numbers = new double[split_numbers.length];
            for (int i = 0; i < split_numbers.length; i++) {
                //System.out.println(split_numbers[i]);
                numbers[i] = Double.parseDouble(split_numbers[i]);
                //System.out.println(numbers[i]);

            }
            //Parameter tmp = new Parameter(numbers);

            mapwithfile.put(numbers, Double.parseDouble(value));

        }
        for (HashMap.Entry<Parameter, Double> entry : mapwithfile.cache.entrySet()) {
            double[] key1 = entry.getKey().getValues();
            double value1  = entry.getValue();
            for(int i =0  ; i<key1.length ; i++)
                System.out.print(key1[i]+" ");
            System.out.println(","+value1);
        }
    }
    public void serialize(String path) throws IOException{
        try{
            FileOutputStream stream = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(stream);
            oos.writeObject(array);
            oos.writeObject(array1);
            oos.writeObject(array2);
            oos.writeObject(array4);
            oos.writeObject(parameter);
            oos.writeObject(mapwithfile);
            oos.writeObject(x);
            oos.writeObject(DEFAULT_SEPARATOR);
            oos.close();
            stream.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public void serialize(File file) throws IOException{
        try{
            FileOutputStream stream = new FileOutputStream(file);
            ObjectOutputStream oosforfile = new ObjectOutputStream(stream);
            oosforfile.writeObject(array);
            oosforfile.writeObject(array1);
            oosforfile.writeObject(array2);
            oosforfile.writeObject(array4);
            oosforfile.writeObject(parameter);
            oosforfile.writeObject(mapwithfile);
            oosforfile.writeObject(x);
            oosforfile.writeObject(DEFAULT_SEPARATOR);
            oosforfile.close();
            stream.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public void serialize(OutputStream stream) throws IOException{
        try{
            stream = new FileOutputStream("C:\\Users\\Wojteg\\IdeaProjects\\lab7\\src\\plik.ser");
            ObjectOutputStream oosforio = new ObjectOutputStream(stream);
            oosforio.writeObject(array);
            oosforio.writeObject(array1);
            oosforio.writeObject(array2);
            oosforio.writeObject(array4);
            oosforio.writeObject(parameter);
            oosforio.writeObject(mapwithfile);
            oosforio.writeObject(x);
            oosforio.writeObject(DEFAULT_SEPARATOR);
            oosforio.close();
            stream.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void deserialize(String path) throws IOException {

        double[] array = null;
        double[] array1 = null;
        double[] array2 = null;
        double[] array4 = null;
        Parameter parameter = null;
        SystemCache mapwithfile = null;
        Scanner x = null;
        char DEFAULT_SEPARATOR = ' ';
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream oispath = new ObjectInputStream(fileInputStream);
            array = (double[]) oispath.readObject();
            array1 = (double[]) oispath.readObject();
            array2 = (double[]) oispath.readObject();
            array4 = (double[]) oispath.readObject();
            parameter = (Parameter) oispath.readObject();
            mapwithfile = (SystemCache) oispath.readObject();
            x = (Scanner) oispath.readObject();
            DEFAULT_SEPARATOR = (char) oispath.readObject();
            oispath.close();
            fileInputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
             return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
              return;
        }
    }
    public void deserialize(File file) throws IOException {

        double[] array = null;
        double[] array1 = null;
        double[] array2 = null;
        double[] array4 = null;
        Parameter parameter = null;
        SystemCache mapwithfile = null;
        Scanner x = null;
        char DEFAULT_SEPARATOR = ' ';
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream oisfile = new ObjectInputStream(fileInputStream);
            array = (double[]) oisfile.readObject();
            array1 = (double[]) oisfile.readObject();
            array2 = (double[]) oisfile.readObject();
            array4 = (double[]) oisfile.readObject();
            parameter = (Parameter) oisfile.readObject();
            mapwithfile = (SystemCache) oisfile.readObject();
            x = (Scanner) oisfile.readObject();
            DEFAULT_SEPARATOR = (char) oisfile.readObject();
            oisfile.close();
            fileInputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
    public void deserialize(InputStream stream) throws IOException {

        double[] array = null;
        double[] array1 = null;
        double[] array2 = null;
        double[] array4 = null;
        Parameter parameter = null;
        SystemCache mapwithfile = null;
        Scanner x = null;
        char DEFAULT_SEPARATOR = ' ';
        try {
            stream = new FileInputStream("C:\\Users\\Wojteg\\IdeaProjects\\lab7\\src\\plik.ser");
            ObjectInputStream oisio = new ObjectInputStream(stream);
            array = (double[]) oisio.readObject();
            array1 = (double[]) oisio.readObject();
            array2 = (double[]) oisio.readObject();
            array4 = (double[]) oisio.readObject();
            parameter = (Parameter) oisio.readObject();
            mapwithfile = (SystemCache) oisio.readObject();
            x = (Scanner) oisio.readObject();
            DEFAULT_SEPARATOR = (char) oisio.readObject();
            oisio.close();
            stream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
}
