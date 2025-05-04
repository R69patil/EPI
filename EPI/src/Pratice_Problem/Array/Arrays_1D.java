package Pratice_Problem.Array;
import java.util.*;

public class Arrays_1D {
    public static void main(String[] args){
        Scanner read= new Scanner(System.in);
        int[] a=new int[5];
        for(int i=0;i<a.length;i++){
            a[i]=read.nextInt();
        }
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
       System.out.print(Arrays.toString(whileprint(a)));
        System.out.print(Arrays.toString(doprint(a)));

    }
    public static int[] whileprint(int[] b){
        Scanner read= new Scanner(System.in);
        int i=0;
        while(i<b.length){
            b[i]=read.nextInt();
            i++;
        }
        while(i<b.length){
            System.out.print(b[i]+" ");
            i++;
        }
        return b;
    }

    public static int[] doprint(int[] c){
        Scanner read= new Scanner(System.in);
        int i=0;
        do{
            c[i]=read.nextInt();
            i++;
        }while(i<=c.length-1);
        int j=0;
        do{
            System.out.print(c[j]+" ");
            j++;
        }while(i<=c.length-1);
        return c;

    }
}
