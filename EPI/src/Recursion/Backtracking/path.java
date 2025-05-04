package Recursion.Backtracking;

import java.util.ArrayList;

public class path {
    public static void main(String[] args){
       // countpathElement("",3,3);
        //System.out.print(pathRet("",3,3));
        //System.out.print(pathRetDiagonal("",3,3));
    }
    static void countpathElement(String P,int r,int c){
        if(r==1 && c==1){
            System.out.println(P);
            return;
        }
        if(r>1){
            countpathElement(P+'D',r-1,c);
        }
        if(c>1){
            countpathElement(P+'R',r,c-1);
        }
    }
    static ArrayList<String> pathRet(String P,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> list=  new ArrayList<>();
            list.add(P);
            return list;
        }
        ArrayList<String> list= new ArrayList<>();
        if(r>1){
            list.addAll(pathRet(P+'D',r-1,c));
        }
        if(c>1){
            list.addAll(pathRet(P+'R',r,c-1));
        }
        return list;

    }


}
