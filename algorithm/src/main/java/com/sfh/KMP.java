package com.sfh;

import javax.swing.tree.TreeNode;

/**
 * @user sfh
 * @date 2021/11/23 17:59
 */
public class KMP {

    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 构建状态转移图（稍改的更紧凑了）
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[X][c];
            }
            dp[j][pat.charAt(j)] = j + 1;
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
        }
    }

    public void printDp(){
        int M = pat.length();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 256; j++) {
                System.out.print(" "+dp[i][j]);
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        KMP kmp = new KMP("ababbabac");
    kmp.printDp();
    }
}
