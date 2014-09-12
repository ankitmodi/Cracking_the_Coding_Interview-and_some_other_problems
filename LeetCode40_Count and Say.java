/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. */


public class Solution 
{
    public String countAndSay(int n) 
    {
        String[] arr = new String[n];
        arr[0] = "1";
        for(int i=1; i<arr.length; i++)
        {
            arr[i] = name(arr[i-1]);
        }
        return arr[arr.length - 1];
    }
    
    public String name(String str)
    {
        String res ="";
        int i=0;
        while(i < str.length())
        {
            char tmp = str.charAt(i);
            int j = i;
            for(j=i; j<str.length(); j++)
            {
                if(tmp != str.charAt(j))
                {
                    break;
                }
            }
            int tmpval = tmp - '0';
            int times = j-i;
            if(times==0)
            {
                times++;
            }
            res += Integer.toString(times) + Integer.toString(tmpval);
            i += times ;
        }
        return res;
    }
}
