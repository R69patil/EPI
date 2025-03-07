package Arrays;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class sampleofflinedata {

    public static void sampledata(int k,List<Integer> A){
        Random rand = new Random();
        for(int i=0;i<k;i++){
            int randIdx=i+rand.nextInt(A.size());
            Collections.swap(A,i,randIdx);
        }
    }
    public static void main(String[] args){
        List<Integer> A= Arrays.asList(3,2,4,5,6);
        int k=2;
        sampledata(k,A);
        System.out.println(A.subList(0,k));
    }
}
