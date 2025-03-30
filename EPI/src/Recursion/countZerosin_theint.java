package Recursion;

public class countZerosin_theint {
    public static void main(String[] args){
        int num=307900090;
        System.out.println(count(num));
    }
    public static int count(int num){
        return helper(num,0);
    }
    public static int helper(int num,int count){
        //base case is the important
        if(num==0){
            return count;
        }
        int rem=num%10;
        if(rem==0){
            return helper(num/10,count+1);
        }
        return helper(num/10,count);
    }

}
