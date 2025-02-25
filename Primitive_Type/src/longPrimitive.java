public class longPrimitive {
    public static void main(String[] args) {
        int  number =8;
        System.out.println("parity:"+computeParity(number));
    }
    public static int computeParity(int num){
        num^=num>>>16;
        num^=num>>>8;
        num^=num>>>4;
        num^=num>>>2;
        num^=num>>>1;
        return num&1;

    }
}
