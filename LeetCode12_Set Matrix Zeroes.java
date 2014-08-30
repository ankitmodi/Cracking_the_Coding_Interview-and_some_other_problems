/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. */


public class Solution {
    
    public static void setZeroes(int[][] inputArr)
    {
    int row = inputArr.length;
    int col = inputArr[0].length;
    ArrayList<Integer> r = new ArrayList<Integer>();
    ArrayList<Integer> c = new ArrayList<Integer>();
    for(int i =0; i<row; i++)
    {
        for(int j =0; j<col; j++)
        {
            if(inputArr[i][j] == 0)
            {
                r.add(i);
                c.add(j);
            }
        }
    }
    int size = r.size();
    for(int i=0; i<size; i++)
    {
        int tmp_r = r.get(i);
        int tmp_c = c.get(i);
        for(int j=0; j<col; j++)
        {
            inputArr[tmp_r][j] = 0;
        }
        for(int j=0; j<row; j++)
        {
        inputArr[j][tmp_c] = 0;
        }
    }
    
    }
}
