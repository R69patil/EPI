package Primitive_type;

public class ComputexmulywithoutArithmeticaloper {

    public static int multiply(int x,int y){
        int result=0;
        while(y>0){
            if((y&1)==1){
                result=add(result,x);
            }
            x<<=1;
            y>>=1;
        }
        return result;
    }
    public static int add(int a,int b){
        while(b!=0){
            int carry = a&b;
            a=a^b;//In this we add the number without carry at least one of the bits is not set
            b=carry<<1;//carry is shifted by one so that adding it to a gives the required sum
        }
        return a;
    }

    public static void main(String[] args) {
        int x=15;
        int y=3;
        System.out.println("muliplication of"+x+"and"+y+"="+multiply(x,y));
    }
}
/*Example: Adding 5 and 3

Let's add 5 (Binary: 0101) and 3 (Binary: 0011) using this method.

a = 5 (Binary: 0101)
b = 3 (Binary: 0011)

Step 1: Calculate Sum Without Carry using XOR

sum = a ^ b
    = 0101 ^ 0011
            = 0110  (Binary for 6)

Step 2: Calculate Carry using AND and Shift

carry = (a & b) << 1
        = (0101 & 0011) << 1
        = 0001 << 1
        = 0010  (Binary for 2)

Step 3: Repeat Until No Carry

Now, add sum and carry.


Iteration 2:

a = 0110 (6)
b = 0010 (2)

sum = a ^ b
    = 0110 ^ 0010
            = 0100  (Binary for 4)

carry = (a & b) << 1
        = (0110 & 0010) << 1
        = 0010 << 1
        = 0100  (Binary for 4)

Iteration 3:

a = 0100 (4)
b = 0100 (4)

sum = a ^ b
    = 0100 ^ 0100
            = 0000  (No sum, just carry)

carry = (a & b) << 1
        = (0100 & 0100) << 1
        = 0100 << 1
        = 1000  (Binary for 8)

Iteration 4:

a = 0000 (0)
b = 1000 (8)

sum = a ^ b
    = 0000 ^ 1000
            = 1000  (Binary for 8)

carry = (a & b) << 1
        = (0000 & 1000) << 1
        = 0000 << 1
        = 0000  (No more carry)

Step 4: Stop when Carry is Zero

Carry is now 0, so we stop.


Final Result:

a = 1000 (8)*/