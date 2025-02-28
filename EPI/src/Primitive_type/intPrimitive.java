package Primitive_type;

public class intPrimitive {
    public static void main(String[] args){
        int a=7;
        int sr=parity(a);
        System.out.println("parity of "+a+"is:"+(sr==0?"Even":"Odd"));

    }
    public static int parity(int a){
        int result=0;
        while(a!=0){
            result^=(a&1);
            a>>=1;
        }
        return result;
    }
}
