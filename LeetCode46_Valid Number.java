/*Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. */

public class Solution 
{
    public boolean isNumber(String s) 
    {
        if(s.isEmpty())
        {
            return false;
        }
        String pattern = "\\s*[+-]?((\\.\\d+)|(\\d+(\\.\\d*)?))(e[+-]?\\d+)?\\s*";
        return s.matches(pattern);
    }
}
