package Primitive_type;

public class computexdivy {
    public static void main(String[] args){
        long num1=12;
        long num2=6;
        long res=divide(num1,num2);
        System.out.println(res);
    }
    public static long divide(long x,long y){
        long result=0;
        int power=32;
        long ypower= y<<power;
        while(x>=y){
            while(ypower>x){
                ypower>>=1;
                --power;
            }
            result+=1L<<power;
            x-=ypower;
        }
        return result;
    }
}
