/**
Word Split
Have the function WordSplit(strArr) read the array of strings stored in strArr, which will contain 2 elements: the first element will be a sequence of characters, and the second element will be a long string of comma-separated words, in alphabetical order, that represents a dictionary of some arbitrary length. For example: strArr can be: ["hellocat", "apple,bat,cat,goodbye,hello,yellow,why"]. Your goal is to determine if the first element in the input can be split into two words, where both words exist in the dictionary that is provided in the second input. In this example, the first element can be split into two words: hello and cat because both of those words are in the dictionary.

Your program should return the two words that exist in the dictionary separated by a comma. So for the example above, your program should return hello,cat. There will only be one correct way to split the first element of characters into two words. If there is no way to split string into two words that exist in the dictionary, return the string not possible. The first element itself will never exist in the dictionary as a real word.
Examples
Input: new String[] {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"}
Output: base,ball
Input: new String[] {"abcgefd", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"}
Output: abcg,efd
**/


import java.util.*; 
import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Main {

  public static String WordSplit(String[] strArr) {
    String sequence = strArr[0];
    String[] dictionary = strArr[1].split(",");

    for(String word1 : dictionary){
      if(sequence.startsWith(word1)){
        String word2 = sequence.substring(word1.length());
        if (isWordInDictionary(word2,dictionary)){
          return word1 + "," + word2;
        }
      }

    }
     return "not possible";
  
  }

  private static boolean isWordInDictionary(String word,String[]dictionay){
     for (String dictWord : dictionay){
       if (dictWord.equals(word)) return true;
     }
     return false;
  }



  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(WordSplit(s.nextLine())); 
  }

}
