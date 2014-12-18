package com.interview;/* Enter your code here. Read input from STDIN. Print output to STDOUT */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/**
 * for each racer, my approach will do a binary search, so the time complexity is O(n(logn))
 */
public class Solution {

    static class Racer implements Comparable<Racer>{
        long id;
        long start;
        long finish;
        
        public Racer (long id, long start, long finish){
            this.id = id;
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Racer o) {
            if (this.start == o.start) {
                return 0;
            }
            if (this.start > o.start) {
                return 1;
            }
            return -1;
        }
    }

    static class Node {
        Racer racer;
        Node left;
        Node right;
        Racer finishTimes[];
        Racer max;

        Node(Node left, Node right, Racer racer) {
            this.left = left;
            this.right = right;
            this.racer = racer;
        }
    }



    public Node createTreeBottomUp(List<Node> nodes){
        System.out.println(nodes.size());
        // already in root level
        if (nodes.size() == 1) {
            return nodes.get(0);
        }
        List<Node> list = new ArrayList<Node>();
        int i;
        for (i = 0; i < nodes.size() - 1; i += 2) {
            Node node = new Node(nodes.get(i), nodes.get(i + 1), nodes.get(i).max);
            node.max = nodes.get(i + 1).max;
            int lengthLeft = nodes.get(i).finishTimes.length;
            int lengthRight = nodes.get(i + 1).finishTimes.length;
            node.finishTimes = new Racer[lengthLeft + lengthRight];
            // Merge the finish time of the children to current node in SORTED order
            int j = 0, k = 0, l = 0;
            while (j < lengthLeft && k < lengthRight) {
                if (nodes.get(i).finishTimes[j].finish <= nodes.get(i + 1).finishTimes[k].finish) {
                    node.finishTimes[l] = nodes.get(i).finishTimes[j];
                    l++; j++;
                } else {
                    node.finishTimes[l] =  nodes.get(i + 1).finishTimes[k];
                    l++; k++;
                }
            }
            while (j < lengthLeft) {
                node.finishTimes[l] = nodes.get(i).finishTimes[j];
                l++; j++;
            }
            while (k < lengthRight) {
                node.finishTimes[l] = nodes.get(i + 1).finishTimes[k];
                l++; k++;
            }
            // add the new node to the new list and go to next iteration.
            list.add(node);
        }
        if (i != nodes.size()) {
            list.add(nodes.get(i));
        }
        // recursively build a binary tree using bottom-up strategy
        return createTreeBottomUp(list);
    }

    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
    public long calculate(Node root, long low, long high, long currentLow, long currentHigh) {

        if (root == null || currentLow > currentHigh) {
            return 0;
        }
        if (isLeaf(root)) {
            if (root.racer.start > low && root.racer.start < high) {
                if (root.racer.finish > low && root.racer.finish < high) {
                    return 1;
                }
            }
            return 0;
        }

        if (currentLow >= low && currentHigh <= high) {
            int index1 = Arrays.binarySearch(root.finishTimes, new Racer( -1, -1, low), new Comparator<Racer>() {
                @Override
                public int compare(Racer o1, Racer o2) {
                    if (o1.finish == o2.finish) {
                        return 0;
                    }
                    if (o1.finish > o2.finish) {
                        return 1;
                    }
                    return -1;
                }
            });
            int index2 = Arrays.binarySearch(root.finishTimes, new Racer( -1, -1, high), new Comparator<Racer>() {
                @Override
                public int compare(Racer o1, Racer o2) {
                    if (o1.finish == o2.finish) {
                        return 0;
                    }
                    if (o1.finish > o2.finish) {
                        return 1;
                    }
                    return -1;
                }
            });
            if (index1 >= 0 && index2 >= 0) {
                int val = index2 - index1 - 1;
                return val >= 0 ? val : -val;
            }
            if (index1 < 0 && index2 >= 0) {
                index1 = index1 * -1 - 1;
                int val = index2 - index1;
                return val >= 0 ? val : -val;
            }
            if (index1 >= 0 && index2 < 0) {
                index2 = index2 * -1 - 1;
                int val = index2 - index1 - 1;
                return val >= 0 ? val : -val;
            }
            if (index1 < 0 && index2 < 0) {
                index2 = index2 * -1 - 1;
                index1 = index1 * -1 - 1;
                int val = index2 - index1;
                return val >= 0 ? val : -val;
            }
        }
        if (root.racer.start >= low && root.racer.start < high) {
            return calculate(root.left, low, high, currentLow,root.racer.start)
                    + calculate(root.right, low, high, root.racer.start,currentHigh);
        }
        if (root.racer.start < high) {
            return calculate(root.right, low, high, root.racer.start,currentHigh);
        }
        if (root.racer.start >= low) {
            return calculate(root.left, low, high, currentLow,root.racer.start);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int n = Integer.parseInt(line);
        List<Racer> racers = new ArrayList<Racer>();
        while ((line = br.readLine()) != null) {
            String[] elements = line.split(" ");
            Racer racer = new Racer(Long.parseLong(elements[0]), Long.parseLong(elements[1]), Long.parseLong(elements[2]));
            racers.add(racer);
        }
        // Sort the racers by start time
        Collections.sort(racers);
        List<Node> nodes = new ArrayList<Node>(racers.size());
        for (Racer racer : racers){
            Node node = new Node(null, null, racer);
            node.max = racer;
            node.finishTimes = new Racer[1];
            node.finishTimes[0] = racer;
            nodes.add(node);
        }

        Node root = solution.createTreeBottomUp(nodes);

        Map<Long,Long> result = new TreeMap<Long, Long>();
        for (Racer racer : racers){
            long score = solution.calculate(root, racer.start, racer.finish, Long.MIN_VALUE, Long.MAX_VALUE);
            result.put(score, racer.id);
        }

        Iterator it = result.keySet().iterator();
        while (it.hasNext()){
            Long key = (Long)it.next();
            System.out.println(result.get(key) + " " + key);
        }

    }
}