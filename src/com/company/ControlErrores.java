package com.company;

import java.util.Scanner;

public class ControlErrores {

    public static double controlInputDouble(){
        Scanner sc = new Scanner(System.in);
        boolean valorCorrecte;
        double x = 0;
        do {
            if (!sc.hasNextDouble()) {
                sc.nextLine();
                valorCorrecte = false;
                System.out.println("No me seas mal usuario!");
            } else {
                x = sc.nextDouble();
                valorCorrecte = true;
            }
        } while (!valorCorrecte);
        return x;
    }
    public static int controlInputInt(){
        Scanner sc = new Scanner(System.in);
        boolean valorCorrecte;
        int x = 0;
        do {
            if (!sc.hasNextInt()) {
                sc.nextLine();
                valorCorrecte = false;
                System.out.println("No,Niet,Nicht,Not,Non");
            } else {
                x = sc.nextInt();
                valorCorrecte = true;
            }
        } while (!valorCorrecte);
        return x;
    }
}
