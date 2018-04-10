import java.util.Scanner;
public class Main {

    public static void main(String [] args)
    {
        Scanner read = new Scanner(System.in);
        BasicCalculator basicCalculator = new BasicCalculator();
        FieldCalculator fieldCalculator = new FieldCalculator();
        double parametr1=0, parametr2=0,result=0;
        int choice;
        System.out.println("MENU WYBORU : ");
        System.out.println("które dzialanie chcesz wykonac? ");
        System.out.println("1.Dodawanie");
        System.out.println("2.Odejmowanie");
        System.out.println("3.Mnozenie");
        System.out.println("4.Dzielenie");
        System.out.println("5.Potegowanie");
        System.out.println("6.Pierwiastkowanie");
        System.out.println("7.Pole kwadratu");
        System.out.println("8.Pole kola");
        System.out.println("9.Pole trojkata");
        System.out.println("10.Pole prostokata");
        choice = read.nextInt();
        switch(choice) {
            case 1:
                try {
                    System.out.println("Podaj pierwszy skladnik: ");
                    parametr1 = read.nextDouble();
                    System.out.println("Podaj drugi skladnik: ");
                    parametr2 = read.nextDouble();
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
                result = basicCalculator.calculateSum(parametr1, parametr2);
                System.out.println("wynik dodawania: "+ result);
                break;
            case 2:
                try {
                    System.out.println("Podaj odjemna: ");
                    parametr1 = read.nextDouble();
                    System.out.println("Podaj odjemnik: ");
                    parametr2 = read.nextDouble();
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
                result = basicCalculator.calculateDifference(parametr1, parametr2);
                System.out.println("wynik odejmowania: "+ result);
                break;
            case 3:
                try {
                    System.out.println("Podaj pierwszy czynnik: ");
                    parametr1 = read.nextDouble();
                    System.out.println("Podaj drugi czynnik: ");
                    parametr2 = read.nextDouble();
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
                result = basicCalculator.calculateMultiplication(parametr1, parametr2);
                System.out.println("wynik mnozenia: "+ result);
                break;
            case 4:
                try {
                    System.out.println("Podaj dzielna: ");
                    parametr1 = read.nextDouble();
                    System.out.println("Podaj dzielnik: ");
                    parametr2 = read.nextDouble();
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }

                result = basicCalculator.calculateDivision(parametr1, parametr2);
                System.out.println("wynik dzielenia: "+ result);
                break;
            case 5:
                try {
                    System.out.println("Podaj podstawe: ");
                    parametr1 = read.nextDouble();
                    System.out.println("Podaj wykladnik: ");
                    parametr2 = read.nextDouble();
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
                result = basicCalculator.calculatePow(parametr1, parametr2);
                System.out.println("wynik potegowania: "+ result);
                break;
            case 6:
                try {
                    System.out.println("Podaj lczbe do spierwiastkowania: ");
                    parametr1 = read.nextDouble();

                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
                result = basicCalculator.calculateSqlr(parametr1);
                System.out.println("wynik pierwiastkowania: "+ result);
                break;
            case 7:
                try {
                    System.out.println("Podaj bok kwadratu: ");
                    parametr1 = read.nextDouble();

                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
                result = fieldCalculator.calculateCircle(parametr1);
                System.out.println("pole kwadratu: "+ result);
                break;
            case 8:
                try {
                    System.out.println("Podaj promien: ");
                    parametr1 = read.nextDouble();

                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
                result = fieldCalculator.calculateCircle(parametr1);
                System.out.println("pole kola: "+ result);
                break;
            case 9:
                try {
                    System.out.println("Podaj podstawe: ");
                    parametr1 = read.nextDouble();
                    System.out.println("Podaj wysokosc: ");
                    parametr2 = read.nextDouble();
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
                result = fieldCalculator.calculateTriangle(parametr1, parametr2);
                System.out.println("pole trojkata: "+ result);
                break;
            case 10:
                try {
                    System.out.println("Podaj dlugosc pierwszego boku: ");
                    parametr1 = read.nextDouble();
                    System.out.println("Podaj dlugos drugiego boku: ");
                    parametr2 = read.nextDouble();
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
                result= fieldCalculator.calculateRectangle(parametr1, parametr2);
                System.out.println("pole prostokata: "+ result);

                break;
            default:
                System.out.println("1-10");
        }
    }

}
