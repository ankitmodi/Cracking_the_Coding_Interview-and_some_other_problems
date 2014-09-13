/*Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

*/


public class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        
         if (board==null|| board.length!=9 || board[0].length!=9)
         {
             return false;
         }
        boolean res = true;
        
        for(int i =0; i<9; i++)
        {
            if(!checkRow(board, i))
            {
                res = false;
                break;
            }
            if(!checkCol(board, i))
            {
                res = false;
                break;
            }
            if(!checkBox(board, 3*(i/3), 3*(i%3)))
            {
                res = false;
                break;
            }
        }
        
        return res;
    }
    
    
    public boolean checkBox(char[][] board, int row, int col)
    {
        boolean res = true;
        
        boolean[] check = new boolean[9];
        Arrays.fill(check, false);
        for(int i=row; i<row+3; i++)
        {
            for(int j=col; j<col+3; j++)
            {
                if(board[i][j] == '.')
                {
                    continue;
                }
                int val = board[i][j]-'0';
                if(!check[val-1])
                {
                    check[val-1] = true;
                }
                else
                {
                    res = false;
                    break;
                }
                
            }
            if(!res)
                {
                    break;
                }
            
        }
        return res;
    }
    
    public boolean checkRow(char[][] board, int row)
    {
        boolean res = true;
        
        int col = board[0].length;
        boolean[] check = new boolean[9];
        Arrays.fill(check, false);
        for(int i=0; i<col; i++)
        {
            if(board[row][i] == '.')
            {
                continue;
            }
            int val = board[row][i]-'0';
            if(!check[val-1])
            {
                check[val-1] = true;
            }
            else
            {
                res = false;
                break;
            }
        }
        return res;
    }
    
    
    public boolean checkCol(char[][] board, int col)
    {
        boolean res = true;
        
        int row = board.length;
        boolean[] check = new boolean[9];
        Arrays.fill(check, false);
        for(int i=0; i<row; i++)
        {
            if(board[i][col] == '.')
            {
                continue;
            }
            int val = board[i][col]-'0';
            
            if(!check[val-1])
            {
                check[val-1] = true;
            }
            else
            {
                res = false;
                break;
            }
        }
        return res;
    }
    
    
    
}
