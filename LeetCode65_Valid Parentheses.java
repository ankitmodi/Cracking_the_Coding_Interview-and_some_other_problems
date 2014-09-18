public class Solution 
{
    public boolean isValid(String s) 
    {
        int len = s.length();
        Stack myStack = new Stack();
        
        for(int i=0; i<len; i++)
        {
            char tmp = s.charAt(i);
            switch(tmp)
            {
                
                case '(':
                    myStack.push(tmp);
                    break;
                case '{':
                    myStack.push(tmp);
                    break;
                case '[':
                    myStack.push(tmp);
                    break;
                case ')':
                        if(!myStack.empty() && myStack.peek()=='(')
                        {
                            myStack.pop();
                        }
                        else
                        {
                            return false;
                        }
                        break;
                case '}':
                        if(!myStack.empty() && myStack.peek()=='{')
                        {
                            myStack.pop();
                        }
                        else
                        {
                            return false;
                        }
                        break;
                case ']':
                        if(!myStack.empty() && myStack.peek()=='[')
                        {
                            myStack.pop();
                        }
                        else
                        {
                            return false;
                        }
                        break;
            }
        }
        
        return myStack.empty();
        
        
        
    }
}
