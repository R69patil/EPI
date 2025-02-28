package Primitive_type;

public class ClosestintegerwithsameNumber {
    public static long Closestintwithsameweight(long n) throws IllegalAccessException {
        //loop through all bits to find first pair of consecutive bits that differ
        for(int i=0;i<63;i++){
            if(((n>>i)&1)!=((n>>i+1)&1)){
                // swap the bits using xor
                n^=(1L<<i)|(1L<<i+1);
                return n;
            }
        }
        throw new IllegalAccessException("ALL bits are 0 or1 no closesr innteger possible ");
    }
    public static void main(String[] args) throws IllegalAccessException {
        long n=6;
        long colsest=Closestintwithsameweight(n);
        System.out.println(colsest);
    }

}
