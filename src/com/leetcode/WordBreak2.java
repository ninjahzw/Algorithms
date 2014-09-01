package com.leetcode;

import java.util.*;

/**
 * Created by Hou Zhaowei on 8/28/14.
 *
 * Importance: 5 stars!
 *
 * Problem:
 *
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 *
 *
 *
 * Solution:
 *
 * for this example,
 * before the assemblage, the result in the tmp storage is:
 * -----  0   -------   []
 * -----  1   -------   []
 * -----  2   -------   [-1]
 * -----  3   -------   [-1]
 * -----  4   -------   []
 * -----  5   -------   []
 * -----  6   -------   [2, 3]
 * -----  7   -------   []
 * -----  8   -------   []
 * -----  9   -------   [6]
 * this is a tree structure rooted at [9]
 * the element of 2 and 3 is -1 because the string to 2 and 3 start from 0 which is next to -1.
 *
 *
 */
public class WordBreak2 {

    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        // the extra storage stores all possible paths from previous chars to current index.
        ArrayList<LinkedList<Integer>> tmp = new ArrayList<LinkedList<Integer>>();

        // initialize the array
        for (int i = 0; i < s.length(); i++){
            LinkedList<Integer> one = new LinkedList<Integer>();
            tmp.add(one);
        }

        int START_POSITION = 0;
        // Stage 1 : process stage
        for (int i = START_POSITION; i < s.length(); i++){
            // the substring from 0 to current index should always be calculated
            if (dict.contains(s.substring(START_POSITION, i+1))) {
                tmp.get(i).add(START_POSITION - 1);// NOTE, here is -1, not 0.
            }

            for (int j = 0; j < i; j ++) {
                LinkedList l = tmp.get(j);
                if (l != null && l.size() != 0) {
                    if (dict.contains(s.substring(j+1,i+1))){ // means we can go to i through j.
                        tmp.get(i).add(j);
                    }
                }

            }
        }

        if (tmp.get(s.length() - 1).size() == 0){ // no reach to the end of the string
            return result;
        }

        for (int i = 0 ; i < tmp.size(); i++){
            System.out.println("-- " + i + " -- " + tmp.get(i));
        }

        // stage 2 : assemble stage
        // assemble the result by the temp storage (previous result)
        this.assemble(tmp, s.length() - 1, result, s, "");
        return result;
    }

    /**
     * This is like recursively traversing a tree,
     * for each child node of current node, assign it a copy of current string.
     *
     * @param tmp the result after DP
     * @param i the start point (root) of the recursion
     * @param result final result
     * @param original original string
     * @param current current result string of current node
     */
    private void assemble(ArrayList<LinkedList<Integer>> tmp, int i, List<String> result, String original, String current){
        LinkedList<Integer> ll = tmp.get(i);
        System.out.println("--> " + ll);
        for (int one : ll){
            // make sure for each recursion, the method get a new string
            String s = current;
            String word = original.substring(one+1, i+1);
            s = s.equals("") ? word : word + " " + s;
            if (one == -1){
                result.add(s);
                continue; // NOTE, here is continue, not return!
            }
            assemble(tmp,one,result,original,s);
        }
    }

    public static void main(String[] args){
//        Set<String> dict = new HashSet<String>();
//        dict.add("cat");
//        dict.add("cats");
//        dict.add("and");
//        dict.add("sand");
//        dict.add("dog");
//        String s = "catsanddog";
//        new WordBreak2().wordBreak(s,dict);
        Set<String> dict = new HashSet<String>();
        dict.add("aaaa");
        dict.add("aa");
        dict.add("a");

        String s = "aaaaaaa";
        System.out.println(new WordBreak2().wordBreak(s,dict));
    }

}
