/*Find all the permutations of a string in Java.
For example: The String "ABC" should produce:
ABC ACB BAC BCA CAB CBA*/

import java.util.*;
public class HelloWorld
{

     public static void main(String []args)
     {
        System.out.println("Hello World");
        List mylist = new ArrayList<String>();
        mylist = permutations("", "ABCD", mylist);
        System.out.println(mylist);
     }
     
     public static List<String> permutations(String prefix, String str, List<String> mylist)
     {
         int n = str.length();
         if(n ==0)
         {
             mylist.add(prefix);
         }
         else
         {
             for (int i=0; i<n; i++)
             {
                 permutations(prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1), mylist);
             }
         }
         return mylist;
     }
}
