//Given an array of integers, every element appears twice except for one. Find that single one.

public class Solution {
    public int singleNumber(int[] A) {
        
        if(A.length == 1)
        {
            return A[0];
        }
        int t= A[0] ^ A[1];
        for(int i = 2; i< A.length; i++ )
        {
            t = t^A[i];
        }
        return t;
    }
}
