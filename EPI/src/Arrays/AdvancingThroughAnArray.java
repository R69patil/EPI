package Arrays;

import java.util.ArrayList;
import java.util.List;

public class AdvancingThroughAnArray {
    public static void main(String[] args){
       List<Integer> list = List.of(3,3,1,0,2,0,1);
       List<Integer> list1=List.of(3,2,0,0,2,0,1);
        boolean re =canReachEnd(list1);
        System.out.println(re);

    }
    public static boolean canReachEnd(List<Integer> maxAdvanceStepd){
        int furthestReachSoFar=0,lastIndex=maxAdvanceStepd.size()-1;
        for(int i=0;i<=furthestReachSoFar && furthestReachSoFar<lastIndex;i++){
            furthestReachSoFar=Math.max(furthestReachSoFar,i+maxAdvanceStepd.get(i));

        }
        return furthestReachSoFar>=lastIndex;
    }
}
