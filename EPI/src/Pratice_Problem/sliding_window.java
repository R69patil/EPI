package Pratice_Problem;

public class sliding_window{
    public static void main(String[] args){
        int[] array={2,4,6,8,1,3};
        int k=3;
        int res=method(array,k);
        System.out.print(res);
    }

    //fixed size of window problem
    public static int method(int[] array,int k){
        int maxsum=0,windowsum=0;
        for(int i=0;i<k;i++){
            windowsum+=array[i];
            maxsum=windowsum;
        }
        for(int i=k;i<array.length;i++){
            windowsum+=array[i]-array[i-k];
            maxsum=Math.max(maxsum,windowsum);
        }
        return maxsum;
    }
}
