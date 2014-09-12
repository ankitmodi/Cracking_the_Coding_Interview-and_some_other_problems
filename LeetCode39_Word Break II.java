/*
 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]. 
*/


public class Solution 
{
    public List<String> wordBreak(String s, Set<String> dict) 
    {
        int len = s.length();
        List<String> res = new ArrayList<String>();
        
        if(!isWordBreak(s, dict))
        {
            return res;
        }
        
        
        List<List<Integer>> checkTillIndex = wordBreakHelper(s, dict);
        
        
        getResult("", s, checkTillIndex, res, len);
        
        return res;
    }
    
    
    public void getResult(String str, String s, List<List<Integer>> checkTillIndex, List<String> res, int i)
     {
         if(i==0)
         {
             res.add(str);
         }
         else
         {
             List<Integer> temp = checkTillIndex.get(i);
             for(int j=0; j< temp.size(); j++)
             {
                 int c = temp.get(j);
                 String k = s.substring(c, i);
                 if(str.isEmpty())
                 {
                     getResult(k, s, checkTillIndex, res, c);
                 }
                 else
                 {
                     getResult(k + " " + str, s, checkTillIndex, res, c);
                 }
             }
         }
     }
    
    
    
    
    public List<List<Integer>> wordBreakHelper(String s, Set<String> dict) 
    {
        int len = s.length();
        List<List<Integer>> checkTillIndex = new ArrayList<List<Integer>>();
        
        
        List<Integer> a_0 = new ArrayList<Integer>();
        a_0.add(0);
        checkTillIndex.add(a_0);
        
        
        for(int i =1; i< len+1; i++)
        {
            List<Integer> a = new ArrayList<Integer>();
            checkTillIndex.add(a);
        }
        
        for(int i=0; i<len; i++)
        {
            if(checkTillIndex.get(i).isEmpty())
            {
                continue;
            }
            
            for(String word: dict)
            {
                int wordLen = word.length();
                int end = i + wordLen ;
                
                if(end > len)
                {
                    continue;
                }
                //if(!checkTillIndex.get(end).isEmpty())
                //{
                  //  continue;
                //}
                if(s.substring(i, end).equals(word))
                {
                    checkTillIndex.get(end).add(i);
                }
            }
        }
        return checkTillIndex;
    }
    
    
    public boolean isWordBreak(String s, Set<String> dict) 
    {
        int len = s.length();
        boolean[] checkTillIndex = new boolean[len+1];
        
        checkTillIndex[0] = true;
        
        for(int i=0; i<len; i++)
        {
            if(!checkTillIndex[i])
            {
                continue;
            }
            
            for(String word: dict)
            {
                int wordLen = word.length();
                int end = i + wordLen ;
                
                if(end > len)
                {
                    continue;
                }
                if(checkTillIndex[end])
                {
                    continue;
                }
                if(s.substring(i, end).equals(word))
                {
                    checkTillIndex[end] = true;
                }
            }
        }
        return checkTillIndex[len];
    }
}
