/*Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.
Some hints:

Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/



public class Solution 
{
    public boolean isPalindrome(int x) 
    {
        if(x < 0)
        {
            return false;
        }
        if(x<=9)
        {
            return true;
        }
        
        int left = 1000000000;
        int right =10;
        while(true)
        {
            if(x/left == 0)
            {
                left /= 10;
                continue;
            }
            
            if((x/left)%10 != (x%right)/(right/10))
            {
                return false;
            }
            left /= 10;
            right *= 10;
            if(left<right)
            {
                break;
            }
            
            
        }
        return true;
    }
}
