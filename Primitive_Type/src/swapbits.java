public class swapbits {


    public static int swap(int num, int i, int j){
        if(((num>>i) &  1)!=((num>> j) &1)){
            int mask=(1 <<i)|(1<<j);
            num ^=mask;
        }
        return num;
    }
    public static void main(String[] args){
        int num=25;
        int i=0;
        int j=2;
        int result=swap(num,i,j);
        System.out.println(result);
    }

}
