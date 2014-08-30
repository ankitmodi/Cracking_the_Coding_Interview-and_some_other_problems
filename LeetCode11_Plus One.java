/*Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.*/

public class Solution 
{
    public int[] plusOne(int[] digits) 
    {
        if(digits[digits.length - 1] != 9)
        {
            digits[digits.length - 1] += 1;
            return digits;
        }
        
        else
        {
            if(areAllDigits9(digits))
            {
                int[] B = new int[digits.length + 1];
                B[0] = 1;
                for(int i =1; i< B.length; i++)
                {
                    B[i] = 0;
                }
                return B;
            }
            
            else
            {
                digits[digits.length - 1]++;
                for(int i = digits.length-1; i>=1; i--)
                {
                    if(digits[i] ==10)
                    {
                        digits[i] = 0;
                        digits[i-1] ++ ;
                    }
                }
                return digits;
            }
        }
        
    
        
    }
    
    public static boolean areAllDigits9(int[] A)
    {
        boolean res = true;
        for(int i: A)
        {
            if(i !=9)
            {
                res = false;
            }
        }
        return res;
    }
    
   
}
