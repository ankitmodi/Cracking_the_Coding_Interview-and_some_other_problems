//Implement a function in C/C++ which reverses a null-terminated string

#include <stdio.h>
#include <string.h>


void swap(char* str, int a, int b)
{
    char tmp = str[a];
    str[a] = str[b];
    str[b] = tmp;
}



void reverse(char *str)
{
    int len = strlen(str);
    int mid_len = len / 2;
    int i ;
    for(i =0; i< mid_len; i++){
        swap(str, i, len-1-i);
    }
    
}



int main ()
{
   char str[6] = "abcde\0";

   printf("Message: %s\n", str );
   
   reverse(str);
   printf("Message reversed: %s\n", str );

   return 0;
}
