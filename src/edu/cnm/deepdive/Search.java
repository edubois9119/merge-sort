package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.Random;

public class Search {

  int binarySearch(int[] arr, int needle) {
    int lowIndex = 0;
    int highIndex = arr.length;

    while (highIndex > lowIndex + 1) {
      int midIndex = (highIndex + lowIndex) / 2;
      if (arr[midIndex] == needle) {
        return midIndex;
      }
      if (arr[midIndex] < needle) {
        lowIndex = midIndex;
      } else {
        highIndex = midIndex;
      }
    }
    return (arr[lowIndex] == needle) ? lowIndex : ~lowIndex;  // ~n = -n -1 (~ = bitwise not)
  }

  int linearSearch(int[] arr, int needle) {
    for (int i = 0; i < arr.length ; i++) {
      if (arr[i] == needle){
        return i;
      }
    }
    return -1;
  }

  public static void main(String [] args){
    Search aSearch= new Search();
    Random rand = new Random();
    int arrSize= 10_000_000;

    double start;
    double end;
    int index;

    int [] arr = new int[arrSize];
    for (int i = 0; i < arr.length; i++) {
      int randInt= rand.nextInt(arrSize);
      arr[i] = randInt;
    }

    int [] needle = new int[10000];
    for (int i = 0; i < needle.length; i++) {
      int randInt = rand.nextInt(arrSize);
      needle[i] = randInt;
    }

    start = System.nanoTime();
    for(int target : needle){
      index = aSearch.linearSearch(arr, target);
    }
    end= System.nanoTime();
    System.out.println("Time:" + (end-start) / 1_000_000_000f);
//    if(index == -1){
//      System.out.println("The number does not exist");
//    }else{
//      System.out.println("The number was found at index: " + index);
//    }

    start = System.nanoTime();
    Arrays.sort(arr);
    end= System.nanoTime();
    System.out.println("Print sort time" + (end-start) / 1_000_000_000f);

    start = System.nanoTime();
    for (int target : needle){
      index = aSearch.linearSearch(arr, target);
    }
    end= System.nanoTime();
    System.out.println("Time:" + (end-start) / 1_000_000_000f);
//    if(index == -1){
//      System.out.println("The number does not exist");
//    }else{
//      System.out.println("The number was found at index: " + index);
//
//    }
    start = System.nanoTime();
    for (int target : needle){
//      index = aSearch.binarySearch(arr, target);
      index = Arrays.binarySearch(arr, target);
    }
    end= System.nanoTime();
    System.out.println("Time:" + (end-start) / 1_000_000_000f);
  }
}


