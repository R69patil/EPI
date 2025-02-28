package Primitive_type;

public class Reversedigits {
    public static void main(String[] args){
        int x=107;
        double res =reverse(x);
        System.out.println(res);
    }
    public static long reverse(int x){
        long result=0;
        long xRemaining=Math.abs(x);
        while(xRemaining!=0){
            result=result*10+xRemaining%10;
            xRemaining=xRemaining/10;
        }
        return result;
    }
}
