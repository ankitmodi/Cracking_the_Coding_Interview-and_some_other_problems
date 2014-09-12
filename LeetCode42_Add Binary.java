/* Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100". */


public class Solution 
{
    public String addBinary(String a, String b) 
    {
        int lena = a.length(), lenb = b.length();
        if(lena>lenb)
        {
            for(int i=0; i< lena-lenb; i++)
            {
                b = "0" + b;
            }
        }
        else
        {
            for(int i=0; i< lenb-lena; i++)
            {
                a = "0" + a;
            }
        }
        
        String res = "";
        boolean carry = false;
        
        int len = a.length();
        for(int i=len-1; i>=0; i--)
        {
            if(!carry)
            {
                if(a.charAt(i)=='0' && b.charAt(i)=='0')
                {
                    res = "0" + res;
                }
                else if(a.charAt(i)=='1' && b.charAt(i)=='1')
                {
                    res = "0" + res;
                    carry = true;
                }
                else
                {
                    res = "1" + res;
                }
            }
            else
            {
                if(a.charAt(i)=='0' && b.charAt(i)=='0')
                {
                    res = "1" + res;
                    carry = false;
                }
                else if(a.charAt(i)=='1' && b.charAt(i)=='1')
                {
                    res = "1" + res;
                    carry = true;
                }
                else
                {
                    res = "0" + res;
                    carry = true;
                }
            }
        }
        
        if(carry)
        {
            res = "1" + res;
        }
        
        return res;
    }
    
}
