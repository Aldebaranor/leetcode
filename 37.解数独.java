/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {

    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private List<int[]> spaces = new ArrayList<int[]>();
    private static boolean tag=false;

    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int digit = board[i][j]-'0'-1;
                    row[i][digit]=col[j][digit]=block[i/3][j/3][digit]=true;
                }else {
                    spaces.add(new int[]{i,j});
                }
            }
        }
        dfs(board,0); 
    }

    public void dfs(char[][] board,int pos) {
        if(pos==spaces.size()){
            tag=true;
            return;
        }
        int[] space=spaces.get(pos);
        for(int num=0;num<9&&!tag;num++){
            if(!row[space[0]][num]&&!col[space[1]][num]&&!block[space[0]/3][space[1]/3][num]){
                row[space[0]][num]=col[space[1]][num]=block[space[0]/3][space[1]/3][num]=true;
                board[space[0]][space[1]]=(char)(num+'0'+1);
                dfs(board,pos+1);
                row[space[0]][num]=col[space[1]][num]=block[space[0]/3][space[1]/3][num]=false;
            }
        }
    }
}
// @lc code=end

