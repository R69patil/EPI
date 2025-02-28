package Primitive_type;

public class ReverseBit {
    public static long reversebits(long num){
        long res=0;
        for(int i=0;i<64;i++){
            res <<= 1;
            res |= (num & 1);
            num >>= 1;

        }
        return res;

    }
    public static void main(String[] args) {
        long num=5;
        long reverse=reversebits(num);
        System.out.println(Long.toUnsignedString(reverse));
    }
}
