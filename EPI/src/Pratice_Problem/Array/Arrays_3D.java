package Pratice_Problem.Array;

import java.util.Scanner;

public class Arrays_3D {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[][][] z=new int[3][3][3];
//        for(int i=0;i<=z.length-1;i++)
//        {
//            for(int j=0;j<=z[i].length-1;j++){
//                for(int k=0;k<=z[i][j].length-1;k++){
//                    z[i][j][k]=sc.nextInt();
//                }
//            }
//        }
//
//        for(int i=0;i<=z.length-1;i++){
//            for(int j=0;j<=z[i].length-1;j++){
//                for(int k=0;k<=z[i][j].length-1;k++){
//                    System.out.print(z[i][j][k]+" ");
//                }
//                System.out.println();
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] y= new int[4][][];
        y[0]=new int[2][];
        y[1]=new int[1][4];
        y[2]=new int[2][];
        y[3]=new int[3][];
        y[0][0]=new int[2];
        y[0][1]=new int[3];
        y[2][0]=new int[2];
        y[2][1]=new int[1];
        y[3][0]=new int[1];
        y[3][1]=new int[2];
        y[3][2]=new int[3];
        for(int i=0;i<=y.length-1;i++){
            for(int j=0;j<=y[i].length-1;j++){
                for(int k=0;k<=y[i][j].length-1;k++){
                    y[i][j][k]=sc.nextInt();
                }
            }
        }
        for(int i=0;i<=y.length-1;i++){
            for(int j=0;j<=y[i].length-1;j++){
                for(int k=0;k<=y[i][j].length-1;k++){
                    System.out.print(y[i][j][k]+" ");
                }
                System.out.println();
            }
        }
    }
}

//output 0
//1
//2
//3
//0 1
//1 1
//0 1 2
//0 0
//0 1 2
//0 1
//output
//0 1
//2 3 0
//1 1 1 0
//1 2
//0
//0
//0 1
//2 0 1
