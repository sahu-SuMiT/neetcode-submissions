class Solution {
    static char[][]sudokuBoard;
    boolean rowCheck(int i,int j,char currChar){
        for(int c=0;c<9;c++){
            if(j!=c && sudokuBoard[i][c]==currChar)return false;
        }
        return true;
    }   
    boolean colCheck(int i,int j,char currChar){
        for(int r=0;r<9;r++){
            if(i!=r && sudokuBoard[r][j]==currChar)return false;
        }
        return true;
    }
    boolean cellCheck(int i,int j,char currChar){
        for(int r=(i/3)*3;r<(i/3)*3+3;r++){
            for(int c=(j/3)*3;c<(j/3)*3+3;c++){
                if(sudokuBoard[r][c]==sudokuBoard[i][j]&&(i!=r||j!=c))return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        sudokuBoard=board;
        int n=board.length;
        int m=board.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]!='.'){
                    if(!rowCheck(i,j,board[i][j]) ||!colCheck(i,j,board[i][j])||!cellCheck(i,j,board[i][j]))return false;
                }
                
            }
        }
        return true;
    }
}
