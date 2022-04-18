package kalkulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
//import static java.lang.Math.log;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.InputMismatchException;
import java.util.Scanner;

public class Kalkulator {

    public static int action, add, o, m, div;
    public static double outcome;
    public static double[] addition = new double[add];
    public static double[] substraction = new double[o];
    public static double[] multiplication = new double[m];
    public static double[] division = new double[div];

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the calculator :)" + "\n" + "Please select an action:"
                + "\n" + "1. Addition" + "\n" + "2. Subtraction" + "\n" + "3. Multiplication"
                + "\n" + "4. Division" + "\n" + "5. History of calculations" + "\n" + "6. Exit");

        do {

            action = scan.nextInt();
            switch (action) {
                case 1:
                    outcome = 0;
                    System.out.println("How many numbers do you want to add?");
                    int add = 0;
                    do {
                        add = scan.nextInt();

                        if (add < 2) {
                            System.out.println("Invalid value. You need 2 or more numbers."
                                    + "\n" + "Please enter again how many numbers you want to add");
                        }

                    } while (add < 2);
                    double[] addition = new double[add];

                    for (int i = 0; i < add; i++) {
                        int a = i + 1;
                        System.out.println("Enter the number no " + a);
                        addition[i] = scan.nextDouble();
                        outcome = outcome + addition[i];
                    }
                    String w = Double.toString(outcome);
                    System.out.println("\n" + "Addition outcome = " + outcome + "\n");
                    Kalkulator.zapiszaddition(w, addition, add);
                    System.out.println("What do you want to do next?" + "\n" + "1. Addition" + "\n"
                            + "2. Subtraction" + "\n" + "3. Multiplication" + "\n" + "4. Division" + "\n"
                            + "5. History of calculations" + "\n" + "6. Exit");
                    break;
                case 2:
                    System.out.println("How many numbers do you want to subtract?");
                    int o;
                    do {
                        o = scan.nextInt();
                        if (o < 2) {
                            System.out.println("Invalid value. You need 2 or more numbers."
                                    + "\n" + "Please enter again how many numbers you want to add");
                        }
                    } while (o < 2);
                    double[] substraction = new double[o];

                    System.out.println("Enter the number no 1");
                    substraction[0] = scan.nextDouble();
                    System.out.println("Enter the number no 2");
                    ;
                    substraction[1] = scan.nextDouble();
                    outcome = substraction[0] - substraction[1];

                    for (int i = 2; i < o; i++) {
                        int a = i + 2;
                        System.out.println("Enter the number no " + a);
                        substraction[i] = scan.nextDouble();
                        outcome = outcome - substraction[i];
                    }
                    System.out.println("\n" + "Subtraction outcome = " + outcome + "\n");
                    w = Double.toString(outcome);
                    Kalkulator.zapiszsubstraction(w, substraction, o);
                    System.out.println("What do you want to do next?" + "\n" + "1. Addition" + "\n"
                            + "2. Subtraction" + "\n" + "3. Multiplication" + "\n" + "4. Division" + "\n"
                            + "5. History of calculations" + "\n" + "6. Exit");
                    break;
                case 3:
                    outcome = 1;
                    System.out.println("How many numbers do you want to multiply?");
                    int m;
                    do {
                        m = scan.nextInt();

                        if (m < 2) {
                            System.out.println("Invalid value. You need 2 or more numbers."
                                    + "\n" + "Please enter again how many numbers you want to add");
                        }
                    } while (m < 0);

                    double[] multiplication = new double[m];

                    for (int i = 0; i < m; i++) {
                        int a = i + 1;
                        System.out.println("Enter the number no " + a);
                        multiplication[i] = scan.nextDouble();
                        outcome = outcome * multiplication[i];
                    }
                    w = Double.toString(outcome);
                    System.out.println("\n" + "Multiplication outcome = " + outcome + "\n");
                    Kalkulator.zapiszmultiplication(w, multiplication, m);
                    System.out.println("What do you want to do next?" + "\n" + "1. Addition" + "\n"
                            + "2. Subtraction" + "\n" + "3. Multiplication" + "\n" + "4. Division" + "\n"
                            + "5. History of calculations" + "\n" + "6. Exit");
                    break;
                case 4:
                    System.out.println("How many numbers do you want to divide?");
                    int div;
                    do {
                        div = scan.nextInt();
                        if (div < 2) {
                            System.out.println("Invalid value. You need 2 or more numbers."
                                    + "\n" + "Please enter again how many numbers you want to add");
                        }
                    } while (div < 2);

                    double[] division = new double[div];

                    System.out.println("Enter the number no 1");
                    division[0] = scan.nextDouble();
                    System.out.println("Enter the number no 2");
                    do {
                        division[1] = scan.nextDouble();
                        if (division[1] == 0) {
                            System.out.println("You can't divide by 0." + "\n" + "Enter a number different from 0.");
                        }
                    } while (division[1] == 0);

                    outcome = division[0] / division[1];

                    for (int i = 2; i < div; i++) {
                        int a = i + 1;
                        System.out.println("Enter the number no " + a);
                        do {
                            division[i] = scan.nextDouble();
                            if (division[i] == 0) {
                                System.out.println("You can't divide by 0." + "\n" + "Enter a number different from 0.");
                            }
                        } while (division[i] == 0);

                        outcome = outcome / division[i];
                    }
                    w = Double.toString(outcome);
                    System.out.println("\n" + "Division outcome = " + outcome + "\n");
                    Kalkulator.zapiszdivision(w, division, div);
                    System.out.println("What do you want to do next?" + "\n" + "1. Addition" + "\n"
                            + "2. Subtraction" + "\n" + "3. Multiplication" + "\n" + "4. Division" + "\n"
                            + "5. History of calculations" + "\n" + "6. Exit");
                    break;

                case 5:
                    File file = new File("kalkulator.txt");
                    Scanner readfile = new Scanner(file);
                    System.out.println("History of calculations:");
                    while (readfile.hasNextLine()) {
                        System.out.println(readfile.nextLine());
                    }
                    System.out.println("What do you want to do next?" + "\n" + "1. Addition" + "\n"
                            + "2. Subtraction" + "\n" + "3. Multiplication" + "\n" + "4. Division" + "\n"
                            + "5. History of calculations" + "\n" + "6. Exit");
                    break;
                case 6:
                    break;

                default:
                    System.out.println("\n" + "There is no such position." + "\n" + "Please enter a valid value:" + "\n");
            }

        } while (action != 6);

    }

    public static void zapiszaddition(String w, double[] addition, int add) throws FileNotFoundException {
        File file = new File("kalkulator.txt");

        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (file.canWrite()) {
            try {

                FileWriter fw = new FileWriter(file, true);
                Scanner readfile = new Scanner(file);

                Date nowDate = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy");
                fw.write(sdf.format(nowDate) + "  ");

                for (int i = 0; i < add; i++) {
                    if (i < add - 1) {
                        String adda = Double.toString(addition[i]);
                        fw.write(adda + " + ");
                    } else {
                        String adda = Double.toString(addition[i]);
                        fw.write(adda + " = ");
                    }
                }

                fw.write(w + "\n");
                fw.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void zapiszsubstraction(String w, double[] substraction, int o) throws FileNotFoundException {
        File file = new File("kalkulator.txt");

        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (file.canWrite()) {
            try {

                FileWriter fw = new FileWriter(file, true);
                Scanner readfile = new Scanner(file);

                Date nowDate = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy");
                fw.write(sdf.format(nowDate) + "  ");

                for (int i = 0; i < o; i++) {
                    if (i < o - 1) {
                        String ode = Double.toString(substraction[i]);
                        fw.write(ode + " - ");
                    } else {
                        String ode = Double.toString(substraction[i]);
                        fw.write(ode + " = ");
                    }
                }

                fw.write(w + "\n");
                fw.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void zapiszmultiplication(String w, double[] multiplication, int m) throws FileNotFoundException {
        File file = new File("kalkulator.txt");

        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (file.canWrite()) {
            try {

                FileWriter fw = new FileWriter(file, true);
                Scanner readfile = new Scanner(file);

                Date nowDate = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy");
                fw.write(sdf.format(nowDate) + "  ");

                for (int i = 0; i < m; i++) {
                    if (i < m - 1) {
                        String mno = Double.toString(multiplication[i]);
                        fw.write(mno + " * ");
                    } else {
                        String mno = Double.toString(multiplication[i]);
                        fw.write(mno + " = ");
                    }
                }

                fw.write(w + "\n");
                fw.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void zapiszdivision(String w, double[] division, int div) throws FileNotFoundException {
        File file = new File("kalkulator.txt");

        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (file.canWrite()) {
            try {

                FileWriter fw = new FileWriter(file, true);
                Scanner readfile = new Scanner(file);

                Date nowDate = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy");
                fw.write(sdf.format(nowDate) + "  ");

                for (int i = 0; i < div; i++) {
                    if (i < div - 1) {
                        String d = Double.toString(division[i]);
                        fw.write(d + " / ");
                    } else {
                        String d = Double.toString(division[i]);
                        fw.write(d + " = ");
                    }
                }

                fw.write(w + "\n");
                fw.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
