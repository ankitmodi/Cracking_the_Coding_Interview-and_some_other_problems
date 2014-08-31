/*Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.*/


public class Solution 
{
    
    
    
    public static String intToRoman(int num) 
    {
        String res ="";
        while(num > 0)
        {
            int quo = 0;
            if(num /1000 >0)
            {
                quo = num/1000;
                for(int i=1;i<=quo;i++)
                {
                    res += "M";
                }
                num = num%1000;
            }
            else if(num /900 >0)
            {
                quo = num/900;
                for(int i=1;i<=quo;i++)
                {
                    res += "CM";
                }
                num = num%900;
            }
            else if(num /500 >0)
            {
                quo = num/500;
                for(int i=1;i<=quo;i++)
                {
                    res += "D";
                }
                num = num%500;
            }
            else if(num /400 >0)
            {
                quo = num/400;
                for(int i=1;i<=quo;i++)
                {
                    res += "CD";
                }
                num = num%400;
            }
            else if(num /100 >0)
            {
                quo = num/100;
                for(int i=1;i<=quo;i++)
                {
                    res += "C";
                }
                num = num%100;
            }
            else if(num /90 >0)
            {
                quo = num/90;
                for(int i=1;i<=quo;i++)
                {
                    res += "XC";
                }
                num = num%90;
            }
            else if(num /50 >0)
            {
                quo = num/50;
                for(int i=1;i<=quo;i++)
                {
                    res += "L";
                }
                num = num%50;
            }
            else if(num /40 >0)
            {
                quo = num/40;
                for(int i=1;i<=quo;i++)
                {
                    res += "XL";
                }
                num = num%40;
            }
            else if(num /10 >0)
            {
                quo = num/10;
                for(int i=1;i<=quo;i++)
                {
                    res += "X";
                }
                num = num%10;
            }
            else if(num /9 >0)
            {
                quo = num/9;
                for(int i=1;i<=quo;i++)
                {
                    res += "IX";
                }
                num = num%9;
            }
            else if(num /5 >0)
            {
                quo = num/5;
                for(int i=1;i<=quo;i++)
                {
                    res += "V";
                }
                num = num%5;
            }
            else if(num /4 >0)
            {
                quo = num/4;
                for(int i=1;i<=quo;i++)
                {
                    res += "IV";
                }
                num = num%4;
            }
            else
            {
                quo = num/1;
                for(int i=1;i<=quo;i++)
                {
                    res += "I";
                }
                num = num%1;
            }
        }
        return res;
    }
}
