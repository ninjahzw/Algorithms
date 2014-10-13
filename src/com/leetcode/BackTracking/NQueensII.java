package com.leetcode.BackTracking;

/**
 * Created by houzhaowei on 9/17/14.
 */
public class NQueensII {
    public int totalNQueens(int n) {
        if (n <= 0)
            return 0;
        int[] perm = new int[n];
        slove(perm, 0, n);

        return count;
    }

    private int count = 0;

    private void slove(int[] perm, int cur, int n) {
        if (cur == n) {
            count++;
        } else {
            int i;
            for (i = 0; i < n; i++) {
                int j;
                boolean ok = true;
                for (j = 0; j < cur; j++) {
                    if (perm[j] == i || perm[j] - j == i - cur
                            || perm[j] + j == i + cur)
                        ok = false;
                }
                if (ok) {
                    perm[cur] = i;
                    slove(perm, cur + 1, n);
                }

            }

        }

    }

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(4));

    }
}
