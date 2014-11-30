package com.problems;

import java.io.*;
import java.util.*;

/**
 * Problem:
 * 10 most common word in a text file
 *
 * Unix command to solve this problem
 * tr -c '[:alnum:]' '[\n*]' < test.txt | sort | uniq -c | sort -nr | head  -10
 *
 * Idea:
 * NOTE: compareTo method returns -1,0,1
 * Use priority queue to retrieve the top 10.
 */
public class TopTenWords {

    private class Word implements Comparable{
        private int count;
        private String word;

        public Word(String word, int count){
            this.count = count;
            this.word = word;
        }

        public String getWord() {
            return word;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int compareTo(Object o) {
            Word w = (Word)o;
            if (this.count > w.count){
                return 1;
            } else if (this.getCount() == w.getCount()){
                return 0;
            }
            return -1;
        }
    }

    public void top10(){
        PriorityQueue<Word> pq = new PriorityQueue<Word>();
        Map<String,Integer> map = new HashMap<String, Integer>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Users/houzhaowei/files"));
            String line = br.readLine();
            while (null != line){
                if (map.get(line) != null){
                    int count = map.get(line);
                    map.put(line,count + 1);
                } else {
                    map.put(line,1);
                }
                line = br.readLine();
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if (null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()){
            String key = it.next();
            Word word = new Word(key,map.get(key));
            pq.add(word);
            if (pq.size() >= 10){
                pq.remove();
            }
        }

        // print the result in pq order
        while (pq.size() > 0){
            Word one = pq.remove();
            System.out.print(one.getWord() + "-" + one.getCount() + "\n");
        }
    }

    public static void main(String[] args){
        new TopTenWords().top10();
    }

}
