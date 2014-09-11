package com.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

 Pseudo code:

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
 *
 * -------------------------------------------
 * If the problem changes to even occurrence of all numbers except one, then it's better to solve problem this way:
 *
 * using bitwise operation (see findEvenOccurance_1):
 * Apply XOR operation among all elements,
 * the odd number occurrence numbers will end up with 0 after the XOR operation among them.
 * there is only one number have even occurrence and we can divide them to an odd occurrence plus one.
 * so after the XOR calculation we only have the 'one' we want, which will be the final result.
 *
 *
 */
public class FindOddNumberOfOccurrance {

    public int findEvenOccurance(int A[]){
        Map<Integer,Boolean> dict = new HashMap<Integer, Boolean>();
        for (int i = 0; i < A.length; i++){
            if (dict.get(A[i]) == null){
                dict.put(A[i],true);
                continue;
            }
            dict.put(A[i],!dict.get(A[i]));
        }
        System.out.println(dict);
        Iterator<Integer> it = dict.keySet().iterator();
        while (it.hasNext()){
            int key = it.next();
            Boolean one = dict.get(key);
            if (one == false){
                return key;
            }
        }
        return -1;
    }

    /**
     * use this solution if the problem changes to
     * even occurrence of all numbers except one.
     * @param A
     * @return
     */
    public int findEvenOccurance_1(int A[]){
        int result = 0;
        for (int i = 0; i < A.length; i++){
            result ^= A[i];
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new FindOddNumberOfOccurrance().findEvenOccurance(new int[]{1, 1, 1, 3, 3, 3, 4, 4, 5, 5, 5, 7, 7, 7}));
    }
}
