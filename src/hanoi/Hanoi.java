/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import java.util.Scanner;

/**
 *
 * @author moizs
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    public static void print(char[][] arr1) {
        //Printing
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {

                System.out.print("|" + arr1[i][j] + "|\t");
            }
            System.out.println();

        }
    }

    public static boolean ValidMove(char arr1[][], int source, int destination) {
        char save = ' ';
        if (source == destination || source > 3 || destination > 3) {
            return false;
        }
        for (int i = arr1.length - 1; i > 0; i--) {
            if (arr1[i][source - 1] == ' ') {
                return false;
            }
            if (arr1[i][source - 1] != ' ' && arr1[i - 1][source - 1] == ' ') {
                save = arr1[i][source - 1];
                break;
            }
            if (arr1[0][source - 1] != ' ') {
                save = arr1[i][source - 1];
                break;
            }
        }
        for (int i = arr1.length - 1; i > 0; i--) {
            if (arr1[0][destination - 1] != ' ') {
                return false;
            }
            if (arr1[i][destination - 1] != ' ' && arr1[i - 1][destination - 1] == ' ') {
                if (arr1[i][destination - 1] > save) {
                    return true;
                }
            } else if (arr1[arr1.length - 1][destination - 1] == ' ') {
                return true;
            }

        }
        return false;
    }

    public static char[][] move(char[][] arr1, int source, int destination) {
        char save = ' ';
        for (int i = arr1.length - 1; i > 0; i--) {
            if (arr1[0][source - 1] != ' ') {
                save = arr1[0][source - 1];
                arr1[0][source - 1] = ' ';
                break;
            } else if (arr1[i][source - 1] != ' ' && arr1[i - 1][source - 1] == ' ') {
                save = arr1[i][source - 1];
                arr1[i][source - 1] = ' ';
                break;
            }
        }
        for (int i = arr1.length - 1; i > 0; i--) {
            if (arr1[arr1.length - 1][destination - 1] == ' ') {
                arr1[arr1.length - 1][destination - 1] = save;
                break;
            } else if (arr1[i][destination - 1] != ' ' && arr1[i - 1][destination - 1] == ' ') {
                arr1[i - 1][destination - 1] = save;
                break;
            }
        }

        return arr1;
    }

    public static boolean Win(char arr1[][]) {
        if (arr1[0][2] != ' ') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int count = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter number of Disks you want");
        int disk = input.nextInt();
        int source;
        int destination;

        char[][] arr = new char[disk][3];

        //Assign  values to Array1
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = (char) ('1' + i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][1] = ' ';
            arr[i][2] = ' ';
        }
        print(arr);

        while (Win(arr) == false) {
            System.out.print("input the source peg: ");
            source = input.nextInt();
            System.out.print("input the destination peg: ");
            destination = input.nextInt();
            if (ValidMove(arr, source, destination) == true) {;
                move(arr, source, destination);
                count++;
                print(arr);
            }
            else
                System.out.println("Invalid move");
        }
        System.out.println("You Won, Number of Moves= " + count);
    }
}
