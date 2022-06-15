/*
*Group 1 - Sec 03
* Kiet Nguyen - 027353519
* Brian Bui - 027119493
* April 14 , 2022

Create a program that keeps track of the frequency of each of the words in a text file by using a TreeMap.Allow the user to search for a particular word to get its frequency or to display all of the words with each of their frequencies. Repeat the program until the user quits.

*Kiet worked on readfile, and search.

*Brian worked on display, and menu.
*/
import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) {
  
    int choice = menu();
  
    TreeMap<String, Integer> words = readFile();
    
    while (choice != 3) {
    
      if (choice == 1)
    
        search(words);
    
      else
    
        display(words);
    
        choice = menu();
    
    }
  
  }
  
// * return the map populated with each of the words in file words and the number of times each on appeared
// * Get old value when come accross duplicate word, increment it and put in the map aagain
// @param string and integer : word
  
  public static TreeMap<String, Integer> readFile() {
  
    TreeMap<String, Integer> words = new TreeMap<String, Integer>();
  
    try {
  
      Scanner read = new Scanner(new File("words.txt"));
  
      while (read.hasNext()) {
  
        String singleWord = read.nextLine();
  
        if (words.containsKey(singleWord)) {
  
          words.put(singleWord, (words.get(singleWord) + 1));
          }
  
        else {
  
          words.put(singleWord, 1);
          }
        }
      } 
    catch (FileNotFoundException fnf) {
      System.out.println("File not Found"); 
  }
    return words;
  
  }
/* pass in the map 
* ask user to enter a word
* display the word
* if the word the user enter is not in the map then display it the same format with a 0
@param string, integer : word


*/
  public static void search(TreeMap<String, Integer> words) {
  
    System.out.print("Enter Word: ");
  
    String wordToSearch = CheckInput.getString();
  
    if (words.containsKey(wordToSearch)) {
  
      System.out.println(wordToSearch + " => " + words.get(wordToSearch));
      } 
      
    else {
      System.out.println(wordToSearch + " => 0");
      }
  
  }
  /* pass in the map
* Display each of the words in the map with their frequencies
@param string, integer : word

*/
  public static void display(TreeMap<String, Integer> words) {
  
    Set<String> setOfKey = words.keySet();
  
    for (String key : setOfKey) {
  
    System.out.println(key + " => " + words.get(key));
      }
    }
  /* display the menu below to prompt the user to enter a menu option
* return the user’s valid input.

*/
  public static int menu() {
  
    System.out.println("1. Search\n2. Display\n3. Quit");
  
    return (CheckInput.getIntRange(1, 3));
    }
}