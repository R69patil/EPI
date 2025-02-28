package Primitive_type;

public class Parity {
    public static void main(String[] args){
        long b=11011;
        short c = parity( b);
        System.out.println(c);
    }
    public static short parity(long a){
        short result=0;
        while(a!=0){
            // xor checks the  bit flips the parity when a 1 is a encountered
            // If all 1s are paired the result is 0 (even)
            result^=(a&1);
            // >>== is the right shift assignment operator
            // this shifts the bits of numm to the right by one position
            // the least significant bit is dropped and the next bit is checked in the nexxt loop iteration
            a>>>=1;
        }
        return result;

    }
}
