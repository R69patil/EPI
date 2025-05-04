package Recursion.Backtracking;

public class Maze {
    public static void main(String[] args) {
        boolean[][] board={
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        PathRestraction("",board,0,0);
    }
    static void PathRestraction(String p,boolean[][] maze,int r,int c){
     if(r==maze.length-1 && c==maze[0].length-1){
         System.out.println(p);
         return;
     }
     if(!maze[r][c]){
         return;
     }
     if(r<maze.length-1){
        PathRestraction(p+'D',maze,r+1,c);
     }
     if(c<maze[0].length-1){
         PathRestraction(p+'R',maze,r,c+1);
     }
    }
}
