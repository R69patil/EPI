package Recursion.Backtracking;

public class countPath {
    public static void main(String[] args){
       System.out.print(countPath(3,3));

    }
    public static int countPath(int r, int c){
        if(r==1 || c==1) return 1;
        int left=countPath(r-1,c);
        int right=countPath(r,c-1);
        return left+right;

    }
}
