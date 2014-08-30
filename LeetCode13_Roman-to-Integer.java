/*Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/


public class Solution 
{
    
    
    public static int romanToInt(String s) 
    {
        int i =0;
        int res =0;
        int length = s.length();
        while(i < length)
        {
            String a = s.substring(i, i+1);
            String b ="";
            switch(a)
            {
                case "I":
                    if(i==length-1)
                    {
                        res += 1;
                        i += 1;
                        break;
                    }
                    b = s.substring(i+1, i+2);
                    if(b.equals("V"))
                    {
                        res += 4;
                        i += 2;
                    }
                    else if(b.equals("X"))
                    {
                        res += 9;
                        i += 2;
                    }
                    else
                    {
                        res += 1;
                        i += 1;
                    }
                    break;
                    
                case "V":
                    res += 5;
                    i += 1;
                    break;
                    
                case "X":
                    if(i==length-1)
                    {
                        res += 10;
                        i += 1;
                        break;
                    }
                    b = s.substring(i+1, i+2);
                    if(b.equals("L"))
                    {
                        res += 40;
                        i += 2;
                    }
                    else if(b.equals("C"))
                    {
                        res += 90;
                        i += 2;
                    }
                    else
                    {
                        res += 10;
                        i += 1;
                    }
                    break;
                    
                case "L":
                    res += 50;
                    i += 1;
                    break;
                    
                case "C":
                    if(i==length-1)
                    {
                        res += 100;
                        i += 1;
                        break;
                    }
                    b = s.substring(i+1, i+2);
                    if(b.equals("D"))
                    {
                        res += 400;
                        i += 2;
                    }
                    else if(b.equals("M"))
                    {
                        res += 900;
                        i += 2;
                    }
                    else
                    {
                        res += 100;
                        i += 1;
                    }
                    break;
                    
                case "D":
                    res += 500;
                    i += 1;
                    break;
                    
                case "M":
                    res += 1000;
                    i += 1;
                    break;
                    
                    
            }
            
        }
        return res;
    }
    
}
