package Primitive_type;

public class computexpowy {
    public static void main(String[] args){
        double xnum=2;
        int ynum=3;
        double res=power(xnum,ynum);
        System.out.println(res);
    }
    public static double power(double x,int y){
        double result=1.0;
        long power =y;
        if(y<0){
            power=-power;
            x=1.0/x;
        }
        while(power != 0){
            if((power&1)!=0){
                result*=x;
            }
            x*=x;
            power>>>=1;
        }
        return result;
    }
}
