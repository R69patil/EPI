package Recursion.Backtracking;

import java.util.ArrayList;

public class pathD {
    public static void main(String[] args) {
        System.out.print(pathRetDiagonal("",3,3));

    }
    static ArrayList<String> pathRetDiagonal(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list1=  new ArrayList<>();
            list1.add(p);
            return list1;
        }
        ArrayList<String> list1= new ArrayList<>();
        if(r>1 && c>1){
            list1.addAll(pathRetDiagonal(p+'D',r-1,c-1));
        }
        if(r>1){
            list1.addAll(pathRetDiagonal(p+'V',r-1,c));
        }
        if(c>1){
            list1.addAll(pathRetDiagonal(p+'H',r,c-1));
        }
        return list1;
    }
}
