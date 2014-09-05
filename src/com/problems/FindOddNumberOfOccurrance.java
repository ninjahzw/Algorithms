package com.problems;

/**
 * Created by zhou001 on 8/26/2014.
 *
 * Problem:
 * Given an unsorted array that contains an odd number of occurrences for all numbers except one number, how would one find that number?
 *
 * Idea:
 * An \Theta(N) solution, which also requires \Theta(N) space:
 * Scan through the array and keep track of the parity
 * (not the actual count, since we only care if it is even or odd) of the count of each number.
 * Use a dictionary for amortized O(1) parity updates.
 *
 *
 *
 *
 *
 * Pseudo code:

 Given an unsorted array A,
 Let D be an empty dictionary

 # Populate a dictionary
 #this happens N times for an array of N elements.
 For each number n in A:
 if n not a key in D:
 D[n] = false
 #this takes amortized [math]O(1)[/math]  time for a hash table
 else:
 D[n] = not D[n]
 # [math]O(1)[/math]

 #Now the dictionary contains the parity of counts of all n in A.
 #Keys mapping to "true" occur an even number of times.
 #Scan it for the first occurrence of a "true", and return that key.
 For each n in A:
 if D[n] is true:
 return n


 #The problem statement guarantees that one number occurs an even number of times, so this line is unreachable
 assert unreachable


 */
public class FindOddNumberOfOccurrance {



    public static void main(String[] args){

    }
}
