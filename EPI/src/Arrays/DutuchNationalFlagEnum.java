package Arrays;
import java.util.*;


public class DutuchNationalFlagEnum {
    enum Color{Red,White,blue};
    public static void dutchFlagPartion(int pivotIndex ,List<Color> A) {
        Color pivot=A.get(pivotIndex);
        int smaller=0,equal=0,larger=A.size()-1;
        while(equal<=larger){
            if(A.get(equal).ordinal()<pivot.ordinal()){
                Collections.swap(A,smaller,equal);
                smaller++;
                equal++;
            }
            else if(A.get(equal)==pivot){
                equal++;
            }
            else{
                Collections.swap(A,equal,larger);
                larger--;
            }

        }
    }
    public static void main(String[] args){
        List<Color> list = new ArrayList<>();
        list.add(Color.Red);
        list.add(Color.White);
        list.add(Color.blue);
        list.add(Color.White);
        list.add(Color.Red);
        list.add(Color.blue);
        int pivotIndex=1;;
        dutchFlagPartion(pivotIndex,list);
        System.out.println(list);

    }

}
