package com.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by houzhaowei on 11/29/14.
 *
 * Greedy Algorithm
 */
public class DupKAway {

    private class CharCount implements Comparable<CharCount>{
        private char c;
        private int count;

        public CharCount(char c, int count){
            this.c = c;
            this.count = count;
        }

        public char getC() {
            return c;
        }

        public int getCount() {
            return count;
        }

        /**
         * adjust to Max heap (PriorityQueue in Java is a Min-Heap by default)
         * @param o
         * @return
         */
        @Override
        public int compareTo(CharCount o) {
            if (o.getCount() < this.count){
                return -1;
            } else if (o.getCount() < this.count){
                return 0;
            }else {
                return 1;
            }
        }
    }

    public String solution(String s, int k){
        char[] source = s.toCharArray();
        char[] target = new char[source.length];
        PriorityQueue<CharCount> pq = new PriorityQueue<CharCount>();
        Map<Character, Integer> tmp = new HashMap<Character, Integer>();
        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            Integer count = tmp.get(c);
            if (count != null){
                tmp.put(c, count + 1);
            } else {
                tmp.put(c, 1);
            }
        }

        Iterator<Character> it = tmp.keySet().iterator();
        while (it.hasNext()){
            char key = it.next();
            pq.add(new CharCount(key, tmp.get(key)));
        }

        int index = 0;
        int lastIndex = 0;
        while(!pq.isEmpty()){
            CharCount cc = pq.remove();
            int count = cc.getCount();
            char c = cc.getC();
            if (index >= k){
                if (count > 1){
                    return null;
                } else {
                    target[lastIndex] = c;
                    lastIndex ++;
                    continue;
                }
            }
            if (index < target.length){
                int innerIndex = index;
                while (innerIndex < target.length && count > 0){
                    target[innerIndex] = c;
                    System.out.println(c + " " + innerIndex);
                    // keep the maximum index
                    lastIndex = (innerIndex + 1) > lastIndex ? (innerIndex + 1) : lastIndex;
                    innerIndex += k;
                    count --;
                }
                // bad result
                if (index >= target.length || count > 0){
                    return null;
                }
            }
            index += 1;
        }

        return new String(target);
    }

    public static void main(String[] args){
        System.out.println(new DupKAway().solution("abbcadb", 2));
    }
}
