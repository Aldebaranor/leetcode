/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        List<Cor> list = new ArrayList<>();
        boolean[][] flag = new boolean[m][n];
        char start = word.charAt(0);

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(start==board[i][j]){
                    Cor cor = new Cor();
                    cor.x=i;
                    cor.y=j;

                    list.add(cor);
                }
            }
        }

        String temp = "";
        temp+=start;
        for(int i = 0;i<list.size();i++){
            flag[list.get(i).x][list.get(i).y]=true;
            if(backtrace(board,word,flag,list.get(i),temp,1)){
                return true;
            }else {
                flag[list.get(i).x][list.get(i).y]=false;
            }
        }
        return false;
    }

    public boolean backtrace(char[][] board,String word,boolean[][] flag,Cor cor,String temp,int times){
        if(temp.equals(word)){
            return true;
        }

        //up

        if(cor.x>0 && (word.charAt(times)==board[cor.x-1][cor.y]) && !flag[cor.x-1][cor.y]){

            times++;
            cor.x--;
            temp+=board[cor.x][cor.y];
            flag[cor.x][cor.y]=true;
            if(backtrace(board,word,flag,cor,temp,times)){
                return true;
            }else {
                temp = temp.substring(0, temp.length() - 1);
                flag[cor.x][cor.y]=false;
                cor.x++;
                times--;                
            }

        }

        //down
        if(cor.x<board.length-1 && (word.charAt(times)==board[cor.x+1][cor.y])&& !flag[cor.x+1][cor.y]){

            times++;
            cor.x++;
            temp+=board[cor.x][cor.y];
            flag[cor.x][cor.y]=true;
            if(backtrace(board,word,flag,cor,temp,times)){
                return true;
            }else {
                temp = temp.substring(0, temp.length() - 1);
                flag[cor.x][cor.y]=false;
                cor.x--;
                times--;                
            }

        }
        //left
        if(cor.y>0 && (word.charAt(times)==board[cor.x][cor.y-1]) && !flag[cor.x][cor.y-1]){

            times++;
            cor.y--;
            temp+=board[cor.x][cor.y];
            flag[cor.x][cor.y]=true;
            if(backtrace(board,word,flag,cor,temp,times)){
                return true;
            }else {
                temp = temp.substring(0, temp.length() - 1);
                flag[cor.x][cor.y]=false;
                cor.y++;
                times--;                
            }

        }

        //right
        if(cor.y<board[0].length-1 && (word.charAt(times)==board[cor.x][cor.y+1]) && !flag[cor.x][cor.y+1]){

            times++;
            cor.y++;
            temp+=board[cor.x][cor.y];
            flag[cor.x][cor.y]=true;
            if(backtrace(board,word,flag,cor,temp,times)){
                return true;
            }else {
                temp = temp.substring(0, temp.length() - 1);
                flag[cor.x][cor.y]=false;
                cor.y--;
                times--;                
            }

        }

        return false;
    }

    public static class Cor{
        int x;
        int y;
    }
}
// @lc code=end

