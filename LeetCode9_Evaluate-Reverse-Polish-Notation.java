/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6 */
  
import java.util.*;
public class Solution {
    public int evalRPN(String[] tokens) 
    {
        Stack myStack = new Stack();
        
        for(String s: tokens)
        {
            if(isSymbol(s))
            {
                Integer b = (Integer) myStack.pop();
                Integer a = (Integer) myStack.pop();
                myStack.push(operate(s, a, b));
            }
            
            else
            {
                myStack.push(Integer.valueOf(s));
            }
        }
        Integer x = (Integer) myStack.pop();
        //return x.intValue();
        return x;
        
    }
    
    public Integer operate(String s, Integer a, Integer b)
    {
        if(s.equals("+"))
        {return a+b;}
        else if(s.equals("-"))
        {return a-b;}
        if(s.equals("*"))
        {return a*b;}
        else
        {return a/b;}
    }
    
    
    public boolean isSymbol(String s)
    {
        String[] symbol = {"+", "-", "*", "/"};
        boolean result = false;
        for(String str: symbol)
        {
            if (str.equals(s))
            {
                result = true;
            }
        }
        return result;
        
    }
}
