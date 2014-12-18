package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class RangeMin_2_d {

        List<Info> sortedTimes;
        Node treeRoot;

        public long calculateScore(long low, long high) {
                return csHelper(this.treeRoot, low, high, Long.MIN_VALUE,
                                Long.MAX_VALUE);
        }

        public long csHelper(Node root, long low, long high, long currentLow,
                        long currentHigh) {
                if (root == null || currentLow > currentHigh) {
                        return 0;
                }
                if (isLeaf(root)) {
                        if (root.el.startTime > low && root.el.startTime < high) {
                                if (root.el.finishTime > low && root.el.finishTime < high) {
                                        return 1;
                                }
                        }
                        return 0;
                }
                if (currentLow >= low && currentHigh <= high) {
                        int index1 = Arrays.binarySearch(root.sortedFinishTime, new Info(
                                        -1, -1, low), new InfoFTComp());
                        int index2 = Arrays.binarySearch(root.sortedFinishTime, new Info(
                                        -1, -1, high), new InfoFTComp());
                        if (index1 >= 0 && index2 >= 0) {
                                return getZeroOrPostv(index2 - index1 - 1);
                        }
                        if (index1 < 0 && index2 >= 0) {
                                index1 = index1 * -1 - 1;
                                return getZeroOrPostv(index2 - index1);
                        }
                        if (index1 >= 0 && index2 < 0) {
                                index2 = index2 * -1 - 1;
                                return getZeroOrPostv(index2 - index1 - 1);
                        }
                        if (index1 < 0 && index2 < 0) {
                                index2 = index2 * -1 - 1;
                                index1 = index1 * -1 - 1;
                                return getZeroOrPostv(index2 - index1);
                        }
                }
                if (root.el.startTime >= low && root.el.startTime < high) {
                        return csHelper(root.leftChild, low, high, currentLow,
                                        root.el.startTime)
                                        + csHelper(root.rightChild, low, high, root.el.startTime,
                                                        currentHigh);
                }
                if (root.el.startTime < high) {
                        return csHelper(root.rightChild, low, high, root.el.startTime,
                                        currentHigh);
                }
                if (root.el.startTime >= low) {
                        return csHelper(root.leftChild, low, high, currentLow,
                                        root.el.startTime);
                }
                return 0;
        }

        private int getZeroOrPostv(int val) {
                return val >= 0 ? val : -val;
        }

        @SuppressWarnings("unchecked")
        public void createTree(List<Info> times) {
                sortedTimes = new ArrayList<Info>(times.size());
                for (Info el : times) {
                        sortedTimes.add(el);
                }
                Collections.sort(sortedTimes, new InfoSTComp());
                // System.out.println("Sorted Times List " + sortedTimes);
                List<Node> leafNodes = new ArrayList<Node>();
                for (Info el : sortedTimes) {
                        Node newNode = new Node(null, null, el);
                        newNode.maxEl = el;
                        newNode.sortedFinishTime = new Info[1];
                        newNode.sortedFinishTime[0] = el;
                        leafNodes.add(newNode);
                }
                Node root = createTreeHelper(leafNodes);
                // addLeafNodes(root);
                this.treeRoot = root;
        }

        private Node createTreeHelper(List<Node> nodes) {
                if (nodes.size() == 1) {
                        return nodes.get(0);
                }
                List<Node> newList = new ArrayList<Node>();
                int i = 0;
                for (i = 0; i < nodes.size() - 1; i += 2) {
                        Node newNode = new Node(nodes.get(i), nodes.get(i + 1),
                                        nodes.get(i).maxEl);
                        newNode.maxEl = nodes.get(i + 1).maxEl;
                        newNode.sortedFinishTime = new Info[nodes.get(i).sortedFinishTime.length
                                        + nodes.get(i + 1).sortedFinishTime.length];
                        merge(nodes.get(i).sortedFinishTime,
                                        nodes.get(i + 1).sortedFinishTime, newNode.sortedFinishTime);
                        newList.add(newNode);
                }
                if (i != nodes.size()) {
                        newList.add(nodes.get(i));
                }
                return createTreeHelper(newList);
        }

        private void merge(Info[] array1, Info[] array2, Info[] result) {
                int j = 0, k = 0, l = 0;
                while (j < array1.length && k < array2.length) {
                        if (array1[j].finishTime <= array2[k].finishTime) {
                                result[l++] = array1[j];
                                ++j;
                        } else {
                                result[l++] = array2[k];
                                ++k;
                        }
                }
                while (j < array1.length) {
                        result[l++] = array1[j++];
                }
                while (k < array2.length) {
                        result[l++] = array2[k++];
                }
        }

        private boolean isLeaf(Node node) {
                return (node.leftChild == null && node.rightChild == null);
        }

        public static void main(String args[]) {
                Scanner scan = new Scanner(System.in);
                int count = scan.nextInt();
                List<Info> times = new ArrayList<Info>();
                while (count > 0) {
                        times.add(new Info(scan.nextLong(), scan.nextLong(), scan
                                        .nextLong()));
                        --count;
                }
                RangeMin_2_d obj = new RangeMin_2_d();
                obj.createTree(times);
                List<Result> resultList = new ArrayList<Result>();
                for (Info el : times) {
                        resultList.add(new Result(el, obj.calculateScore(el.startTime,
                                        el.finishTime)));
                }
                Collections.sort(resultList, new Comparator<Result>() {
                        public int compare(Result a, Result b) {
                                if (a.score == b.score) {
                                        return (int) (a.info.id - b.info.id);
                                } else {
                                        return (int) (a.score - b.score);
                                }
                        }
                });

                for (Result r : resultList) {
                        System.out.println(r.info.id + " " + r.score);
                }

        }

}

class Result {
        Info info;
        long score;

        Result(Info inf, long s) {
                this.info = inf;
                this.score = s;
        }
}

class Node {
        Node leftChild;
        Node rightChild;
        Info el;
        Info sortedFinishTime[];
        Info maxEl;

        Node(Node lChild, Node rChild, Info e) {
                this.leftChild = lChild;
                this.rightChild = rChild;
                this.el = e;
        }
}

class InfoSTComp implements Comparator<Info> {
        public int compare(Info a, Info b) {
                if (a.startTime == b.startTime) {
                        return 0;
                }
                if (a.startTime > b.startTime) {
                        return 1;
                }
                return -1;
        }
}

class InfoFTComp implements Comparator<Info> {
        public int compare(Info a, Info b) {
                if (a.finishTime == b.finishTime) {
                        return 0;
                }
                if (a.finishTime > b.finishTime) {
                        return 1;
                }
                return -1;
        }
}

class Info {
        long startTime;
        long finishTime;
        long id;

        Info(Info info) {
                this.startTime = info.startTime;
                this.finishTime = info.finishTime;
                this.id = info.id;
        }

        Info(long id, long startTime, long finishTime) {
                this.id = id;
                this.startTime = startTime;
                this.finishTime = finishTime;
        }

        public String toString() {
                return "id " + this.id + " startTime " + this.startTime
                                + " finishTime " + this.finishTime;
        }

}