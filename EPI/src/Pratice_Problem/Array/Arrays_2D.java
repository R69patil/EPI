package Pratice_Problem.Array;

import java.util.Scanner;

public class Arrays_2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[3][3];
        for (int i = 0; i <= a.length-1; i++) {
            for (int j = 0; j <= a[i].length-1; j++) {
                a[i][j]=sc.nextInt();
            }
            System.out.println();
        }
        for (int i = 0; i <= a.length-1; i++) {
            for (int j = 0; j <=a[i].length-1; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
